package com.inkafarma.personsapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonSearchResponse {

    private String nombre;
    private String apellido;
    private int edad;
    private String fechaNacimiento;
    private int edadPromedio;
    private String fechaProbableMuerte;

    private PersonSearchResponse(String nombre, String apellido, int edad, String fechaNacimiento,
                                 int edadPromedio, String fechaProbableMuerte) {
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
        private int edad;
        private String fechaNacimiento;
        private int edadPromedio;
        private String fechaProbableMuerte;

        public PersonBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public PersonBuilder setApellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public PersonBuilder setEdad(int edad) {
            this.edad = edad;
            return this;
        }

        public PersonBuilder setFechaNacimiento(String fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }

        public PersonBuilder setEdadPromedio(int edadPromedio) {
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
