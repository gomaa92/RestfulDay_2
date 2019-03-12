/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apacheserver;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Gom3a
 */
@Path("/employees")
public class EmployeeService {

    @POST

    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public Employee addEmp(Employee employee, @Context HttpServletRequest request) {
        request.getSession().setAttribute("name", "ahmed");
        System.out.println(request.getSession().getId());
        return EmployeeDao.addEmployee(employee);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Employee> getEmployees_Json(@Context UriInfo info, @Context HttpHeaders headers,
            @Context HttpServletRequest request) {

        System.out.println(request.getSession().getId());
        System.out.println(request.getSession().getAttribute("name"));
        MultivaluedMap<String, String> headerParams = headers.getRequestHeaders();
        System.out.println(headerParams.get("Accept"));
        System.out.println(info.getAbsolutePath());
        List<Employee> listOfEmployess = EmployeeDao.getAllEmployees();
        return listOfEmployess;

    }

}
