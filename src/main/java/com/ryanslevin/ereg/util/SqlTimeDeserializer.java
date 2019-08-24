package com.ryanslevin.ereg.util;

import java.io.IOException;
import java.sql.Time;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SqlTimeDeserializer extends JsonDeserializer<Time> {

	@Override
	public Time deserialize(JsonParser jP, DeserializationContext dC) throws IOException, JsonProcessingException {
        return Time.valueOf(jP.getValueAsString() + ":00");
    }
    
}