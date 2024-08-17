package com.azish.juni5.phone;

import java.util.regex.Pattern;

public class PhoneValidationServiceImpl implements PhoneValidationService {

    private final Pattern phoneRegex = Pattern.compile("^\\+?(?:[0-9] ?){6,14}[0-9]$");

    @Override
    public boolean validatePhone(String phone) {
        return phone != null && phoneRegex.matcher(phone).matches();
    }

}
