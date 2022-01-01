package com.zzupzzup.web.reservation;

import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zzupzzup.common.Page;
import com.zzupzzup.common.Search;
import com.zzupzzup.service.chat.ChatService;
import com.zzupzzup.service.domain.Chat;
import com.zzupzzup.service.domain.Member;
import com.zzupzzup.service.domain.Reservation;
import com.zzupzzup.service.domain.Review;
import com.zzupzzup.service.member.MemberService;
import com.zzupzzup.service.reservation.ReservationService;
import com.zzupzzup.service.restaurant.RestaurantService;

@Controller
@RequestMapping("/reservation/*")
public class ReservationController {
	
	//Field
	@Autowired
	@Qualifier("reservationServiceImpl")
	private ReservationService reservationService;
	
	@Autowired
	@Qualifier("chatServiceImpl")
	private ChatService chatService;
	
	@Autowired
	@Qualifier("restaurantServiceImpl")
	private RestaurantService restaurantService;
	
	@Autowired
	@Qualifier("memberServiceImpl")
	private MemberService memberService;
	
	public ReservationController() {
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize; // 미니프로젝트보고 따라한것.
	
	
	@RequestMapping( value="addReservation", method=RequestMethod.GET )
	public String addReservation(@RequestParam("chatNo") int chatNo, Model model) throws Exception{
	
		System.out.println("/reservation/addReservation : GET");
		
		Reservation reservation = new Reservation();
		Member member = new Member();
	
		reservation.setChat(chatService.getChat(chatNo));
		reservation.setRestaurant(restaurantService.getRestaurant(reservation.getChat().getChatRestaurant().getRestaurantNo()));
		System.out.println("dfsfsdffsd"+reservation.getChat().getChatLeaderId());
		
		
		member = memberService.getMember(reservation.getChat().getChatLeaderId());
		reservation.setMember(member);
		
		System.out.println(member+"member~~~~~~~");
		
		System.out.println(reservation);
		model.addAttribute("reservation", reservation);
		
		return "forward:/reservation/addReservationView.jsp";
	}
	
	//@RequestMapping( value="addReservation", method=RequestMethod.POST )
	//public String addReservation ( @ModelAttribute("reservation") Reservation reservation, Model model ) throws Exception {

	//	System.out.println("/reservation/addReservation : POST");
		//Business Logic
	//	reservationService.addReservation(reservation);
	//	System.out.println("/reservation/addReservation22222 : POST");
	//	return "redirect:/reservation/listReservation";
	//}
	//컨트롤러로 하면 안되고 레스트 타야됨 add 안할거면 controller는 성공하기도 전에 리턴해버림
//==================================================================================================
	//질문
	@RequestMapping( value="getReservation", method=RequestMethod.GET )
	public String getReservation( @RequestParam("reservationNo") int reservationNo , Model model ) throws Exception {
		
		System.out.println("/reservation/getReseration : GET");
		//Business Logic
		Reservation reservation = reservationService.getReservation(reservationNo);
		// Model 과 View 연결
		model.addAttribute("reservation", reservation);
		
		
		Member member = new Member();
		Chat chat = new Chat();
		
		chat = chatService.getChat(reservation.getChat().getChatNo());
		
		
		reservation.setChat(chat);
		reservation.setRestaurant(restaurantService.getRestaurant(reservation.getChat().getChatRestaurant().getRestaurantNo()));
		System.out.println("dfsfsdffsd"+reservation.getChat().getChatLeaderId());
		
		
		member = memberService.getMember(reservation.getChat().getChatLeaderId());
		reservation.setMember(member);
		
		System.out.println(member+"member~~~~~~~");
		
		System.out.println(reservation);
		model.addAttribute("reservation", reservation);
		
		return "forward:/reservation/getReservation.jsp";
	}
	
	
	
//==================================================================================================	
	//질문
	@RequestMapping( value="updateReservation", method=RequestMethod.GET )
	public String updateUser( @RequestParam("reservationNo") int  reservationNo , Model model ) throws Exception{

		System.out.println("/reservation/updateReseration : GET");
		//Business Logic
		Reservation reservation = reservationService.getReservation(reservationNo);
		// Model 과 View 연결
		model.addAttribute("reservation", reservation);
		
		return "forward:/reservation/updateReservation.jsp";
	}

//==================================================================================================	
	
	@RequestMapping(value="listReservation")
	public String listReservation(HttpServletRequest request, @ModelAttribute Search search, Model model, HttpSession session) throws Exception {
		
		System.out.println("/reservation/listReservation");
		
		String restaurantNo = request.getParameter("restaurantNo");
		Member member = (Member) session.getAttribute("member");
		
		String memberId = null;
		
		
		
		System.out.println(restaurantNo+"::restaurantNo~~~~~");
		System.out.println(member+"::member~~~~~");
	
		
		if (search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}
		
		System.out.println(search.getCurrentPage() + ":: currentPage");
		
		search.setPageSize(pageSize);
		
		Map<String, Object> map = null;
		
		if (member != null && member.getMemberRole().equals("admin")) {
			map = reservationService.listReservation(search, restaurantNo);
			System.out.println("listReservation admin");
		} else {
			map = reservationService.listMyReservation(search, member, restaurantNo);
			System.out.println("listMyReservation");
		}
		
		Page resultPage = new Page(search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		
		model.addAttribute("list", map.get("list"));
		model.addAttribute("search", search);
		model.addAttribute("totalCount", map.get("totalCount"));
		model.addAttribute("avgTotalScope", map.get("avgTotalScope"));
		model.addAttribute("resultPage", resultPage);
		
		return "forward:/reservation/listReservation.jsp";	
	}
//==================================================================================================
	
	   @RequestMapping(value="sendPhoneMessage", method=RequestMethod.POST)
	   public void sendMessage(@RequestBody String phone, String text) throws Exception{
	      
	     // Random rand  = new Random();
	        
	      //  String numStr = "";
	        
	     //   for(int i=0; i<4; i++) {
	           
	      //      String num = Integer.toString(rand.nextInt(10));
	            
	      //      numStr += num;
	      //  }     
	        
	       // session.setAttribute(phone, numStr);
	        
	        reservationService.sendMessage(phone, text);
	   }

}
