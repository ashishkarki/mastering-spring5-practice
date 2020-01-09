package com.karkia.spring5.practice.exception;

import lombok.val;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {
    private Log logger = LogFactory.getLog(ExceptionController.class);

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleException(HttpServletRequest request, Exception ex) {
        logger.error("Request: " + request.getRequestURL()
                + " Threw an exception: " + ex);

        val modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.setViewName("common/spring-mvc-error");

        return modelAndView;
    }
}
