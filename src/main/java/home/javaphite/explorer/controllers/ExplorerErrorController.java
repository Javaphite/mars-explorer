package home.javaphite.explorer.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
@EnableWebMvc
public class ExplorerErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(ERROR_PATH)
    public ModelAndView httpErrorsHandler(HttpServletRequest request) {
        Integer requestStatusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        ModelAndView modelAndView = new ModelAndView("custom_error");
        modelAndView.addObject("errorMessage", getHttpStatusPhrase(requestStatusCode))
                    .addObject("errorTitle", getHttpStatusBasedTitle(requestStatusCode))
                    .addObject("image", "/images/test_image.jpg")
                    .addObject("colorSchema", "red");

        return modelAndView;
    }

    private static String getHttpStatusPhrase(Integer statusCode) {
        HttpStatus status = HttpStatus.resolve(statusCode);
        return status.value() + " " + status.getReasonPhrase();
    }

    private static String getHttpStatusBasedTitle(Integer statusCode) {
        String title;

        switch (statusCode/100) {
            case 4:
                title = "Houston, we've got a problem!";
                break;
            case 5:
                title = "Houston, you've got a problem!";
                break;
            default: title ="Nothing to see here...";
        }

        return title;
    }
}
