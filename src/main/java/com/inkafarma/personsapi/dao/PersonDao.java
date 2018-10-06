package com.inkafarma.personsapi.dao;

import com.inkafarma.personsapi.model.PersonDTO;

import java.util.List;

public interface PersonDao {
    List<PersonDTO> getListPerson() throws Exception;
    PersonDTO addPerson(PersonDTO personDTO) throws Exception;
}
