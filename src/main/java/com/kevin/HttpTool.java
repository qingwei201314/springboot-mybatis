package com.kevin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpTool {

	public String post(URL url, String content) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("content-type", "text/html");
		conn.setRequestMethod("POST");
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);

		// 向服务端写入数据.
		OutputStream outputStream = conn.getOutputStream();
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
		bWriter.write(content);
		bWriter.flush();
		bWriter.close();

		// 取得服务端返回的数据.
		StringBuffer responseStr = new StringBuffer("");
		InputStream inputStream = conn.getInputStream();
		BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
		int c;
		while ((c = bReader.read()) != -1) {
			responseStr.append((char) c);
		}

		conn.disconnect();
		System.out.println("请求地址：" + url);

		return responseStr.toString();
	}

	public String get(URL url) throws IOException {
		// 如果还没有通过验证,取得服务端的随机码后进行验证
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);

		// 取得服务端返回的数据.
		StringBuffer responseStr = new StringBuffer("");
		InputStream inputStream = conn.getInputStream();
		BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

		int c;
		while ((c = bReader.read()) != -1) {
			responseStr.append((char) c);
		}
		conn.disconnect();

		return responseStr.toString();
	}
	
}