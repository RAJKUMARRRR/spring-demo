package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    @Autowired
    private Person person;

    @RequestMapping("/")
    public String healthCheck(){
        return "Ok";
    }


    @RequestMapping("/person/get")
    public Person getPerson(@RequestParam(name="name", required=false, defaultValue="Unknown") String name) {
        person.setName("Rajkumar");
        person.setEmail("yes@email.com");
        return person;
    }

    @RequestMapping(value="/person/update",method = RequestMethod.POST,consumes = "application/json")
    public Person updatePerson(@RequestBody Person p){
        person.setName(p.getName());
        person.setEmail(p.getEmail());
        return person;
    }
}
