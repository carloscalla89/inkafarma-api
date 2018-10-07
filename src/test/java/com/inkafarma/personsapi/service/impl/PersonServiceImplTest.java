package com.inkafarma.personsapi.service.impl;

import com.inkafarma.personsapi.dao.PersonDao;
import com.inkafarma.personsapi.model.PersonDTO;
import com.inkafarma.personsapi.model.PersonRegisterRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;

import static javafx.scene.input.KeyCode.M;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonServiceImplTest {

    @Mock
    private PersonDao personDao;

    @InjectMocks
    private PersonServiceImpl personService;

    @Test
    public void getListPerson() throws Exception {

        when(personDao.getListPerson()).thenReturn(Arrays.asList(new PersonDTO()));
        personService.getListPerson();
    }

    @Test
    public void addPerson() throws Exception {
        PersonRegisterRequest personRegisterRequest = new PersonRegisterRequest();
        personRegisterRequest.setName("carlos");
        personRegisterRequest.setLastName("calla");
        personRegisterRequest.setAge(29);
        personRegisterRequest.setBirthDate("1989-05-21");
        when(personDao.addPerson(any())).thenReturn(new PersonDTO());
        personService.addPerson(personRegisterRequest);
    }

    @Test
    public void averageAge() throws Exception {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setAge(40);
        when(personDao.getListPerson()).thenReturn(Arrays.asList(personDTO));
        personService.averageAge();

    }
}