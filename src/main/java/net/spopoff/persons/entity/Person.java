/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.spopoff.persons.entity;

import java.util.List;

/**
 *
 * @author steph
 */
public class Person {
    private String personId;
    private String firstname;
    private String lastname;
    private String operationalUnit;
    private Person managerId;
    private final String status = "ACTIVE";
    private List<String> projects;
    public Person(){}

    public String getStatus() {
        return status;
    }
    public String getPersonId() {
        return personId;
    }
    public String getUid() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getOperationalUnit() {
        return operationalUnit;
    }

    public void setOperationalUnit(String operationalUnit) {
        this.operationalUnit = operationalUnit;
    }

    public Person getManagerId() {
        return managerId;
    }

    public void setManagerId(Person managerId) {
        this.managerId = managerId;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }
}
