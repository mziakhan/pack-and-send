package com.javarnd.cip.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//Ading comments...Anas 

public class DateUtility {
	public static Date stringToSQLDate(String date) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
		java.util.Date utilDate = null;
		try {
			utilDate = sdf1.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlStartDate = new java.sql.Date(utilDate.getTime());
		return sqlStartDate;
	}
}
