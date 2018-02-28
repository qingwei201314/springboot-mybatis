package com.kevin;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpClientTest {
	public static void main(String[] args) throws MalformedURLException, IOException {
		HttpTool httpTool= new HttpTool();
		String result1 = httpTool.get(new URL("http://127.0.0.1:8080"));
		System.out.println(result1);
	}
}
