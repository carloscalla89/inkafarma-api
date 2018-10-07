package com.inkafarma.personsapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseError {
    private String message;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ResponseErrorDetail> errors;

    public ResponseError(String message) {
        this.message = message;
    }
}
