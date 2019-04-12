package com.javarnd.pns.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtility {
	public static Date stringToSQLDate(String date) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
		java.util.Date utilDate = null;
		try {
			utilDate = sdf1.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlStartDate = new java.sql.Date(utilDate.getTime());
		return sqlStartDate;
	}
	public static java.sql.Date dateToSqlDate(java.util.Date utilDate) {
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
	
	public static String dateToString(java.util.Date utilDate)
	{
		DateFormat dateFormat  = new SimpleDateFormat("MM-dd-yyyy");
		String stringDate = dateFormat.format(utilDate);
		return stringDate;
		
	}
}  