package com.service.godash.payload;

import lombok.Data;

@Data
public class ServiceResponse {

    private int responseCode;
    private String serviceStatus;
    private String responseMessage;
}
