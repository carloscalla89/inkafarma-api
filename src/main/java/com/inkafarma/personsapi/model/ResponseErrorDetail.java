package com.inkafarma.personsapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseErrorDetail {
    private String field;
    private String code;
    private Object description;

    public ResponseErrorDetail(String field, String code, Object rejectedValue) {
        this.field = field;
        this.code = code;
        this.description = rejectedValue;
    }
    public ResponseErrorDetail(Object rejectedValue) {
        this.description = rejectedValue;

    }
}
