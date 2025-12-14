/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.spopoff.persons.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import net.spopoff.persons.entity.Change;
import net.spopoff.persons.entity.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author steph
 */
@RestController
@RequestMapping("persons")
public class PersonController {
    private final Logger log = LogManager.getLogger(PersonController.class);
    @GetMapping(path="/{personId}", produces = "application/json")
    public ResponseEntity<Person> getPerson(@PathVariable String personId){
        log.info("Demande personid {}", personId);
        return ResponseEntity.ok(createOne(personId));
    }
    @GetMapping(path="", produces = "application/json")
    public ResponseEntity<String> getPersonTest(){
        log.info("Demande test");
        return ResponseEntity.ok("OK");
    }
    @GetMapping(path="/", produces = "application/json")
    public ResponseEntity<List<Person>> getPersons(){
        log.info("Demande tout");
        List<Person> persons = donneTout();
        return ResponseEntity.ok(persons);
    }
    private Person createOne(String personId){
        Person ret = new Person();
        ret.setPersonId(personId);
        ret.setFirstname("prénom de "+personId);
        ret.setLastname("nom de "+personId);
        Person mng = new Person();
        mng.setFirstname("prénom du chef de "+personId);
        mng.setLastname("nom du chef de "+personId);
        mng.setPersonId("chef2"+personId);
        mng.setOperationalUnit("boulot");
        ret.setManagerId(mng);
        ret.setOperationalUnit("boulot");
        return ret;
    }
    @GetMapping(path="/changelog", produces = "application/json")
    public ResponseEntity<Change[]> getChangement(){
        log.info("Demande changeLog rien");
        return ResponseEntity.ok(createChangement(true));
    }
    @GetMapping(path="/changelog?from={time}", produces = "application/json")
    public ResponseEntity<Change[]> getChangementFrom(@PathVariable String time){
        log.info("Demande changeLog "+time);
        return ResponseEntity.ok(createChangement(false));
    }
    private Change[] createChangement(boolean isTime){
        List<Change> ret = new ArrayList<>();
        Random random = new Random();
        List<Person> persons = donneTout();
        boolean boolValue;
        for(Person person : persons){
            boolValue = random.nextBoolean();
            Change done = new Change(person);
            done.setDeleted(boolValue);
            if(boolValue){
                done.setLastChangeDate(665654654654654L);
            }else{
                //on modifie
                person.setOperationalUnit("travail"+boolValue);
                done.setLastChangeDate(54471547425474L);
            }
            ret.add(done);
        }
        return ret.toArray(new Change[0]);
    }
    private List<Person> donneTout(){
        List<Person> persons = new ArrayList<>();
        persons.add(createOne("toto"));
        persons.add(createOne("titi"));
        persons.add(createOne("tata"));
        persons.add(createOne("tutu"));
        persons.add(createOne("tonton"));
        return persons;
    }
}
