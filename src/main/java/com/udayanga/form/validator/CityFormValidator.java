package com.udayanga.form.validator;

import com.udayanga.form.model.City;
import com.udayanga.form.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CityFormValidator implements Validator {



    @Autowired
    CityService cityService;


    @Override
    public boolean supports(Class<?> aClass) {
        return City.class.equals(aClass);
    }


    @Override
    public void validate(Object o, Errors errors) {
        City city = (City) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name", "NotEmpty.cityForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"description", "NotEmpty.cityForm.description");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"rate", "NotEmpty.cityForm.rate");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"imgUrl", "NotEmpty.cityForm.imgUrl");

    }
}
