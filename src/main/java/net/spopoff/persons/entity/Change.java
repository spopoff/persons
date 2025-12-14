/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.spopoff.persons.entity;


/**
 *
 * @author steph
 */
public class Change {
    private Boolean deleted;
    private Long lastChangeDate;
    private Person person;
    public Change(){}
    public Change(Person person){
        this.person = person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Long lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }


    public Person getPerson() {
        return person;
    }
}
