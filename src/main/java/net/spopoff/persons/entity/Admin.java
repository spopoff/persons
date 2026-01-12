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
    private String personId;
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
    public String getPersonId() {
        return personId;
    }
    public String getUid() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
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
    public Admin createOne(String personId){
        setPersonId(personId);
        setUsername("adm-"+personId);
        return this;
    }
}
