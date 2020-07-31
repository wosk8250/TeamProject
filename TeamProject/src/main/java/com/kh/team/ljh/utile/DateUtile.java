package com.kh.team.ljh.utile;

import java.time.LocalDateTime;

public class DateUtile {

	public static LocalDateTime stopDateTime(String strStopDateTime) throws Exception {
//		2020-07-23T12:20:47.463
		int year = Integer.parseInt(strStopDateTime.substring(0, 4));
		int month = Integer.parseInt(strStopDateTime.substring(5, 7));
		int dayOfMonth = Integer.parseInt(strStopDateTime.substring(8, 10));
		int hour = Integer.parseInt(strStopDateTime.substring(11, 13));
		int minute = Integer.parseInt(strStopDateTime.substring(14, 16));
		int second = Integer.parseInt(strStopDateTime.substring(17,19));
		int nanoOfSecond = Integer.parseInt(strStopDateTime.substring(20));
		return LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond);

	}

}
