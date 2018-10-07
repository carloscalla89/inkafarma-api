package com.inkafarma.personsapi.service;

import com.inkafarma.personsapi.model.PersonRegisterRequest;
import com.inkafarma.personsapi.model.PersonSearchResponse;

import java.util.List;

public interface PersonService {
    List<PersonSearchResponse> getListPerson() throws Exception;
    boolean addPerson(PersonRegisterRequest personRegisterRequest) throws Exception;
    PersonSearchResponse averageAge() throws Exception;
}
