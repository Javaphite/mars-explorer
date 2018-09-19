package home.javaphite.explorer.controller;

import home.javaphite.explorer.model.exceptions.InvalidDirectionNameException;
import home.javaphite.explorer.model.exceptions.UnknownObjectIdException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExplorerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({UnknownObjectIdException.class, InvalidDirectionNameException.class, ArrayIndexOutOfBoundsException.class})
    protected ModelAndView invalidCommandArgsHandler(Exception exception) {
        ModelAndView modelAndView = new ModelAndView("myerror");
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }
}
