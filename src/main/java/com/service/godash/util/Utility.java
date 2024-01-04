package com.service.godash.util;

import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class Utility {

    public String generateShortUUID() {
        String uuid = UUID.randomUUID().toString();
        // Extracting 12 characters from the middle of the UUID
        String shortUUID = uuid.substring(9, 21);

        return shortUUID;
    }

}
