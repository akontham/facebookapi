package com.facebook.tests;

import com.facebook.builders.AuthRequestSpecBuilder;
import com.facebook.config.BasePath;
import com.facebook.utils.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class UserDetailsTest extends BaseTest{

    @Test
    public void validateUserInfo(){
        response = given().spec(new AuthRequestSpecBuilder().build()).queryParam("fields","first_name,gender,hometown,birthday").get(BasePath.USER);

        //Assertions
        assertEquals(200,response.getStatusCode());
        assertEquals(response.path("first_name"),"value");
        assertEquals(response.path("gender"),"value");
        assertEquals(response.path("hometown.name"),"value");

    }




}
