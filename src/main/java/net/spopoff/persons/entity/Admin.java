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
    private String appName;
    private String key;
    private String login;
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
    public String getAppName() {
        return appName;
    }
    public String getUid() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects.addAll(projects);
    }
    public Admin createOne(String appName, String login){
        setAppName(appName);
        setLogin("adm-"+appName);
        return this;
    }
    @Override
    public String toString(){
        return "login="+getLogin()+" appName="+getAppName()+
                " key="+getKey()+" projects="+String.join("; ", getProjects());
    }
}
