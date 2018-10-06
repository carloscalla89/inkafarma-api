package com.inkafarma.personsapi.expose.web;

import com.inkafarma.personsapi.model.PersonRegisterRequest;
import com.inkafarma.personsapi.model.PersonSearchResponse;
import com.inkafarma.personsapi.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-inkafarma")
@Slf4j
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value="/getPersons")
    public ResponseEntity<List<PersonSearchResponse>> getListPersons() throws Exception {
        log.info("init controller person getListPersons");
        return ResponseEntity.ok(personService.getListPerson());
    }

    @PostMapping(value="/registerPerson")
    public ResponseEntity<Void> registerPerson(@RequestBody PersonRegisterRequest person) throws Exception {
        log.info("init controller person getListPersons");

        if (personService.addPerson(person)) {
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
 }
