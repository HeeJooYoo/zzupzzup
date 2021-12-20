package com.zzupzzup.service.review;

import java.util.List;
import java.util.Map;

import com.zzupzzup.common.Search;
import com.zzupzzup.service.domain.Review;

public interface ReviewService {
	
	public int addReview(Review review) throws Exception;
	
	public int updateReview(Review review) throws Exception;
	
	public int deleteReview(int reviewNo) throws Exception;
	
	public Review getReview(int reviewNo) throws Exception;
	
	public Map<String, Object> listReview(Search search, String restaurantNo) throws Exception; //restaurantNo가 null이라면 관리자가 전체 리뷰 확인

	public Map<String, Object> listMyReview(Search search, String memberId) throws Exception; //해보기 
	
	public Map<String, Object> listMyLikeReview(Search search, String memberId) throws Exception;
	
	public List<String> listHashTag(String search) throws Exception;
	
	public int addLike(String memberId, int reviewNo) throws Exception;
	
	public int deleteLike(String memeberId, int reviewNo) throws Exception;
}
