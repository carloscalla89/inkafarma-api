package com.inkafarma.personsapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonSearchResponse {

    @ApiModelProperty(notes = "Nombre de la Persona",dataType = "String",example = "Carlos")
    private String name;

    @ApiModelProperty(notes = "Apellido de la Persona",dataType = "String",example = "Calla")
    private String lastName;

    @ApiModelProperty(notes = "Edad de la Persona",dataType = "String",example = "28")
    private Integer age;

    @ApiModelProperty(notes = "Fecha de Nacimiento de la Persona",dataType = "String",example = "21/05/1989")
    private String birthDate;


    private Integer averageAge;

    @ApiModelProperty(notes = "Fecha probable de muerte la persona",dataType = "String",example = "14/03/2030")
    private String deathDateProbable;

    private PersonSearchResponse(String nombre, String apellido, Integer edad, String fechaNacimiento,
                                 Integer edadPromedio, String fechaProbableMuerte) {
        this.name = nombre;
        this.lastName = apellido;
        this.age = edad;
        this.birthDate = fechaNacimiento;
        this.averageAge = edadPromedio;
        this.deathDateProbable = fechaProbableMuerte;
    }

    public static PersonBuilder builder() { return new PersonBuilder();}

    public static class PersonBuilder {
        private String name;
        private String lastName;
        private Integer age;
        private String birthDate;
        private Integer averageAge;
        private String deathDateProbable;

        public PersonBuilder setNombre(String nombre) {
            this.name = nombre;
            return this;
        }

        public PersonBuilder setApellido(String apellido) {
            this.lastName = apellido;
            return this;
        }

        public PersonBuilder setEdad(Integer edad) {
            this.age = edad;
            return this;
        }

        public PersonBuilder setFechaNacimiento(String fechaNacimiento) {
            this.birthDate = fechaNacimiento;
            return this;
        }

        public PersonBuilder setEdadPromedio(Integer edadPromedio) {
            this.averageAge = edadPromedio;
            return this;
        }

        public PersonBuilder setFechaProbableMuerte(String fechaProbableMuerte) {
            this.deathDateProbable = fechaProbableMuerte;
            return this;
        }
        public PersonSearchResponse build() { return new PersonSearchResponse(name, lastName, age,
                birthDate, averageAge, deathDateProbable);}
    }

}
