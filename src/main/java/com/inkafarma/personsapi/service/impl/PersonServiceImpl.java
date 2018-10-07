package com.inkafarma.personsapi.service.impl;

import com.inkafarma.personsapi.dao.PersonDao;
import com.inkafarma.personsapi.model.PersonRegisterRequest;
import com.inkafarma.personsapi.model.PersonSearchResponse;
import com.inkafarma.personsapi.model.PersonDTO;
import com.inkafarma.personsapi.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public List<PersonSearchResponse> getListPerson() throws Exception {
        log.info("getListPerson:"+personDao);

        return personDao.getListPerson().stream().map(r -> PersonSearchResponse.builder()
        .setNombre(r.getNombre())
        .setApellido(r.getApellido())
        .setEdad(r.getEdad())
        .setFechaNacimiento(r.getFechaNacimiento())
        .build()).collect(Collectors.toList());
    }

    @Override
    public boolean addPerson(PersonRegisterRequest personRegisterRequest) throws Exception {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setNombre(personRegisterRequest.getNombre());
        personDTO.setApellido(personRegisterRequest.getApellido());
        personDTO.setEdad(personRegisterRequest.getEdad());
        personDTO.setFechaNacimiento(personRegisterRequest.getFechaNacimiento());

        return Optional.ofNullable(personDao.addPerson(personDTO).get_id()).filter(r -> r.length()>0 ).isPresent();
    }
}
