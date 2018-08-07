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
}
