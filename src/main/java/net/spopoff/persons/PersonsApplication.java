package net.spopoff.persons;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import net.spopoff.persons.entity.Admin;
import net.spopoff.persons.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PersonsApplication {
    private static final Log log = LogFactory.getLog(PersonsApplication.class);
    
    public static void main(String[] args) {
        log.info("startup main");
        SpringApplication.run(PersonsApplication.class, args);
    }
    @Bean
    public Map<String, Person> personnes(){
        Map<String, Person> persons = new HashMap<>();
        return persons;
    
    }
    @Bean
    public TreeSet<Long> changements(){
        return new TreeSet<>();
    
    }
    @Bean
    public Map<String, Admin> admins(){
        Map<String, Admin> persons = new HashMap<>();
        return persons;
    
    }
}
