package com.billinghub.billmanagement.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class JsonUtil {

    public static <T> T convertJsonToTargetPojoObject(String message, Class<T> targetPojo){
        Gson gson = new Gson();
        return gson.fromJson(message, targetPojo);
    }
}
