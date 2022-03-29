package com.cat.tech.service;

import com.cat.tech.repository.PersonRepository;
import com.cat.tech.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPersonByName(String first, String last) {
        return personRepository.findByFirstNameOrLastName(first, last);
    }

    public void savePerson(Person person) {
        if (StringUtils.hasLength(person.getId())) {
            person.setId(UUID.randomUUID().toString());
        }
        personRepository.save(person);
    }
}
