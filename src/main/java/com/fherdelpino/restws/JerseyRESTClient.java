package com.fherdelpino.restws;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class JerseyRESTClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target("http://www.google.com");
        Response response = target.request().get();
        MultivaluedMap<String, Object> headers = response.getHeaders();
        headers.keySet().forEach(k -> {
            System.out.println("header: " + k);
            System.out.println("value: " + headers.get(k));
            System.out.println();
        });
        //System.out.println(response.getMediaType());
    }
}
