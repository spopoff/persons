/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.spopoff.persons;

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
        attributes.put("personName", per);
        String[] arrPj = {"pj1", "pj2"};
        List<String> pj = new ArrayList<>(Arrays.asList(arrPj));
        attributes.put("projects", pj);

          ObjectNode node = mapper.createObjectNode();
          node.set("key", node.textNode(attributes.get("key").get(0)));
          node.set("personName", node.textNode(attributes.get("personName").get(0)));
          ArrayNode pja = node.putArray("projects");
          if(attributes.get("projects") != null && !attributes.get("projects").isEmpty()){
            for(String val : attributes.get("projects")){
                  pja.add(node.textNode(val));
                }
          }

    }
    
}
