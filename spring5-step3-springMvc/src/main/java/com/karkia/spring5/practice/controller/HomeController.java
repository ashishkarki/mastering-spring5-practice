package com.karkia.spring5.practice.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * To demo how resource bundling and locale settings can be made to work with spring mvc
 */
public class HomeController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        return new ModelAndView("WelcomePage");
    }
}
