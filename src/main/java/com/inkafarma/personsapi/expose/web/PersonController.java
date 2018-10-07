package com.inkafarma.personsapi.expose.web;

import com.inkafarma.personsapi.model.PersonRegisterRequest;
import com.inkafarma.personsapi.model.PersonSearchResponse;
import com.inkafarma.personsapi.model.ResponseError;
import com.inkafarma.personsapi.service.PersonService;
import com.inkafarma.personsapi.util.exception.CustomValidationException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Void> registerPerson(@Valid @RequestBody PersonRegisterRequest personRegisterRequest, BindingResult bindingResult) throws Exception {
        log.info("init controller person registerPerson");

        if (bindingResult.hasErrors()) {
            throw new CustomValidationException(bindingResult);
        }

        if (personService.addPerson(personRegisterRequest)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @ApiOperation(value = "Promedio de edad de las personas" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta Satisfactoria"),
            @ApiResponse(code = 400, message = "Recurso no disponible", response = ResponseError.class),
            @ApiResponse(code = 500, message = "Error en el servicio", response = ResponseError.class)
    })
    @GetMapping(value="/averageAge")
    public ResponseEntity<PersonSearchResponse> averageAge() throws Exception {
        log.info("init controller person averageAge");

        return ResponseEntity.ok(personService.averageAge());

    }

 }
