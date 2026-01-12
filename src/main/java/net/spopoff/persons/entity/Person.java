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
    private String key;
    private String prenom;
    private String nom;
    private String operationalUnit;
    private Person managerId;
    private final String status = "ACTIVE";
    private List<String> projects;
    public Person(){}

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
    public Person createOne(String personId){
        setPersonId(personId);
        setPrenom("prénom de "+personId);
        setNom("nom de "+personId);
        Person mng = new Person();
        mng.setPrenom("prénom du chef de "+personId);
        mng.setNom("nom du chef de "+personId);
        mng.setPersonId("chef2"+personId);
        mng.setOperationalUnit("boulot");
        setManagerId(mng);
        setOperationalUnit("boulot");
        return this;
    }
}
