package com.udayanga.form.web;

import com.udayanga.form.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CityController {
    private final Logger logger = LoggerFactory.getLogger(CityController.class);

    private CityService cityService;

    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    // list page
    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public String showAllCities(Model model) {

        logger.debug("showAllCities()");
        model.addAttribute("cities", cityService.findAll());
        return "city/list";

    }



}
