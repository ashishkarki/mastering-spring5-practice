package com.karkia.spring5.practice.controller;

import com.karkia.spring5.practice.bean.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {

    private Log logger = LogFactory.getLog(UserController.class);

    @RequestMapping(value = "/create-user", method = RequestMethod.GET)
    public String showCreateUserPage(ModelMap model) {
        // used to set up the model with an empty form-backing object
        model.addAttribute("user", new User());

        return "user";
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public String addTodo(User user) {
        logger.info("user details: " + user);
        return "redirect:list-users";
    }

    @RequestMapping(value = "create-user-with-validation", method = RequestMethod.POST)
    public String addTodoWithValidation(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user";
        }

        logger.info("user details with validation" + user);

        return "redirect: list-users";
    }

    @RequestMapping(value = "/list-users", method = RequestMethod.GET)
    public String showAllUsers() {
        return "list-users";
    }

}
