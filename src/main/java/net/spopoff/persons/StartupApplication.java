/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.spopoff.persons;

import java.util.Map;
import java.util.TreeSet;
import net.spopoff.persons.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author steph
 */
@Component
public class StartupApplication implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    Map<String, Person> personnes;
    @Autowired
    TreeSet<Long> changements;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        changements.add(10L);
        Person un  = new Person();
        personnes.put("toto", un.createOne("toto"));
        un  = new Person();
        personnes.put("titi", un.createOne("titi"));
        un  = new Person();
        personnes.put("tata", un.createOne("tata"));
        un  = new Person();
        personnes.put("tutu", un.createOne("tutu"));
        un  = new Person();
        personnes.put("tonton", un.createOne("tonton"));
    }
    
}
