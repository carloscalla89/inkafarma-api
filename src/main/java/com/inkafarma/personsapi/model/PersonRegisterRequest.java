package com.inkafarma.personsapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonRegisterRequest {

    private String nombre;
    private String apellido;
    private int edad;
    private String fechaNacimiento;
}
