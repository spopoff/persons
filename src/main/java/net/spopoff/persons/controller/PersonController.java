/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.spopoff.persons.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;
import net.spopoff.persons.entity.Change;
import net.spopoff.persons.entity.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    Map<String, Person> personnes;

    @Autowired
    TreeSet<Long> changements;
    
    private final Logger log = LogManager.getLogger(PersonController.class);
    @GetMapping(path="/{personId}", produces = "application/json")
    public ResponseEntity<Person> getPerson(@PathVariable String personId){
        log.info("Demande personid {}", personId);
        Person novo = new Person();
        novo.createOne(personId);
        personnes.put(personId, novo);
        return ResponseEntity.ok(novo);
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
            Long up = changements.last();
            up++;
            changements.add(up);
            if(boolValue){
                done.setLastChangeDate(up);
            }else{
                //on modifie
                person.setOperationalUnit("travail"+boolValue);
                done.setLastChangeDate(up);
            }
            ret.add(done);
        }
        return ret.toArray(new Change[0]);
    }
    private List<Person> donneTout(){
        return new ArrayList(personnes.values());
    }
}
