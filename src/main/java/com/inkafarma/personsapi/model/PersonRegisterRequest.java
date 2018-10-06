package com.inkafarma.personsapi.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonRegisterRequest {

    @ApiModelProperty(notes = "Nombre de la Persona",dataType = "String",example = "Carlos")
    private String nombre;

    @ApiModelProperty(notes = "Apellido de la Persona",dataType = "String",example = "Calla")
    private String apellido;

    @ApiModelProperty(notes = "Edad de la Persona",dataType = "String",example = "28")
    private int edad;

    @ApiModelProperty(notes = "Fecha de Nacimiento de la Persona",dataType = "String",example = "21/05/1989")
    private String fechaNacimiento;
}
