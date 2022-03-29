package com.cat.tech.controller;

import com.cat.tech.domain.Person;
import com.cat.tech.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getPerson(@RequestParam String first, @RequestParam String last) {
        log.info("search data...");
        return personService.getPersonByName(first, last);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public String addPerson(@RequestBody Person person) {
        log.info("saving data...");
        personService.savePerson(person);
        return "Added data successfully.";
    }
}
