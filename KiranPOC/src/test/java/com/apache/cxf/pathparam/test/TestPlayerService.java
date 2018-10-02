package com.apache.cxf.pathparam.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
 
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class TestPlayerService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub   
		String returnValue1 = testPlayerService("http://localhost:8080/KiranPOC/services/player/welcome/Dravid");
        System.out.println("Response from first service : " + returnValue1);
 
        // invokes for first method with three argument
        //String returnValue2 = testPlayerService("http://localhost:8080/KiranPOC/services/player/playerinfo/Sachin/41/200");
        String returnValue2 = testPlayerService("http://localhost:8080/KiranPOC/services/player/playerinfojson/Sachin");
        System.out.println("Response from second service : " + returnValue2);
    }
 
    @SuppressWarnings("deprecation")
    public static String testPlayerService(String uri) {
 
        // local variables
        HttpGet httpGet = null;
        DefaultHttpClient defaultHttpClient = null;
        HttpResponse httpResponse = null;
        HttpEntity httpEntity = null;
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = null;
 
        try {
            // http post request headers
            httpGet = new HttpGet(uri);
 
            // actual execution of http post
            defaultHttpClient = new DefaultHttpClient();
            httpResponse = defaultHttpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();
 
            // get the response content
            inputStream = httpEntity.getContent();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            stringBuilder = new StringBuilder();
            String strReadLine = bufferedReader.readLine();
 
            // iterate to get the data and append in StringBuilder
            while (strReadLine != null) {
                stringBuilder.append(strReadLine);
                strReadLine = bufferedReader.readLine();
                if (strReadLine != null) {
                    stringBuilder.append("\n");
                }
            }
        }
        catch (UnsupportedEncodingException usee) {
            usee.printStackTrace();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            // shuts down, when work done
            defaultHttpClient.getConnectionManager().shutdown();
        }
        return stringBuilder.toString();
    }
}