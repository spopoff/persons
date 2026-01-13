/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.spopoff.persons.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author steph
 */
public class Admin {
    private String personName;
    private String key;
    private String username;
    private final String status = "ACTIVE";
    private final List<String> projects = new ArrayList<>();
    public Admin(){}

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getStatus() {
        return status;
    }
    public String getPersonName() {
        return personName;
    }
    public String getUid() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects.addAll(projects);
    }
    public Admin createOne(String personName){
        setPersonName(personName);
        setUsername("adm-"+personName);
        return this;
    }
}
