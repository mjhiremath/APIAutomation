package com.api.testng.UsersApi;

import org.testng.Assert;
import org.testng.annotations.Test;

 

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

 

public class AssuredAPI {
    
    @Test
    public void testapi()
    {
    	
        Response resp = RestAssured.get("https://5alive.moviuscorp.net:8021/adk/services/messaging/getorgdetails?organization=2000");
        int code= resp.getStatusCode();
        System.out.println(code);
        //String data = resp.asString();
        //System.out.println(data);
        Assert.assertEquals(code,"200");
        
        
    }
    

 

}