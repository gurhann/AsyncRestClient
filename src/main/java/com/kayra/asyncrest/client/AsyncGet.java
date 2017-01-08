package com.kayra.asyncrest.client;

import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class AsyncGet {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/restsample/async");
		Invocation.Builder builder = webTarget.request();
		System.out.println("main program started:" + new Date());
		Response response = builder.get();
		System.out.println(response.readEntity(String.class) + ":" + new Date());
		System.out.println("main program ended" + new Date());
	}
}
