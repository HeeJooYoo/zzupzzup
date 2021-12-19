package com.zzupzzup.service.domain;

import java.util.Date;
import java.util.List;

import com.zzupzzup.common.util.CommonUtil;

public class Member {
	
	//*Field
	private String memberId;			//아이디
	private String password;			//비밀번호
	private String nickname;			//닉네임
	private String memberRole;			//회원 유형(user, owner, admin)
	private String memberName;			//이름
	private String memberPhone;			//번호1+번호2+번호3 저장
	private String memberPhone1;		//번호1
	private String memberPhone2;		//번호2
	private String memberPhone3;		//번호3
	private String ageRange;			//연령대(10대, 20대, 30대, 40대, 50대, 60대 이상)
	private String gender;				//성별(여자/남자)
	private String birth;			//생일(생년만 추출)
	private String profileImage;		//프로필 이미지
	private String statusMessage;		//자기소개 및 특이사항(= 상태메세지)
	private String pushNickname;		//추천인 닉네임
	private String deleteReason;		//탈퇴 사유
	private Date accumulDate;			//활동점수 적립일
	private String accumulContents;		//활동점수 적립 내용
	private int accumulScore;			//활동점수 적립 점수
	private int mannerScore;			//매너점수
	private String memberRank;			//등급(쩝린이, 쩝쩝학사, 쩝쩝석사, 쩝쩝박사)
	private int accumulAllScore;		//총 활동점수
	private int mannerAllScore;			//총 매너점수
	private Date regDate;				//가입일
	private boolean eliminated;			//탈퇴 여부
	private Date deleteDate;			//탈퇴일
	private Date blacklistDate;			//블랙리스트 등록일
	private int reportCount;			//신고 횟수
	private String certificatedNum;		//인증번호
	private int loginType;				//로그인 유형(일반, 카카오, 네이버)
	private int deleteType;				//탈퇴 유형(서비스 이용 X, 타 사이트 이용, 탈퇴 후 재가입, 기타)
	private List<Restaurant> listRegRestaurant;	//업주의 경우에 상세조회에서 표시될 음식점 수

	//*Constructor
	public Member() {
		// TODO Auto-generated constructor stub
	}

	//*Method
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMemberRole() {
		return memberRole;
	}

	public void setMemberRole(String memberRole) {
		this.memberRole = memberRole;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberPhone1() {
		return memberPhone1;
	}

	public void setMemberPhone1(String memberPhone1) {
		this.memberPhone1 = memberPhone1;
	}

	public String getMemberPhone2() {
		return memberPhone2;
	}

	public void setMemberPhone2(String memberPhone2) {
		this.memberPhone2 = memberPhone2;
	}

	public String getMemberPhone3() {
		return memberPhone3;
	}

	public void setMemberPhone3(String memberPhone3) {
		this.memberPhone3 = memberPhone3;
	}

	public String getAgeRange() {
		if(birth != null) {
			ageRange = CommonUtil.returnAgeRange(birth);
		}
		return ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getPushNickname() {
		return pushNickname;
	}

	public void setPushNickname(String pushNickname) {
		this.pushNickname = pushNickname;
	}

	public String getDeleteReason() {
		deleteReason = CommonUtil.returnDeleteData(deleteType);
		return deleteReason;
	}

	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}

	public Date getAccumulDate() {
		return accumulDate;
	}

	public void setAccumulDate(Date accumulDate) {
		this.accumulDate = accumulDate;
	}

	public String getAccumulContents() {
		return accumulContents;
	}

	public void setAccumulContents(String accumulContents) {
		this.accumulContents = accumulContents;
	}

	public int getAccumulScore() {
		return accumulScore;
	}

	public void setAccumulScore(int accumulScore) {
		this.accumulScore = accumulScore;
	}

	public int getMannerScore() {
		return mannerScore;
	}

	public void setMannerScore(int mannerScore) {
		this.mannerScore = mannerScore;
	}

	public String getMemberRank() {
		memberRank = CommonUtil.returnMemberRank(accumulAllScore);
		return memberRank;
	}

	public void setMemberRank(String memberRank) {
		this.memberRank = memberRank;
	}

	public int getAccumulAllScore() {
		return accumulAllScore;
	}

	public void setAccumulAllScore(int accumulAllScore) {
		this.accumulAllScore = accumulAllScore;
	}

	public int getMannerAllScore() {
		return mannerAllScore;
	}

	public void setMannerAllScore(int mannerAllScore) {
		this.mannerAllScore = mannerAllScore;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public boolean isEliminated() {
		return eliminated;
	}

	public void setEliminated(boolean eliminated) {
		this.eliminated = eliminated;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public Date getBlacklistDate() {
		return blacklistDate;
	}

	public void setBlacklistDate(Date blacklistDate) {
		this.blacklistDate = blacklistDate;
	}

	public int getReportCount() {
		return reportCount;
	}

	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}

	public String getCertificatedNum() {
		return certificatedNum;
	}

	public void setCertificatedNum(String certificatedNum) {
		this.certificatedNum = certificatedNum;
	}

	public int getLoginType() {
		return loginType;
	}

	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}

	public int getDeleteType() {
		return deleteType;
	}

	public void setDeleteType(int deleteType) {
		this.deleteType = deleteType;
	}

	public List<Restaurant> getListRegRestaurant() {
		return listRegRestaurant;
	}

	public void setListRegRestaurant(List<Restaurant> listRegRestaurant) {
		this.listRegRestaurant = listRegRestaurant;
	}
	
}