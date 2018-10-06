package com.inkafarma.personsapi.expose.web;

import com.inkafarma.personsapi.model.PersonRegisterRequest;
import com.inkafarma.personsapi.model.PersonSearchResponse;
import com.inkafarma.personsapi.model.ResponseError;
import com.inkafarma.personsapi.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-inkafarma")
@Api(value="Api Person", description = "Operaciones para el recurso que expone el API Persons")
@Slf4j
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @ApiOperation(value = "Listar Personas", response  = PersonSearchResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listado Satisfactorio", responseContainer = "List",  response = PersonSearchResponse.class),
            @ApiResponse(code = 400, message = "Recurso no disponible", response = ResponseError.class),
            @ApiResponse(code = 500, message = "Error en el servicio", response = ResponseError.class)
    })
    @GetMapping(value="/getPersons", produces = "application/json")
    public ResponseEntity<List<PersonSearchResponse>> getListPersons() throws Exception {
        log.info("init controller person getListPersons");
        return ResponseEntity.ok(personService.getListPerson());
    }

    @ApiOperation(value = "Registrar una persona" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Registro Satisfactorio"),
            @ApiResponse(code = 400, message = "Recurso no disponible", response = ResponseError.class),
            @ApiResponse(code = 500, message = "Error en el servicio", response = ResponseError.class)
    })
    @PostMapping(value="/registerPerson")
    public ResponseEntity<Void> registerPerson(@RequestBody PersonRegisterRequest person) throws Exception {
        log.info("init controller person getListPersons");

        if (personService.addPerson(person)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
 }
