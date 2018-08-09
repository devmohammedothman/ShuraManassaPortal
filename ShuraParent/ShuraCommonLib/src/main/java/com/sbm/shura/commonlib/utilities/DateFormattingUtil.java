package com.sbm.shura.commonlib.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

public class DateFormattingUtil {
	
	public static Date formatDate(String format, Date date) {
		DateFormat sdf = new SimpleDateFormat(format);
		try {
			date = sdf.parse(date.toString());	
		} catch (Exception e) {
			date = null;
		}
		return date;
	}
	
	public static DateTime formatDateTime(String format, DateTime dateTime) {
		DateFormat sdf = new SimpleDateFormat(format);
		try {
			Date date = sdf.parse(dateTime.toDate().toString());
			dateTime = new DateTime(date);
		} catch (Exception e) {
			dateTime = null;
		}
		return dateTime;
	}
	
	public static Date formatCurrentDate(String format) {
		DateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date();
		try {
			String formatedDate = sdf.format(date);
			date = sdf.parse(formatedDate);
		} catch (Exception e) {
			date = null;
		}
		return date;
	}
	
	public static DateTime formatCurrentDateTime(String format) {
		DateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date();
		try {
			String formatedDate = sdf.format(date);
			date = sdf.parse(formatedDate);
			return new DateTime(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String formatCurrentDateToString(String format) {
		DateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.format(new Date());
		} catch (Exception e) {
			return null;
		}
	}

}
