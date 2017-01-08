package com.kayra.asyncrest.client;

import java.util.Date;
import java.util.concurrent.Future;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class ChunkedOutputGet {

	public static void main(String [] args) {
		final Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/restsample/async").path("chunked");
		System.out.println("main program started:" + new Date());
		final Future<Response> responseFeature = webTarget.request().async().get(new InvocationCallback<Response>() {

			public void completed(Response resp) {
				System.out.println("resp:" + resp.readEntity(String.class) +"->" + new Date());
				client.close();
			}

			public void failed(Throwable err) {
				
			}
		});
		
		System.out.println("main program ended:" + new Date());
	}
}
