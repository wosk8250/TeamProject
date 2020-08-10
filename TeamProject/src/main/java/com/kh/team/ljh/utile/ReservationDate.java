package com.kh.team.ljh.utile;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;


public class ReservationDate{
	
	public static ArrayList<String> BetweenDates(String startDate,String endDate) throws Exception{
		
		ArrayList<String> reservationDate = new ArrayList<>();
		int startYear = Integer.parseInt(year(startDate));
		int startMonth = Integer.parseInt(month(startDate));
		int startDay = Integer.parseInt(day(startDate));
		
		LocalDate date1 = LocalDate.of(startYear, startMonth, startDay);
		
		int endYear = Integer.parseInt(year(endDate));
		int endMonth = Integer.parseInt(month(endDate));
		int endDay = Integer.parseInt(day(endDate));
		
		
		LocalDate date2 = LocalDate.of(endYear, endMonth, endDay);
		    while (date2.isAfter(date1) == true) {
		    	
		    	String strReservationDate = strReservationDate(String.valueOf(date1));
		    	reservationDate.add("'"+strReservationDate+"'");
		    	date1 = LocalDate.of(date1.getYear(), date1.getMonth(), date1.getDayOfMonth() + 1);
		    		
		    }
		    
		    return reservationDate;
	}
	
	private static String year(String date) {
			String year = date.substring(0, 4);
		return year;
	}
	private static String month(String date) {
		String month= date.substring(5, 7);
		return month;
	}
	private static String day(String date) {
		String day = date.substring(8, 10);
		
		return day;
	}
	private static String strReservationDate(String strReservationDate) {
		
		String year = strReservationDate.substring(0, 5);
		
		String month = null;
		if(strReservationDate.substring(5, 6).equals("0")) {
			month = strReservationDate.substring(6, 8);
		} else {
			month= strReservationDate.substring(5, 8);
		}
		
		String day = null;
		if(strReservationDate.substring(8, 9).equals("0")) {
			day = strReservationDate.substring(9, 10);
		} else {
			day = strReservationDate.substring(8, 10);
		}
		
		
		strReservationDate = year + month + day;
		return strReservationDate;
	}
}
