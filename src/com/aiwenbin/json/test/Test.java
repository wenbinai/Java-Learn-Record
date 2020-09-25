package com.aiwenbin.json.test;

import com.aiwenbin.json.JsonParser;
import com.aiwenbin.json.jsonstyle.JsonObject;

import java.io.IOException;

public class Test {
    static JsonParser jsonParser = new JsonParser();

    public static void main(String[] args) throws IOException {
        testExamp01();
    }

    public static void testExamp01() throws IOException {

        String json = "{\"name\": \"aiwenbin\",\"age\": 20}";
        System.out.println("json -->" + json);

        JsonObject jsonObject = (JsonObject) jsonParser.fromJson(json);
        System.out.println("jsonObject -->" + jsonObject);
    }
}
