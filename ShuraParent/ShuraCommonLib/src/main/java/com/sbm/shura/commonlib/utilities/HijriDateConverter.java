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
			result = HijriMonthNames.MOHARAM.getKey();
			break;

		case 2:
			result = HijriMonthNames.SAFAR.getKey();
			break;

		case 3:
			result = HijriMonthNames.RABEEFST.getKey();
			break;

		case 4:
			result = HijriMonthNames.RABEELST.getKey();
			break;

		case 5:
			result = HijriMonthNames.GOMADAFST.getKey();
			break;

		case 6:
			result = HijriMonthNames.GOMADALST.getKey();
			break;

		case 7:
			result = HijriMonthNames.RAGAB.getKey();
			break;

		case 8:
			result = HijriMonthNames.SHAABAN.getKey();
			break;

		case 9:
			result = HijriMonthNames.RAMADAN.getKey();
			break;

		case 10:
			result = HijriMonthNames.SHWAL.getKey();
			break;

		case 11:
			result = HijriMonthNames.ZOELKEEDA.getKey();
			break;

		case 12:
			result = HijriMonthNames.ZOELHEGGA.getKey();
			break;
		}
		return result;
	}
}
