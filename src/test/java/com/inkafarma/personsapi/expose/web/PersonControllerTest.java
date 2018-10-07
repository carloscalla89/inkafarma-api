package com.inkafarma.personsapi.expose.web;

import com.inkafarma.personsapi.model.PersonDTO;
import com.inkafarma.personsapi.model.PersonRegisterRequest;
import com.inkafarma.personsapi.model.PersonSearchResponse;
import com.inkafarma.personsapi.service.PersonService;
import com.inkafarma.personsapi.util.exception.CustomValidationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.beans.PropertyEditor;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonController personController;

    @Test
    public void getListPersons() throws Exception {
        PersonSearchResponse personSearchResponse =PersonSearchResponse.builder().setNombre("carlos").build();

        List<PersonSearchResponse> list = Arrays.asList(personSearchResponse);
        when(personService.getListPerson()).thenReturn(list);

        personController.getListPersons();

    }

    @Test
    public void registerPersonSuccess() throws Exception {
        PersonRegisterRequest personRegisterRequest = new PersonRegisterRequest();
        personRegisterRequest.setName("carlos");
        personRegisterRequest.setLastName("calla");
        personRegisterRequest.setAge(29);
        personRegisterRequest.setBirthDate("1989-05-21");

        when(personService.addPerson(any(PersonRegisterRequest.class))).thenReturn(true);
        personController.registerPerson(personRegisterRequest,getBindingResult(false));

    }

    @Test(expected = CustomValidationException.class)
    public void registerPersonErrorValidation() throws Exception {
        PersonRegisterRequest personRegisterRequest = new PersonRegisterRequest();
        personRegisterRequest.setName("carlos");
        personRegisterRequest.setLastName("calla");
        personRegisterRequest.setAge(29);
        personRegisterRequest.setBirthDate("1989/05-21");

        personController.registerPerson(personRegisterRequest,getBindingResult(true));

    }

    @Test
    public void registerPersonErrorRegister() throws Exception {
        PersonRegisterRequest personRegisterRequest = new PersonRegisterRequest();
        personRegisterRequest.setName("carlos");
        personRegisterRequest.setLastName("calla");
        personRegisterRequest.setAge(29);
        personRegisterRequest.setBirthDate("1989/05-21");

        when(personService.addPerson(any(PersonRegisterRequest.class))).thenReturn(false);
        personController.registerPerson(personRegisterRequest,getBindingResult(false));

    }

    private BindingResult getBindingResult(boolean hasError) {

        boolean hasErrorVal = hasError;

        BindingResult bindingResult = new BindingResult() {
            @Override
            public Object getTarget() {
                return null;
            }

            @Override
            public Map<String, Object> getModel() {
                return null;
            }

            @Override
            public Object getRawFieldValue(String s) {
                return null;
            }

            @Override
            public PropertyEditor findEditor(String s, Class<?> aClass) {
                return null;
            }

            @Override
            public PropertyEditorRegistry getPropertyEditorRegistry() {
                return null;
            }

            @Override
            public String[] resolveMessageCodes(String s) {
                return new String[0];
            }

            @Override
            public String[] resolveMessageCodes(String s, String s1) {
                return new String[0];
            }

            @Override
            public void addError(ObjectError objectError) {

            }

            @Override
            public String getObjectName() {
                return null;
            }

            @Override
            public void setNestedPath(String s) {

            }

            @Override
            public String getNestedPath() {
                return null;
            }

            @Override
            public void pushNestedPath(String s) {

            }

            @Override
            public void popNestedPath() throws IllegalStateException {

            }

            @Override
            public void reject(String s) {

            }

            @Override
            public void reject(String s, String s1) {

            }

            @Override
            public void reject(String s, Object[] objects, String s1) {

            }

            @Override
            public void rejectValue(String s, String s1) {

            }

            @Override
            public void rejectValue(String s, String s1, String s2) {

            }

            @Override
            public void rejectValue(String s, String s1, Object[] objects, String s2) {

            }

            @Override
            public void addAllErrors(Errors errors) {

            }

            @Override
            public boolean hasErrors() {
                return hasErrorVal;
            }

            @Override
            public int getErrorCount() {
                return 0;
            }

            @Override
            public List<ObjectError> getAllErrors() {
                return null;
            }

            @Override
            public boolean hasGlobalErrors() {
                return false;
            }

            @Override
            public int getGlobalErrorCount() {
                return 0;
            }

            @Override
            public List<ObjectError> getGlobalErrors() {
                return null;
            }

            @Override
            public ObjectError getGlobalError() {
                return null;
            }

            @Override
            public boolean hasFieldErrors() {
                return false;
            }

            @Override
            public int getFieldErrorCount() {
                return 0;
            }

            @Override
            public List<FieldError> getFieldErrors() {
                return null;
            }

            @Override
            public FieldError getFieldError() {
                return null;
            }

            @Override
            public boolean hasFieldErrors(String s) {
                return false;
            }

            @Override
            public int getFieldErrorCount(String s) {
                return 0;
            }

            @Override
            public List<FieldError> getFieldErrors(String s) {
                return null;
            }

            @Override
            public FieldError getFieldError(String s) {
                return null;
            }

            @Override
            public Object getFieldValue(String s) {
                return null;
            }

            @Override
            public Class<?> getFieldType(String s) {
                return null;
            }
        };

        return bindingResult;
    }
}