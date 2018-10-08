package com.inkafarma.personsapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseErrorDetail {
    @ApiModelProperty(notes = "Nombre del campo de error",dataType = "String")
    private String field;

    @ApiModelProperty(notes = "Etiqueta de error del campo",dataType = "String")
    private String code;

    @ApiModelProperty(notes = "Descripción del detalle del error",dataType = "Object")
    private Object description;

    public ResponseErrorDetail(String field, Object rejectedValue) {
        this.field = field;
        this.description = rejectedValue;
    }

    public ResponseErrorDetail(String field, String code, Object rejectedValue) {
        this.field = field;
        this.code = code;
        this.description = rejectedValue;
    }
    public ResponseErrorDetail(Object rejectedValue) {
        this.description = rejectedValue;

    }
}
