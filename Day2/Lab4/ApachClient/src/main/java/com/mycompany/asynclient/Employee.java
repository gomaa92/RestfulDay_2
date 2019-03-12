/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asynclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gom3a
 */
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", position=" + position + '}';
    }

    private String id;
    private String name;
    private String position;
    

    public Employee() {
    }

    public Employee(String id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
        
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return position;
    }

    public void setPhone(String phone) {
        this.position = position;
    }

    

}
