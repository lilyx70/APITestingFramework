package com.w2a.APITestingFramework.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.APITestingFramework.APIs.CreateCustomerAPI;
import com.w2a.APITestingFramework.Utilities.DataUtil;
import com.w2a.APITestingFramework.listeners.ExtentListeners;
import com.w2a.APITestingFramwork.setUp.BaseTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;

public class CreateCustomerTest extends BaseTest{
	
	/*
	@Test(dataProviderClass=DataUtil.class, dataProvider = "data")
	public void validateCreateCustomerAPI(String name, String email, String description) {
	Response response =	given().auth().basic(config.getProperty("validSecretKey"), "")
	.formParam("name", name).formParam("email", email).formParam("description",description)
	.post(config.getProperty("customerAPIEndPoint"));

	response.prettyPrint();
	System.out.println(response.statusCode());
	
	Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test(dataProviderClass=DataUtil.class, dataProvider = "data")
	public void invalidateCreateCustomerAPI(String name, String email, String description) {

		
		
	Response response =	given().auth().basic(config.getProperty("invalidSecretKey"), "")
			    .formParam("name", name).formParam("email", email).formParam("description",description)
				.post(config.getProperty("customerAPIEndPoint"));
	
	response.prettyPrint();
	System.out.println(response.statusCode());
	
	Assert.assertEquals(response.statusCode(), 200);
		
		
	}
	
	*/
	
	@Test(dataProviderClass=DataUtil.class, dataProvider = "data")
	public void validateCreateCustomerAPIWithValidSecretKey(Hashtable<String,String> data) {
		

	/*
		Response response =	given().auth().basic(config.getProperty("validSecretKey"), "")
				.formParam("name", data.get("name")).formParam("email", data.get("email")).formParam("description",data.get("description"))
				.post(config.getProperty("customerAPIEndPoint"));
				
	*/
	
	Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuthKey(data);
	ExtentListeners.testReport.get().info(data.toString());
	
	response.prettyPrint();
	System.out.println(response.statusCode());
		
	Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(dataProviderClass=DataUtil.class, dataProvider = "data")
	//public void invalidateCreateCustomerAPI(String name, String email, String description) {
	public void validateCreateCustomerAPIWithInvalidSecretKey(Hashtable<String,String> data) {
		
	/*	
	Response response =	given().auth().basic(config.getProperty("invalidSecretKey"), "")
			.formParam("name", data.get("name")).formParam("email", data.get("email")).formParam("description",data.get("description"))
				.post(config.getProperty("customerAPIEndPoint"));
	*/
		
	Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithInValidAuthKey(data);

	ExtentListeners.testReport.get().info(data.toString());	
	response.prettyPrint();
	System.out.println(response.statusCode());
	
	Assert.assertEquals(response.statusCode(), 200);
		
		
	}
	
	/*
	@DataProvider
	public Object[][] getData() {
		
		String sheetName = "validateCreateCustomerAPI";
		
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows-1][cols];
		
		for (int rowNum = 2; rowNum<= rows; rowNum++ ) {
			
			for (int colNum = 0; colNum < cols; colNum++) {
			data[rowNum-2][colNum]=	excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		
		return data;
	}
	*/
}
