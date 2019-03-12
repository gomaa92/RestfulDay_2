/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/calculator")
public class Calculator {

    @Path("/sum")
    @GET

    @Produces(MediaType.TEXT_PLAIN)
    public String sum(@QueryParam("number1") int number1, @QueryParam("number2") int number2) {

        int sum = number1 + number2;

        return "sum is "+sum;
    }

    @Path("/sub")
    @GET

    @Produces(MediaType.TEXT_PLAIN)
    public String subtract(@QueryParam("number1") int number1, @QueryParam("number2") int number2) {

        int sub = number1 - number2;

        return "Subtarct is"+ sub;
    }

    @Path("/multi")
    @GET

    @Produces(MediaType.TEXT_PLAIN)
    public String multiply(@QueryParam("number1") int number1, @QueryParam("number2") int number2) {

        int mult = number1 * number2;

        return "Multibly is :"+mult;
    }

    @Path("/div")
    @GET

    @Produces(MediaType.TEXT_PLAIN)
    public String division(@QueryParam("number1") float number1, @QueryParam("number2") float number2) {

        float div = number1 / number2;

        return "Division is : "+div;
    }

}
