package com.karkia.spring5.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BasicController {

    @RequestMapping(value = "/welcome")
    // @RequestBody
    public String welcome() {
        return "Welcome to Spring MVC world!!";
    }

    @RequestMapping(value = "/welcome-view")
    public String welcomeView() {
        return "welcome";
    }

    @RequestMapping(value = "/welcome-model-map", method = RequestMethod.GET)
    public String welcomeViewModel(ModelMap model) {
        model.put("name", "AKarki");
        return "welcome-model-map";
    }

    @GetMapping(value = "/welcome-model-view")
    public ModelAndView welcomeModelView(ModelMap model) {
        model.put("name", "ashish karki");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome-model-view");
        modelAndView.getModel().putAll(model);

        return modelAndView;
    }
}
