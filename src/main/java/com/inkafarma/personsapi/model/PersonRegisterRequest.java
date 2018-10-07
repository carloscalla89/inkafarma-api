package com.inkafarma.personsapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class PersonRegisterRequest {


    @ApiModelProperty(notes = "Nombre de la Persona",dataType = "String",example = "Carlos")
    @NotEmpty
    @NotNull
    private String nombre;

    @NotEmpty
    @NotNull
    @ApiModelProperty(notes = "Apellido de la Persona",dataType = "String",example = "Calla")
    private String apellido;

    @NotNull
    @ApiModelProperty(notes = "Edad de la Persona",dataType = "String",example = "28")
    private Integer edad;

    @Pattern(regexp="^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))$",
            message="Formato de fecha incorrecto. El formato es YYYY-mm-dd")
    @NotEmpty
    @NotNull
    @ApiModelProperty(notes = "Fecha de Nacimiento de la Persona",dataType = "String",example = "1989/05/21")
    private String fechaNacimiento;
}
