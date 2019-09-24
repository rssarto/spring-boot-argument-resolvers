package com.resolvers.controllers;

import com.resolvers.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(PersonController.URI_PREFIX)
public class PersonController {

    public static final String URI_PREFIX = "/api/person";

    @GetMapping
    public ResponseEntity<List<Person>> findAllPeople(@RequestParam MultiValueMap<String, String> params){

        final List<Person> people = new ArrayList<>();
        final Person person = new Person("Ricardo", LocalDate.now());
        people.add(person);

        return new ResponseEntity<>(people, HttpStatus.OK);
    }


}
