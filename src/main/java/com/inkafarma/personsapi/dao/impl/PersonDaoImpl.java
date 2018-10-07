package com.inkafarma.personsapi.dao.impl;

import com.inkafarma.personsapi.dao.PersonDao;
import com.inkafarma.personsapi.model.PersonDTO;
import com.inkafarma.personsapi.util.exception.DataNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<PersonDTO> getListPerson() throws Exception {
        List<PersonDTO> personDTOList = mongoTemplate.findAll(PersonDTO.class);

        return Optional.ofNullable(personDTOList).orElseThrow(() -> new DataNotFoundException("Error in getCollection"));
    }

    @Override
    public PersonDTO addPerson(PersonDTO personDTO) throws Exception {
        mongoTemplate.save(personDTO);
        return personDTO;
    }
}
