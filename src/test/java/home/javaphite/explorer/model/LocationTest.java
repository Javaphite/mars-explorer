package home.javaphite.explorer.model;

import home.javaphite.explorer.utils.TestLifecycleLogger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Location class")
public class LocationTest extends TestLifecycleLogger {

    @RepeatedTest(10)
    @Tag("method")
    @Tag("toString")
    void toStringTest() {
        Location loc = Location.randomized();
        System.out.println(loc);
    }

}
