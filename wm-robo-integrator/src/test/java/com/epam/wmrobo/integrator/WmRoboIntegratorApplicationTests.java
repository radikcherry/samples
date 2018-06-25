package com.epam.wmrobo.integrator;

import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WmRoboIntegratorApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testRetrieveDatasetList() {
	    try {

	        String url = "https://www.quandl.com/api/v3/databases/TSE/codes";
	        
	        RestTemplate restTemplate = new RestTemplate();
/*	        
	        restTemplate.exc
	        
	        HttpClient instance = HttpClientBuilder.create().disableRedirectHandling().build();
	        HttpResponse response = instance.execute(new HttpGet("http://t.co/I5YYd9tddw"));
	     	        

	        URL obj = new URL(url);
	        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
	        conn.setReadTimeout(5000);
	        conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
	        conn.addRequestProperty("User-Agent", "Mozilla");
	        conn.addRequestProperty("Referer", "google.com");

	        System.out.println("Request URL ... " + url);

	        boolean redirect = false;

	        // normally, 3xx is redirect
	        int status = conn.getResponseCode();
	        if (status != HttpURLConnection.HTTP_OK) {
	            if (status == HttpURLConnection.HTTP_MOVED_TEMP
	                || status == HttpURLConnection.HTTP_MOVED_PERM
	                    || status == HttpURLConnection.HTTP_SEE_OTHER)
	            redirect = true;
	        }

	        System.out.println("Response Code ... " + status);

	        if (redirect) {

	            // get redirect url from "location" header field
	            String newUrl = conn.getHeaderField("Location");

	            // get the cookie if need, for login
	            String cookies = conn.getHeaderField("Set-Cookie");

	            // open the new connnection again
	            conn = (HttpURLConnection) new URL(newUrl).openConnection();
	            conn.setRequestProperty("Cookie", cookies);
	            conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
	            conn.addRequestProperty("User-Agent", "Mozilla");
	            conn.addRequestProperty("Referer", "google.com");

	            System.out.println("Redirect to URL : " + newUrl);

	        }

	        BufferedReader in = new BufferedReader(
	                                  new InputStreamReader(conn.getInputStream()));
	        String inputLine;
	        StringBuffer html = new StringBuffer();

	        while ((inputLine = in.readLine()) != null) {
	            html.append(inputLine);
	        }
	        in.close();

	        System.out.println("URL Content... \n" + html.toString());
	        System.out.println("Done");

*/
	        } catch (Exception e) {
	        e.printStackTrace();
	        }
	      
	}

}