package com.mypractice2.notification;

import java.util.Map;

public class Utils {

    Utils(){
        // Private constructor to prevent instantiation
    }

    public static String replacePlaceholders(String body, Map<String,String> placeholders){
        if (body == null || placeholders == null || placeholders.isEmpty()) {
            return body;
        }

        for (Map.Entry<String, String> entry : placeholders.entrySet()) {
            String placeholder = entry.getKey();
            String value = entry.getValue();
            body = body.replace("<" + placeholder + ">", value);
        }

        return body;

    }
}
