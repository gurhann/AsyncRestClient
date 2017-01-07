package com.kayra.asyncrest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kayra.asyncrest.model.Person;

public class GetRequest {

	public static void main(String [] args) {
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target("http://localhost:8080/restsample/person/").path("get");
		
		Invocation.Builder builder = webtarget.request(MediaType.APPLICATION_JSON);
		Response resp = builder.get();
		
		if(resp.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + resp.getStatus());
		}
		Person person = resp.readEntity(Person.class);

		System.out.println("Output from Server .... \n");
		System.out.println(person);
	}
}
