package com.service.godash.payload;

import lombok.Data;

@Data
public class ResponseStatus {

    private Integer httpStatus;

    private String description;
}
