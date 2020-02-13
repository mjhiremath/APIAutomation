package com.api.testng.UsersApi;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

 

public class GetAPI {
    
    @Test
    public void testapi()
    {
    	 RestAssured.baseURI = "";
         //Request
         RequestSpecification httprequest = RestAssured.given();
         
         //response
         Response response = httprequest.request(Method.GET,"https://5alive.moviuscorp.net:8021/adk/services/messaging/addressassignments?device_number=916362907347&sip_password=J93cu5f");
         String responseBody= response.body().asString();
         System.out.println(responseBody);
         
         //header details
         String contentType= response.header("Content-Type");
         System.out.println("My content type is "+contentType);
         Assert.assertEquals(contentType, "application/xml; charset=utf-8");
        	 
         int code = response.getStatusCode();
         System.out.print("The Status code is "+code);
         Assert.assertEquals(200, code); 
         String Statusline= response.statusLine();
         System.out.println(" "+Statusline);
    }
    
}