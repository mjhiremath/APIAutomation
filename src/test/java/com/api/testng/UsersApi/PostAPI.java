package com.api.testng.UsersApi;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class PostAPI {
	
	@Test
	public void adddirectorynumber() {
	RestAssured.baseURI = "";
	 
     //Request
     RequestSpecification httprequest = RestAssured.given();
     
     //Request with paramters
     JSONObject requestParamter = new JSONObject();
     requestParamter.put("userid","20002001");
     requestParamter.put("password", "12345678");
     requestParamter.put("number", "18933300698"); // change this number for the new run
     requestParamter.put("developer", "20002001");
     
     httprequest.header("Content-type","application/json");

     httprequest.body(requestParamter.toJSONString());
     
     Response response = httprequest.request(Method.POST,"https://5alive.moviuscorp.net:8021/adk/services/iotadmin/adddirectorynumber");
     
     String responseBody= response.body().asString();
     System.out.println(responseBody);
     int code = response.getStatusCode();
     System.out.print("The Status code is  "+code);
     Assert.assertEquals(200, code);
     String desc = response.jsonPath().get("desc");
     Assert.assertEquals(desc, "Succcess");
     int errorcode = response.jsonPath().get("errcode");
     Assert.assertEquals(errorcode, 0);
     String Statusline= response.statusLine();
     System.out.println(" "+Statusline);
   }
}
