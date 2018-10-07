package com.inkafarma.personsapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonSearchResponse {

    @ApiModelProperty(notes = "Nombre de la Persona",dataType = "String",example = "Carlos")
    private String nombre;

    @ApiModelProperty(notes = "Apellido de la Persona",dataType = "String",example = "Calla")
    private String apellido;

    @ApiModelProperty(notes = "Edad de la Persona",dataType = "String",example = "28")
    private Integer edad;

    @ApiModelProperty(notes = "Fecha de Nacimiento de la Persona",dataType = "String",example = "21/05/1989")
    private String fechaNacimiento;


    private Integer edadPromedio;

    @ApiModelProperty(notes = "Fecha probable de muerte la persona",dataType = "String",example = "14/03/2030")
    private String fechaProbableMuerte;

    private PersonSearchResponse(String nombre, String apellido, Integer edad, String fechaNacimiento,
                                 Integer edadPromedio, String fechaProbableMuerte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.edadPromedio = edadPromedio;
        this.fechaProbableMuerte = fechaProbableMuerte;
    }

    public static PersonBuilder builder() { return new PersonBuilder();}

    public static class PersonBuilder {
        private String nombre;
        private String apellido;
        private Integer edad;
        private String fechaNacimiento;
        private Integer edadPromedio;
        private String fechaProbableMuerte;

        public PersonBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public PersonBuilder setApellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public PersonBuilder setEdad(Integer edad) {
            this.edad = edad;
            return this;
        }

        public PersonBuilder setFechaNacimiento(String fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }

        public PersonBuilder setEdadPromedio(Integer edadPromedio) {
            this.edadPromedio = edadPromedio;
            return this;
        }

        public PersonBuilder setFechaProbableMuerte(String fechaProbableMuerte) {
            this.fechaProbableMuerte = fechaProbableMuerte;
            return this;
        }
        public PersonSearchResponse build() { return new PersonSearchResponse(nombre, apellido, edad,
                fechaNacimiento, edadPromedio, fechaProbableMuerte);}
    }

}
