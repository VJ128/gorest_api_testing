package com.qa.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.restapiclient.RestApiClient;
import com.qa.utils.ReadFromExcelApachePoi;

public class GET_users {
	String BaseUrl = "https://gorest.co.in/public/v2/users";
	RestApiClient client;
	CloseableHttpResponse response;
	JSONArray jArray;
	int arraySize;

	/*
	 * @BeforeClass public void setUp() throws IOException { RestApiClient client =
	 * new RestApiClient(); HashMap<String, String> headerMap = new HashMap();
	 * headerMap.put("Content-Type", "application/json"); response =
	 * client.get(BaseUrl, headerMap); String responseString =
	 * EntityUtils.toString(response.getEntity());
	 * 
	 * //System.out.println(responseString); jArray = new JSONArray(responseString);
	 * arraySize = jArray.length(); }
	 * 
	 * @Test(priority = 1) public void getStatusCode() {
	 * Assert.assertEquals(response.getStatusLine().getStatusCode(), 200); }
	 * 
	 * @Test(priority = 2) public void getReasonPhrase() {
	 * Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "OK"); }
	 * 
	 * @Test(priority = 3) public void getProtocolVersion() {
	 * Assert.assertEquals(response.getStatusLine().getProtocolVersion().toString(),
	 * "HTTP/1.1"); }
	 */
	// dataprovider
	@DataProvider(name = "DP1")
	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = ReadFromExcelApachePoi
				.getTableArray(System.getProperty("user.dir") + "\\src\\test\\resources\\Book1.xlsx", "Sheet1");

		return (testObjArray);

	}

	@Test(priority = 4, dataProvider = "DP1")
	public void dataValidation(String name, String email, String gender, String status) {
		System.out.println(name + email + gender + status);
	}

	@AfterClass
	public void tearDown() {

	}

}
/*
 * for (int i = 0; i < arraySize; i++) { JSONObject jobj = (JSONObject)
 * jArray.get(i); System.out.println(jobj.get("id") + " " + jobj.get("name") +
 * " " + jobj.get("email") + " " + jobj.get("gender") + " " +
 * jobj.get("status"));
 * 
 * }
 */