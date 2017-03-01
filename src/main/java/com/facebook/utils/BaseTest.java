package com.facebook.utils;

import com.facebook.config.BaseURI;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseTest {

    protected Response response;

    static {
        String environment = getValueOrDefault(System.getProperty("env"),"prod");
        if (environment.equalsIgnoreCase("prod")){
            RestAssured.baseURI = BaseURI.PROD+BaseURI.API_VERSION;
        }else if(environment.equalsIgnoreCase("staging")){
            RestAssured.baseURI = BaseURI.STAGING+BaseURI.API_VERSION;
        }
    }

    public static String getValueOrDefault(String value, String defaultValue) {
        return value != null && !value.isEmpty() ? value : defaultValue;
    }

}
