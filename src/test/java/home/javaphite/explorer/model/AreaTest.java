package home.javaphite.explorer.model;

import home.javaphite.explorer.utils.TestLifecycleLogger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Area class")
public class AreaTest extends TestLifecycleLogger {

    @Test
    @Tag("constructor")
    void areaInitializationSuccess() {
        Area area = new Area(2,2);

        Assertions.assertNotNull(area.getCurrentLocation());
        area.move("south");
        Assertions.assertNotNull(area.getCurrentLocation());
    }
}
