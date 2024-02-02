package com.service.godash.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Data
@Builder
@AllArgsConstructor
@ToString
public class ServiceResponse<T> {

    private ResponseStatus responseStatus;

    private T response;
}
