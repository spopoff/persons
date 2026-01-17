/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.spopoff.persons;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 *
 * @author steph
 */
public class ArrayNodeTest {
    @Test
    public void testArray() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<String>> attributes = new HashMap<>();
        String[] arrKey = {"fdgdgdgd"};
        List<String> key = new ArrayList<>(Arrays.asList(arrKey));
        attributes.put("key", key);
        String[] arrPer = {"tata"};
        List<String> per = new ArrayList<>(Arrays.asList(arrPer));
        attributes.put("appName", per);
        String[] arrPj = {"pj1", "pj2"};
        List<String> pj = new ArrayList<>(Arrays.asList(arrPj));
        attributes.put("projects", pj);

          ObjectNode node = mapper.createObjectNode();
          node.set("key", node.textNode(attributes.get("key").get(0)));
          node.set("appName", node.textNode(attributes.get("appName").get(0)));
          ArrayNode pja = node.putArray("projects");
          if(attributes.get("projects") != null && !attributes.get("projects").isEmpty()){
            for(String val : attributes.get("projects")){
                  pja.add(node.textNode(val));
                }
          }
          //inverse objet vers tableau
          /*
            return [
            appName:node.get("appName").textValue(), 
            projects:node.getAll("projects"),
            __NAME__:node.get("login").textValue(),
            __UID__:node.get("login").textValue()
          ];

          */
          Map<String, Object> retour = new java.util.LinkedHashMap<>();
          retour.put("key", node.get("key"));
          retour.put("appName", node.get("appName"));
          retour.put("projects", node.get("projects"));
          TypeReference<ArrayList<String>> typeL  = new TypeReference<ArrayList<String>>() {};
          Class<?> myClass = List.class;
          
          List<String> pjs = mapper.readValue(node.get("projects").traverse(), List.class);
          
          TypeReference<HashMap<String, Object>> typeRef  = new TypeReference<HashMap<String, Object>>() {};
          Map<String, Object> map = mapper.readValue(node.traverse(), typeRef);
    }
    
}
