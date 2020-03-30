package org.restclient;

import java.io.IOException;

import org.Test.TestBase;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetAPI extends TestBase{
RestClient restclient;
String serviceurl;
String apiurl;
String url;
TestBase testbase;
@BeforeMethod
public void setup() {
	testbase=new TestBase();
	String serviceurl = prop.getProperty("Url");
	String apiurl = prop.getProperty("serviceUrl");
	
	url=serviceurl+apiurl;
}

@Test
public void getApi() throws ClientProtocolException, IOException, JSONException {
	RestClient restclient = new RestClient();
	restclient.get(url);
}
}
