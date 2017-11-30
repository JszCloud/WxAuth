package com.wx.auth.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class AuthUtil {
	public static String APPID="wx3e96c17405f2c598";
	public static String APPSECRET="65e48dc0db01f650da5785676c505e51";
/*	public static String APPID="wx5922bbc0a2fadb69";
	public static String APPSECRET="cbbde311b2028c20202258d0f87c41e8";
*/	
	public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException{
		JSONObject jsonObject = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet= new HttpGet(url);
		HttpResponse response=httpClient.execute(httpGet);
		HttpEntity enyity=response.getEntity();
		if (enyity != null) {
			String result=EntityUtils.toString(enyity,"UTF-8");
			jsonObject=JSONObject.fromObject(result);
		}
		httpGet.releaseConnection();
		return jsonObject;
	}
}
