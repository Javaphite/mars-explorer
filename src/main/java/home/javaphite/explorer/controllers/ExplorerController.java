package home.javaphite.explorer.controllers;

import home.javaphite.explorer.model.Area;
import home.javaphite.explorer.model.Location;
import home.javaphite.explorer.model.PlaceOfInterest;
import home.javaphite.explorer.model.exceptions.UnknownObjectIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Objects;

@Controller
@EnableWebMvc
public class ExplorerController {

    static final String CURRENT_LOCATION = "/explorer/location";
    static final String SCAN_COMMAND = "/explorer/location/scan";
    static final String MOVE_COMMAND = "/explorer/location/move";

    @Autowired
    private Area area;

    @GetMapping("/")
    public String fallbackForRoot() {
        return redirectTo(CURRENT_LOCATION);
    }

    @GetMapping(CURRENT_LOCATION)
    public ModelAndView getLocation() {
        ModelAndView modelAndView = new ModelAndView("location");
        Location currentLocation = area.getCurrentLocation();
        modelAndView.addObject("currentLocation", currentLocation.toString())
                    .addObject("details", convertLineSeparatorsToHtml(currentLocation.details()))
                    .addObject("image", "/images/test_image.jpg")
                    .addObject("colorSchema", "green");
        return modelAndView;
    }

    @GetMapping(MOVE_COMMAND)
    public String moveToNextLocation(String direction) {
        area.move(direction);
        return redirectTo(CURRENT_LOCATION);
    }

    @GetMapping(SCAN_COMMAND)
    public String scanPlaceOfIneterestById(int id) {
        Location currentLocation = area.getCurrentLocation();
        PlaceOfInterest poi = currentLocation.placesOfInterest.get(id);
        if (Objects.nonNull(poi)) {
            poi.setScanned(true);
        } else {
            throw new UnknownObjectIdException("No objects with such ID found! Scanning command aborted. Awaiting new one...");
        }
        return redirectTo(CURRENT_LOCATION);
    }

    private static String redirectTo(String page) {
        return "redirect:" + page;
    }

    private String convertLineSeparatorsToHtml(String text) {
        return text.replaceAll(System.lineSeparator(), "<br>");
    }
}
