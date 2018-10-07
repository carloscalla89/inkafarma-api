package com.inkafarma.personsapi.dao.impl;

import com.inkafarma.personsapi.model.PersonDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonDaoImplTest {

    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private PersonDaoImpl personDao;

    @Test
    public void getListPerson() throws Exception {
        List<PersonDTO> list = Arrays.asList(new PersonDTO(),new PersonDTO());
        when(mongoTemplate.findAll(PersonDTO.class)).thenReturn(list);

        personDao.getListPerson();
    }

    @Test
    public void addPerson() throws Exception {
        personDao.addPerson(new PersonDTO());
    }
}