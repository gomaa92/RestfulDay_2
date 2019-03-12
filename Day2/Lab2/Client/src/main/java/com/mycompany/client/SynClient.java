/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Gom3a
 */
public class SynClient {

    public static void main(String args[]) {
        Client client = Client.create();
        String url = "http://localhost:8084/CRUDOperations/rest/employees/01";
        WebResource resource = client.resource(url);
        WebResource.Builder builder = resource.accept(MediaType.APPLICATION_JSON);
        ClientResponse response = builder.get(ClientResponse.class);
        if (response.getStatus() != 200) {
            throw new RuntimeException("  HTTP Error: " + response.getStatus());
        } else {
            Employee employee = response.getEntity(Employee.class);
            System.out.println("Response fron the server  ");
            System.out.println(employee);
        }

        Employee newEmployee = new Employee("99", "alaa", "TA");
        ObjectMapper mapper = new ObjectMapper();
        try {
            String request = mapper.writeValueAsString(newEmployee);
            String url1 = "http://localhost:8084/CRUDOperations/rest/employees";
            WebResource resource1 = client.resource(url1);
            WebResource.Builder builder1 = resource1.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON);
            ClientResponse clientResponse = builder1.post(ClientResponse.class, request);
        } catch (IOException ex) {
            Logger.getLogger(SynClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
        
        
        
        
        

    }

}
