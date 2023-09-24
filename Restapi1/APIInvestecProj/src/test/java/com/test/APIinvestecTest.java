package com.test;
import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class APIinvestecTest {
   @Test
   public void jsonIterateArr() {

      //base URI with Rest Assured class
      RestAssured.baseURI = "https://swapi.dev/api/";

      //obtain Response from GET request
      Response res = given().when().get("/people");

      //convert JSON to string
      JsonPath j = new JsonPath(res.asString());

      //get values of JSON array after getting array size
      int ressize = j.getInt("results.size()");
      for(int i = 0; i < ressize; i++) {
         String name = j.getString("results["+i+"].name");
         if(name.equals("R2-D2")) {
         String skincolor = j.getString("results["+i+"].skin_color");
         Assert.assertEquals("white, blue", skincolor);
         Assert.assertEquals("R2-D2", name);
         System.out.println(name);
         System.out.println(skincolor);
      }
   }
}}