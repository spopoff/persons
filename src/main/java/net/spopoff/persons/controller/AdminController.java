/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.spopoff.persons.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;
import net.spopoff.persons.entity.Admin;
import net.spopoff.persons.entity.Change;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author steph
 */
@RestController
@RequestMapping("admins")
public class AdminController {
    
    @Autowired
    Map<String, Admin> admins;

    @Autowired
    TreeSet<Long> changements;
    
    private final Logger log = LogManager.getLogger(AdminController.class);
    
    @DeleteMapping(path="/{uId}", produces = "application/json")
    public ResponseEntity<String> getAdminDelete(@PathVariable String uId){
        log.info("delete uId {}", uId);
        boolean done = false;
        if(admins.containsKey(uId)){
            admins.remove(uId);
            done = true;
        }else{
            for(Admin admin : admins.values()){
                if(admin.getKey() != null && !admin.getKey().isEmpty()
                        && admin.getKey().equals(uId)){
                    admins.remove(admin.getPersonName());
                    done = true;
                    break;
                }
            }
        }
        if(done){
            return ResponseEntity.ok(uId+" deleted");
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping(value="add",produces = "application/json")
    public ResponseEntity<String> addAdmin(@RequestBody Admin admin){
        log.info("add admin personName {}", admin.getPersonName());
        boolean found = false;
        if(admins.containsKey(admin.getPersonName())){
            found = true;
        }else{
            admins.put(admin.getPersonName(), admin);
        }
        if(!found){
            return ResponseEntity.ok(admin.getPersonName()+" added");
        }
        return ResponseEntity.unprocessableEntity().build();
    }
    
    @PutMapping(path="/{uId}", produces = "application/json")
    public ResponseEntity<String> getAdminUpdate(@PathVariable String uId, 
            @RequestBody Admin admin){
        log.info("update uId {}", uId);
        boolean done = false;
        if(admins.containsKey(uId)){
            admins.put(uId, attributeUpdate(admin, admins.get(uId)));
            done = true;
        }else{
            for(Admin tgt : admins.values()){
                if(admin.getKey() != null && !admin.getKey().isEmpty()
                        && admin.getKey().equals(uId)){
                    admins.put(tgt.getPersonName(), attributeUpdate(admin, tgt));
                    done = true;
                    break;
                }
            }
        }
        if(done){
            return ResponseEntity.ok(uId+" updated");
        }
        return ResponseEntity.notFound().build();
    }
    private Admin attributeUpdate(Admin src, Admin tgt){
        if(src.getKey()!= null && !src.getKey().isEmpty()){
            tgt.setKey(src.getKey());
        }
        return tgt;
    }
    @GetMapping(path="/{uId}", produces = "application/json")
    public ResponseEntity<Admin> getAdmin(@PathVariable String uId){
        log.info("Demande admin personName {}", uId);
        Admin ret = null;
        if(admins.containsKey(uId)){
            ret = admins.get(uId);
        }else{
            for(Admin admin : admins.values()){
                if(admin.getKey() != null && !admin.getKey().isEmpty()
                        && admin.getKey().equals(uId)){
                    ret = admins.get(admin.getPersonName());
                    break;
                }
            }
        }
        if(ret == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ret);
    }
    @GetMapping(path="", produces = "application/json")
    public ResponseEntity<String> getAdminTest(){
        log.info("Demande test");
        return ResponseEntity.ok("OK");
    }
    @GetMapping(path="/", produces = "application/json")
    public ResponseEntity<List<Admin>> getAdmin(){
        log.info("Demande admin tout");
        List<Admin> admins = donneTout();
        return ResponseEntity.ok(admins);
    }
    @GetMapping(path="/changelog", produces = "application/json")
    public ResponseEntity<Change[]> getChangement(){
        log.info("Demande admin changeLog rien");
        if(changements.size() == 1){
            return ResponseEntity.ok(createChangement(true, true));
        }
        return ResponseEntity.ok(createChangement(true, false));
    }
    @GetMapping(path="/changelog?from={time}", produces = "application/json")
    public ResponseEntity<Change[]> getChangementFrom(@PathVariable String time){
        log.info("Demande admin changeLog "+time);
        return ResponseEntity.ok(createChangement(false, false));
    }
    private Change[] createChangement(boolean isTime, boolean once){
        List<Change> ret = new ArrayList<>();
        Random random = new Random();
        List<Admin> aadmins = donneTout();
        List<String> deleted = new ArrayList<>();
        boolean boolValue;
        Admin novo = new Admin();
        novo.createOne("novo"+random.nextInt(250, 3000));
        Long up, upP;
        for(Admin admin : aadmins){
            try{
                Thread.sleep(100);
            }catch(InterruptedException ex){}
            boolValue = random.nextBoolean();
            if(once) boolValue = false;
            Change done = new Change(admin);
            done.setDeleted(boolValue);
            up = new Date().getTime();
            upP = changements.last();
            log.info("1 up="+up+" upP="+upP);
            if(upP >= up) up = upP++;
            up = up++;
            log.info("2 up="+up+" upP="+upP);
            changements.add(up);
            if(boolValue){
                //on supprime
                deleted.add(admin.getPersonName());
                done.setLastChangeDate(up);
            }else{
                //on modifie
                if(!once) admin.getProjects().add("travail"+up);
                done.setLastChangeDate(up);
            }
            ret.add(done);
        }
        if(!once){
            try{
                Thread.sleep(100);
            }catch(InterruptedException ex){}
            up = new Date().getTime();
            upP = changements.last();
            if(upP > up) up = upP++;
            up = up++;
            Change done = new Change(novo);
            done.setDeleted(false);
            done.setLastChangeDate(up);
            changements.add(up);
            ret.add(done);
            for(String one : deleted){
                admins.remove(one);
            }
            novo.getProjects().add("travail"+up);
            admins.put(novo.getPersonName(), novo);
        }
        return ret.toArray(new Change[0]);
    }
    private List<Admin> donneTout(){
        return new ArrayList(admins.values());
    }
}
