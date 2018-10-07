package com.inkafarma.personsapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseError {
    @ApiModelProperty(notes = "Descripción del Error",dataType = "String")
    private String message;

    @ApiModelProperty(notes = "Listado de errores específicos",dataType = "List")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ResponseErrorDetail> errors;

    public ResponseError(String message) {
        this.message = message;
    }
}
