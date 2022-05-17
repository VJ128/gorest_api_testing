package com.qa.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.restapiclient.RestApiClient;

public class GET_user_withId {
	String BaseUrl = "https://gorest.co.in/public/v2/users/3541";
	RestApiClient client;
	CloseableHttpResponse response;
	JSONObject jobj;

	@BeforeClass
	public void setUp() throws IOException {
		RestApiClient client = new RestApiClient();
		HashMap<String, String> headerMap = new HashMap();
		headerMap.put("Content-Type", "application/json");
		response = client.get(BaseUrl, headerMap);
		String responseString = EntityUtils.toString(response.getEntity());

		System.out.println(responseString);
		jobj = new JSONObject(responseString);

	}

	@Test(priority = 1)
	public void getStatusCode() {
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
	}

	@Test(priority = 2)
	public void getReasonPhrase() {
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "OK");
	}

	@Test(priority = 3)
	public void getProtocolVersion() {
		Assert.assertEquals(response.getStatusLine().getProtocolVersion().toString(), "HTTP/1.1");
	}
	
	@Test(priority = 4)
	public void dataValidation() {
		Assert.assertEquals(jobj.get("id"),3541);
		Assert.assertEquals(jobj.get("name"),"Agnivesh Singh");
		Assert.assertEquals(jobj.get("email"),"agnivesh_singh@mayert.com");
		Assert.assertEquals(jobj.get("gender"),"female");
		Assert.assertEquals(jobj.get("status"),"active");
	}

	@AfterClass
	public void tearDown() {
	}
}
