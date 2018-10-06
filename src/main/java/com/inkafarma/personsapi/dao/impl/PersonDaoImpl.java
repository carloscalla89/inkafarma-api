package com.inkafarma.personsapi.dao.impl;

import com.inkafarma.personsapi.dao.PersonDao;
import com.inkafarma.personsapi.model.PersonDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<PersonDTO> getListPerson() throws Exception {
        List<PersonDTO> personDTOList = mongoTemplate.findAll(PersonDTO.class);
        log.info("personDTOList:"+personDTOList);
        log.info("lista:"+personDTOList.size());
        return personDTOList;
    }

    @Override
    public PersonDTO addPerson(PersonDTO personDTO) throws Exception {
        mongoTemplate.save(personDTO);
        return personDTO;
    }
}
