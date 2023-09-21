package com.vincent.clinic.global.error;

import com.vincent.clinic.global.code.ErrorCode;
import com.vincent.clinic.global.error.exception.BusinessException;
import com.vincent.clinic.global.view.AlertView;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice(annotations = { Controller.class })
public class GlobalControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ModelAndView handleMethodArgumentNotValidException() {
        return getAlertModelAndView(ErrorCode.INVALID_INPUT_VALUE.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ModelAndView handleHttpRequestMethodNotSupportedException() {
        return getAlertModelAndView(ErrorCode.METHOD_NOT_ALLOWED.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    protected ModelAndView handleBusinessException(final BusinessException e) {
        return getAlertModelAndView(e.getMessage());
    }

    private ModelAndView getAlertModelAndView(String message) {
        ModelAndView mv = new ModelAndView(new AlertView());
        mv.addObject("message", message);
        return mv;
    }
}
