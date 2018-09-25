package home.javaphite.explorer.controllers;

import home.javaphite.explorer.model.exceptions.InvalidDirectionNameException;
import home.javaphite.explorer.model.exceptions.UnknownObjectIdException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

@ControllerAdvice
public class ExplorerExceptionHandler extends DefaultHandlerExceptionResolver {

    @ExceptionHandler({UnknownObjectIdException.class, InvalidDirectionNameException.class, ArrayIndexOutOfBoundsException.class})
    protected ModelAndView invalidCommandArgsHandler(RuntimeException exception) {
        ModelAndView modelAndView = new ModelAndView("warning");
        modelAndView.addObject("errorMessage", exception.getMessage())
                .addObject("image", "/images/test_image.jpg")
                .addObject("colorSchema", "yellow");
        return modelAndView;
    }

}
