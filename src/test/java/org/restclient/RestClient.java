package org.restclient;

import java.io.IOException;
import java.util.HashMap;

import org.Test.TestBase;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class RestClient extends TestBase {
public void get(String url) throws ClientProtocolException, IOException, JSONException {
	   CloseableHttpClient httpclient = HttpClients.createDefault();
	   HttpGet httpGet = new HttpGet(url);
	   CloseableHttpResponse closeablehttpresponse = httpclient.execute(httpGet);

       int statuscode = closeablehttpresponse.getStatusLine().getStatusCode();
       System.out.println("The Status code is "+statuscode);
       
       String responsecode = EntityUtils.toString(closeablehttpresponse.getEntity(), "UTF-8");

       JSONObject jsoncode = new JSONObject(responsecode);
       System.out.println("The Respnse code is "+jsoncode);
       
       Header[] header = closeablehttpresponse.getAllHeaders();
       HashMap<String, String>allheaders=new HashMap<String, String>();
     for(Header h:header) {
    	 allheaders.put(h.getName(), h.getValue());
     }
     System.out.println("The Headers are "+allheaders);
}
}