package net.spopoff.persons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SpringBootApplication
public class PersonsApplication {
    private static final Log log = LogFactory.getLog(PersonsApplication.class);   
	public static void main(String[] args) {
            log.info("startup main");
            SpringApplication.run(PersonsApplication.class, args);
	}
}
