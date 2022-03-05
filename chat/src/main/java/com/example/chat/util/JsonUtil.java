package com.example.chat.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    private static String objectToJson(Object object) {
        ObjectMapper om = new ObjectMapper();
        String json = "";
        try {
            try {
                json = om.writeValueAsString(object);
            } catch (JsonGenerationException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    public static String getJson(Object obj) {
        return objectToJson(obj);
    }

    public static <T> T jsonToObject(String json, TypeReference<T> typeReference) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, typeReference);
        } catch (JsonParseException e) {
        } catch (JsonMappingException e) {
        } catch (IOException e) {
        }
        return null;
    }
}
