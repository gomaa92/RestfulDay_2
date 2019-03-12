/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudoperations;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Gom3a
 */
@Path("/employees")
public class EmployeeService {

    @POST
    
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public Employee addEmp(Employee employee) {
        return EmployeeDao.addEmployee(employee);
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public Employee updateEmp(Employee employee) {
        return EmployeeDao.updateEmployee(employee);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Employee> getEmployees_Json() {
        List<Employee> listOfEmployess = EmployeeDao.getAllEmployees();
        return listOfEmployess;

    }

    @GET
    @Path("/{employeeid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})

    public Employee getEmployee(@PathParam("employeeid") String empId) {
        return EmployeeDao.getEmployee(empId);

    }

    @DELETE
    @Path("/{employeeid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public void removeEmployee(@PathParam("employeeid") String empId) {
        EmployeeDao.deleteEmployee(empId);

    }

}
