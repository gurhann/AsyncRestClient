package com.kayra.asyncrest.client;

import java.util.Calendar;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class AsyncGet {

	public static void main(String [] args) {
		Calendar calendar = Calendar.getInstance();
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/restsample/async");
		Invocation.Builder builder = webTarget.request();
		System.out.println("main program started:"+calendar.getTime());
		Response response = builder.get();
		System.out.println(response.readEntity(String.class) + ":" + calendar.getTime());
		System.out.println("main program ended"+calendar.getTime());
	}
}
