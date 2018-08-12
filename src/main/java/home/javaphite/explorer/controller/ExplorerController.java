package home.javaphite.explorer.controller;

import home.javaphite.explorer.model.Area;
import home.javaphite.explorer.model.Location;
import home.javaphite.explorer.model.PlaceOfInterest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
@EnableAutoConfiguration
public class ExplorerController {
    @Autowired
    private Area area;

    @GetMapping("/")
    public String redirectToExplorerLocation() {
        return "redirect:/explorer/location/";
    }

    @GetMapping("/explorer/location*")
    public ModelAndView getLocation() {
        ModelAndView modelAndView = new ModelAndView("location");
        Location currentLocation = area.getCurrentLocation();
        modelAndView.addObject("currentLocation", currentLocation.toString())
                    .addObject("currentLocationPoisStatuses", convertLineSeparatorsToHtml(currentLocation.getPoisStatuses()));
        return modelAndView;
    }

    @GetMapping("/explorer/location/move")
    public String moveToNextLocation(String direction) {
        area.move(direction);
        return "redirect:/explorer/location/";
    }

    @GetMapping("/explorer/location/scan")
    public String scanPlaceOfIneterestById(int id) {
        Location currentLocation = area.getCurrentLocation();
        PlaceOfInterest poi = currentLocation.pois.get(id);
        poi.setScanned(true);
        return "redirect:/explorer/location/";
    }

    @GetMapping("/final")
    public ModelAndView finalView() {
        return new ModelAndView("final");
    }

    private String convertLineSeparatorsToHtml(String text) {
        return text.replaceAll(System.lineSeparator(), "<br>");
    }
}
