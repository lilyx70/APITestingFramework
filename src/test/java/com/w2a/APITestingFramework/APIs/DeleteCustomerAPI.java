package com.w2a.APITestingFramework.APIs;


import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.APITestingFramework.Utilities.DataUtil;
import com.w2a.APITestingFramework.listeners.ExtentListeners;
import com.w2a.APITestingFramwork.setUp.BaseTest;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DeleteCustomerAPI extends BaseTest{
	

	
	public static Response sendDeleteRequestToDeleteCustomerAPIWithValidID(Hashtable<String,String> data) {
		

		Response response =	given().auth().basic(config.getProperty("validSecretKey"), "")
				.delete(config.getProperty("customerAPIEndPoint")+"/"+data.get("id"));
				

		return response;
	}
	
}
