package com.udayanga.form.web;

import com.udayanga.form.model.Place;
import com.udayanga.form.service.PlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PlaceController {
    private final Logger logger = LoggerFactory.getLogger(CityController.class);

    private PlaceService placeService;

    @Autowired
    public void setPlaceService(PlaceService placeService) {
        this.placeService = placeService;
    }

    // list page
    @RequestMapping(value = "/places", method = RequestMethod.GET)
    public String showAllCities(Model model) {

        logger.debug("showAllPlaces()");
        model.addAttribute("places", placeService.findAll());
        return "place/list";

    }

    @RequestMapping(value = "/places", method = RequestMethod.POST)
    public String saveOrUpdateCity(@ModelAttribute("placeForm") @Validated Place place, BindingResult result,
                                   Model model, final RedirectAttributes redirectAttributes) {
        logger.debug("saveOrUpdatePlace() : {})", place);
        if (result.hasErrors()) {
            populateDefaultModel(model);
            return "place/placeform";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if (place.isNew()) {
                redirectAttributes.addFlashAttribute("msg", "City added successfully!");
            } else {
                redirectAttributes.addFlashAttribute("msg", "City updated successfully!");
            }

            placeService.saveOrUpdate(place);

            // POST/REDIRECT/GET
            return "redirect:/places/" + place.getPlaceId();

            // POST/FORWARD/GET
            // return "user/list";

        }
    }

    // show add user form
    @RequestMapping(value = "/places/add", method = RequestMethod.GET)
    public String showAddUserForm(Model model) {

        logger.debug("showAddPlaceForm()");

        Place place = new Place();

        // set default value

        place.setPlaceName("Default Name");
        place.setPlaceDescription("Default Description");
        place.setRate(5);
        place.setPlaceType("Default type");
        place.setCityId(1);
        place.setPlaceImgUrl("Image");
        model.addAttribute("placeForm", place);

        populateDefaultModel(model);

        return "pace/placeform";

    }

    // show update form
    @RequestMapping(value = "/places/{id}/update", method = RequestMethod.GET)
    public String showUpdateUserForm(@PathVariable("id") int id, Model model) {

        logger.debug("showUpdatePlaceForm() : {}", id);

        Place place = placeService.findById(id);
        model.addAttribute("placeForm", place);

        populateDefaultModel(model);

        return "place/placeform";

    }


    // delete user
    @RequestMapping(value = "/places/{id}/delete", method = RequestMethod.POST)
    public String deleteUser(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        logger.debug("deletePlace() : {}", id);

        placeService.delete(id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "User is deleted!");

        return "redirect:/places";

    }

    // show user
    @RequestMapping(value = "/places/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") int id, Model model) {

        logger.debug("showPlace() id: {}", id);

        Place place = placeService.findById(id);
        if (place == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User not found");
        }
        model.addAttribute("place", place);

        return "place/show";

    }

    private void populateDefaultModel(Model model) {

        List<String> frameworksList = new ArrayList<String>();
        frameworksList.add("Spring MVC");
        frameworksList.add("Struts 2");
        frameworksList.add("JSF 2");
        frameworksList.add("GWT");
        frameworksList.add("Play");
        frameworksList.add("Apache Wicket");
        model.addAttribute("frameworkList", frameworksList);

        Map<String, String> skill = new LinkedHashMap<String, String>();
        skill.put("Hibernate", "Hibernate");
        skill.put("Spring", "Spring");
        skill.put("Struts", "Struts");
        skill.put("Groovy", "Groovy");
        skill.put("Grails", "Grails");
        model.addAttribute("javaSkillList", skill);

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        model.addAttribute("numberList", numbers);

        Map<String, String> country = new LinkedHashMap<String, String>();
        country.put("US", "United Stated");
        country.put("CN", "China");
        country.put("SG", "Singapore");
        country.put("MY", "Malaysia");
        model.addAttribute("countryList", country);

    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ModelAndView handleEmptyData(HttpServletRequest req, Exception ex) {

        logger.debug("handleEmptyData()");
        logger.error("Request: {}, error ", req.getRequestURL(), ex);

        ModelAndView model = new ModelAndView();
        model.setViewName("place/show");
        model.addObject("msg", "City not found");

        return model;

    }
}
