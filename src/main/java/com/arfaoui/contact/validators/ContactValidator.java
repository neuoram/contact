package com.arfaoui.contact.validators;

import com.arfaoui.contact.dto.ContactDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ContactValidator {

    public static List<String> validateContact(ContactDto contactDto) {
        List<String> errors = new ArrayList<>();
        if (contactDto == null) {
            errors.add("Please fill the name");
            errors.add("Please fill the description");
            return  errors;
        }
        if (StringUtils.isEmpty(contactDto.getName())) {
            errors.add("Please fill the name");
        }
        if (StringUtils.isEmpty(contactDto.getDescription())) {
            errors.add("Please fill the description");
        }
        return errors;
    }
}
