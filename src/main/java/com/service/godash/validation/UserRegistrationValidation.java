package com.service.godash.validation;

import com.service.godash.dto.UserRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

import static com.service.godash.constants.IConstants.*;

@Component
@Slf4j
public class UserRegisterValidation {

    public void validateRequest(UserRegistrationRequest request) throws Exception {
        if (StringUtils.hasLength(request.getEmail())){
            validateRegex(request.getEmail(), EMAIL_REGEX, ERR_EMAIL_LENGTH);
        }
        else if (StringUtils.hasLength(request.getPhone())){
            validateRegex(request.getEmail(), PHONE_REGEX, ERR_PHONE_LENGTH);
        }
    }

    private void validateRegex(String value,String regex,String message) throws Exception {
        boolean isValid= Pattern.compile(regex).matcher(value.trim()).matches();
        if(!isValid){
            throw new Exception(message);
        }
    }
}
