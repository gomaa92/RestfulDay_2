/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asynclient;

import com.sun.jersey.api.client.AsyncWebResource;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.async.TypeListener;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.client.non.blocking.NonBlockingClient;
import com.sun.jersey.client.non.blocking.config.DefaultNonBlockingClientConfig;
import com.sun.jersey.client.non.blocking.config.NonBlockingClientConfig;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Gom3a
 */
public class AsynClient {

    public static void main(String args[]) {

        ClientConfig clientConfig = new DefaultNonBlockingClientConfig();
        clientConfig.getProperties().put(NonBlockingClientConfig.PROPERTY_THREADPOOL_SIZE, 10);
        Client client = NonBlockingClient.create(clientConfig);
        String url = "http://localhost:8084/CRUDOperations/rest/employees";
        AsyncWebResource asyncWebResource = client.asyncResource(url);
        AsyncWebResource.Builder builder = asyncWebResource.accept(MediaType.APPLICATION_JSON);

        builder.get(new TypeListener<ClientResponse>(ClientResponse.class) {
            @Override
            public void onComplete(Future<ClientResponse> future) throws InterruptedException {

                try {
                    ClientResponse response = future.get();

                    if (response.getStatus() != 200) {
                        throw new RuntimeException("HTTP Error : " + response.getStatus());
                    } else {
                        List<Employee> employees = response.getEntity(new GenericType<List<Employee>>() {
                        });

                        System.out.println("Response from the Server : ");

                        employees.forEach((employee) -> {
                            System.out.println(employee);
                        });

                    }

                } catch (ExecutionException ex) {
                    Logger.getLogger(AsynClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Employee employee = new Employee("55", "adel", "tester");

        ObjectMapper mapper = new ObjectMapper();
        try {
            String request = mapper.writeValueAsString(employee);
            AsyncWebResource.Builder builder2 = asyncWebResource.accept(MediaType.APPLICATION_JSON)
                    .type(MediaType.APPLICATION_JSON);

            builder2.post(new TypeListener<ClientResponse>(ClientResponse.class) {
                @Override
                public void onComplete(Future<ClientResponse> future) throws InterruptedException {

                    try {
                        ClientResponse response = future.get();

                        if (response.getStatus() != 200) {
                            throw new RuntimeException("HTTP Error : " + response.getStatus());
                        }

                    } catch (ExecutionException ex) {
                        Logger.getLogger(AsynClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }, request);

        } catch (IOException ex) {
            Logger.getLogger(AsynClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
