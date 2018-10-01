package com.sbm.shura.commonlib.utilities;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.chrono.IslamicChronology;

public class HijriDateConverter {

	public static DateTime convertCurrentDateToHijri() {
		return DateTime.now().withChronology(IslamicChronology.getInstance());
	}
	
	public static DateTime convertDateToHijri(Date date) {
		DateTime dtISO = new DateTime(date);
		return dtISO.withChronology(IslamicChronology.getInstance());
	}
	
	public static String getCurrentHijriiDateWithMonthName()
	{
		DateTime hijriDate = convertCurrentDateToHijri();
		String monthName =  mapHijriMonthName( hijriDate.getMonthOfYear());
		String currentHijriiDate = hijriDate.getDayOfMonth()+"-"+ monthName + "-" + hijriDate.getYear();
		
		return currentHijriiDate;
	}
	
	public static String mapHijriMonthName(int monthOrder)
	{
		String result ="";
		switch(monthOrder)
		{
		case 1:
			result = HiriMonthNames.MOHARAM.getKey();
			break;

		case 2:
			result = HiriMonthNames.SAFAR.getKey();
			break;

		case 3:
			result = HiriMonthNames.RABEEFST.getKey();
			break;

		case 4:
			result = HiriMonthNames.RABEELST.getKey();
			break;

		case 5:
			result = HiriMonthNames.GOMADAFST.getKey();
			break;

		case 6:
			result = HiriMonthNames.GOMADALST.getKey();
			break;

		case 7:
			result = HiriMonthNames.RAGAB.getKey();
			break;

		case 8:
			result = HiriMonthNames.SHAABAN.getKey();
			break;

		case 9:
			result = HiriMonthNames.RAMADAN.getKey();
			break;

		case 10:
			result = HiriMonthNames.SHWAL.getKey();
			break;

		case 11:
			result = HiriMonthNames.ZOELKEEDA.getKey();
			break;

		case 12:
			result = HiriMonthNames.ZOELHEGGA.getKey();
			break;
		}
		return result;
	}
}
