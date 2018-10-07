package com.inkafarma.personsapi.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection="PersonCollection2")
public class PersonDTO {
    @Id
    private String _id;
    private String nombre;
    private String apellido;
    private int edad;
    private String fechaNacimiento;

}
