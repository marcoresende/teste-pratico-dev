package com.github.marcoresende.testepraticodev.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DateTimeJsonDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException {

        DateFormat formatter = new SimpleDateFormat(DateUtil.DATE_TIME_FORMAT_PATTERN_BR);
        formatter.setTimeZone(TimeZone.getDefault());
        String dateStr = jsonparser.getText();
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            DateFormat formatter2 = new SimpleDateFormat(DateUtil.DATE_TIME_FORMAT_PATTERN_REST);
            String dateStr2 = jsonparser.getText();
            try {
                return formatter2.parse(dateStr2);
            } catch (ParseException e2) {
                throw new RuntimeException(e2);
            }
        }

    }

}
