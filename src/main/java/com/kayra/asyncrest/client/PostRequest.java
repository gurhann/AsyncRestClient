package com.kayra.asyncrest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kayra.asyncrest.model.Person;

public class PostRequest {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget webtarget = client.target("http://localhost:8080/restsample/person/").path("create");


		Person person = new Person();
		person.setName("gurhan");
		person.setSurname("kucuk");

		Invocation.Builder invocationBuilder = webtarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(person, MediaType.APPLICATION_JSON));
		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		System.out.println("Output from Server .... \n");
		String output = response.readEntity(String.class);
		System.out.println(output);
	}
}
