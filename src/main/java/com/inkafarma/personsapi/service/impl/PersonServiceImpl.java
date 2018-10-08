package com.inkafarma.personsapi.service.impl;

import com.inkafarma.personsapi.dao.PersonDao;
import com.inkafarma.personsapi.model.PersonRegisterRequest;
import com.inkafarma.personsapi.model.PersonSearchResponse;
import com.inkafarma.personsapi.model.PersonDTO;
import com.inkafarma.personsapi.service.PersonService;
import com.inkafarma.personsapi.util.Utilitario;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@Getter
@Setter
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public List<PersonSearchResponse> getListPerson() throws Exception {
        log.info("getListPerson:"+personDao);

        return personDao.getListPerson().stream().map(r -> PersonSearchResponse.builder()
                .setNombre(r.getName())
                .setApellido(r.getLastName())
                .setEdad(r.getAge())
                .setFechaNacimiento(r.getBirthDate())
                .setFechaProbableMuerte(Utilitario.getDeathDateEstimate(r.getBirthDate()))
        .build()).collect(Collectors.toList());
    }

    @Override
    public boolean addPerson(PersonRegisterRequest personRegisterRequest) throws Exception {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setName(personRegisterRequest.getName());
        personDTO.setLastName(personRegisterRequest.getLastName());
        personDTO.setAge(personRegisterRequest.getAge());
        personDTO.setBirthDate(personRegisterRequest.getBirthDate());

        return Optional.ofNullable(personDao.addPerson(personDTO).get_id()).filter(r -> r.length()>0 ).isPresent();
    }

    @Override
    public PersonSearchResponse averageAge() throws Exception {

        return PersonSearchResponse
                .builder()
                .setEdadPromedio((int) (personDao
                        .getListPerson().stream()
                        .mapToInt(PersonDTO::getAge).average().getAsDouble()))
                .build();


    }
}
