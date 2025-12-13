/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.spopoff.persons.controller;

import java.util.ArrayList;
import java.util.List;
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
        List<Person> persons = new ArrayList<>();
        persons.add(createOne("toto"));
        persons.add(createOne("titi"));
        persons.add(createOne("tata"));
        persons.add(createOne("tutu"));
        persons.add(createOne("tonton"));
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
}
