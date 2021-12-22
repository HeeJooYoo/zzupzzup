package com.zzupzzup.common.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


public class CommonUtil {
	
	///Field
	private static final String AGE_TEN = "10대";
	private static final String AGE_TWENTY = "20대";
	private static final String AGE_THIRTY = "30대";
	private static final String AGE_FOURTY = "40대";
	private static final String AGE_FIFTY = "50대";
	private static final String AGE_ELDER = "60대 이상";
	
	private static final String MEMEBER_RANK_1 = "쩝린이";
	private static final String MEMEBER_RANK_2 = "쩝쩝학사";
	private static final String MEMEBER_RANK_3 = "쩝쩝석사";
	private static final String MEMEBER_RANK_4 = "쩝쩝박사";
	
	private static final String DELETE_TYPE_1 = "더 이상 이 서비스를 이용하고 싶지 않아서";
	private static final String DELETE_TYPE_2 = "기존의 타 사이트를 이용하고 있어서";
	private static final String DELETE_TYPE_3 = "탈퇴 후 재가입을 위해서";
	
	
	
	public static String returnAgeRange(String birth) {
		
		String ageRange = null;
		
		int birthYear = Integer.parseInt(birth.substring(0, 4));
		int currentYear = LocalDate.now().getYear();
		
		switch ((currentYear-birthYear+1)/10) {
		case 1:
			ageRange = AGE_TEN;
			break;
		case 2:
			ageRange = AGE_TWENTY;
			break;
		case 3:
			ageRange = AGE_THIRTY;
			break;
		case 4:
			ageRange = AGE_FOURTY;
			break;
		case 5:
			ageRange = AGE_FIFTY;
			break;
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			ageRange = AGE_ELDER;
			break;
		default:
			break;
		}
		
		return ageRange;
	
	}
	
	public static String returnMemberRank(int activityScore) {
		
		if (activityScore <= 100) {
			return MEMEBER_RANK_1;	
		} else if (activityScore > 100 && activityScore < 250) {
			return MEMEBER_RANK_2;	
		} else if (activityScore >= 250 && activityScore < 500) {
			return MEMEBER_RANK_3;	
		} else if (activityScore >= 500) {
			return MEMEBER_RANK_4;	
		} else {
			return null;
		}
		
	}
	
	public static String returnDeleteData(int deleteType) {
		if (deleteType == 1) {
			return DELETE_TYPE_1;
		} else if (deleteType == 2) {
			return DELETE_TYPE_2;
		} else if (deleteType == 3) {
			return DELETE_TYPE_3;
		} else {
			return null;
		}
	}
	
	public static String returnReportData(int reportCategory, int reportType) {
		
		String data = "";
		
		if (reportCategory == 1) {
			switch (reportType) {
				case 1:
					data = "허위 광고성 채팅방 입니다.";
					break;
				case 2:
					data = "부적절한 언행을 사용하였습니다.";
					break;
			}
		} else if(reportCategory == 2) {
			switch (reportType) {
				case 1:
					data = "돈을 지불하지 않았습니다.";
					break;
				case 2:
					data = "부적절한 언행을 사용하였습니다.";
					break;
				case 3:
					data = "약속에 불참하였습니다.";
					break;
			}
		} else if(reportCategory == 3) {
			switch (reportType) {
				case 1:
					data = "허위 광고성 리뷰입니다.";
					break;
				case 2:
					data = "부적절한 언어를 사용하였습니다.";
					break;
				case 3:
					data = "해당음식점과 일치하지 않는 내용입니다.";
					break;
			}
		} else if(reportCategory == 4) {
			switch (reportType) {
				case 1:
					data = "허위 광고성 게시물입니다.";
					break;
				case 2:
					data = "부적절한 언어를 사용하였습니다.";
					break;
				case 3:
					data = "해당 음식점과 일치하는 영수증이 아닙니다.";
					break;
			}
		} else if(reportCategory == 5) {
			switch (reportType) {
				case 1:
					data = "일치하지 않는 정보를 제공하고 있습니다.";
					break;
				case 2:
					data = "영업시간이 다릅니다.";
					break;
				case 3:
					data = "폐점된 가게입니다.";
					break;
			}
		}
		return data;
	}
	
	//======================================================================================================================
	
	///Method
	public static String null2str(String org, String converted) {
		if (org == null || org.trim().length() == 0)
			return converted;
		else
			return org.trim();
	}

	public static String null2str(String org) {
		return CommonUtil.null2str(org, "");
	}

	public static String null2str(Object org) {
		if (org != null && org instanceof java.math.BigDecimal) {
			return CommonUtil.null2str((java.math.BigDecimal) org, "");
		} else {
			return CommonUtil.null2str((String) org, "");
		}
	}

	public static String null2str(java.math.BigDecimal org, String converted) {
		if (org == null)
			return converted;
		else
			return org.toString();
	}

	public static String null2str(java.math.BigDecimal org) {
		return CommonUtil.null2str(org, "");
	}

	public static String toDateStr(String dateStr) {
		if (dateStr == null)
			return "";
		else if (dateStr.length() != 8)
			return dateStr;
		else
			return dateStr.substring(0, 4) + "/" + dateStr.substring(4, 6)
					+ "/" + dateStr.substring(6, 8);
	}

	public static String toDateStr(Timestamp date) {
		if (date == null)
			return "";
		else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			return sdf.format(new Date(date.getTime()));
		}
	}

	public static String toAmountStr(String amountStr) {
		String returnValue = "";
		if (amountStr == null)
			return returnValue;
		else {
			int strLength = amountStr.length();

			if (strLength <= 3)
				return amountStr;
			else {
				String s1 = "";
				String s2 = "";
				for (int i = strLength - 1; i >= 0; i--)
					s1 += amountStr.charAt(i);

				for (int i = strLength - 1; i >= 0; i--) {
					s2 += s1.charAt(i);
					if (i % 3 == 0 && i != 0)
						s2 += ",";
				}

				return s2;
			}
		}
	}

	public static String toAmountStr(java.math.BigDecimal amount) {
		if (amount == null) {
			return "";
		} else {
			return toAmountStr(amount.toString());
		}
	}
}
