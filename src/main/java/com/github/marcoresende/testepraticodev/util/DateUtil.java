package com.github.marcoresende.testepraticodev.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;

public class DateUtil {

	public static final String DATE_TIME_FORMAT_PATTERN_BR = "dd/MM/yyyy HH:mm:ss";
	public static final String DATE_TIME_FORMAT_PATTERN_ZONE = "dd/MM/yyyy HH:mm:ss zzz";
	public static final String DATE_TIME_FORMAT_PATTERN_REST = "dd-MM-yyyy'T'HH:mm:ss";
    
	public static Date parseDate(String dateString, String pattern) {
		return parseDate(dateString, pattern, null);
	}

	public static Date parseDate(String dateString, String pattern, TimeZone timezone) {
		try {
			Date date = null;
			if (dateString != null && StringUtils.isNotBlank(dateString)) {
				DateFormat df = new SimpleDateFormat(pattern);

				if (timezone != null) {
					df.setTimeZone(timezone);
				}

				date = df.parse(dateString);
			}
			return date;
		} catch (Exception e) {
			return null;
		}
	}
	
}
