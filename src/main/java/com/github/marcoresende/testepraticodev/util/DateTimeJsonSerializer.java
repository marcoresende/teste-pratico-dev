package com.github.marcoresende.testepraticodev.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateTimeJsonSerializer extends JsonSerializer<Date> {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DateUtil.DATE_TIME_FORMAT_PATTERN_BR);

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
    	dateFormat.setTimeZone(TimeZone.getDefault());
        String formattedDate = dateFormat.format(date);

        jsonGenerator.writeString(formattedDate);
    }

}
