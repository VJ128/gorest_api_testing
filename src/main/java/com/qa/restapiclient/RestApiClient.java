package com.qa.restapiclient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestApiClient {
	
	public CloseableHttpResponse get(String url,HashMap<String,String> headerMap) throws IOException {
		CloseableHttpClient client= HttpClients.createDefault();
		HttpGet httpget=new HttpGet(url);
		for(Entry<String,String> entry:headerMap.entrySet()) {
			httpget.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse response= client.execute(httpget);
		return response;
	}

}
