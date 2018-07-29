package home.javaphite.explorer.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AreaTest {
    @Test
    void areaInitializationSuccess() {
        Area area = new Area(2,1);
        Assertions.assertNotNull(area.getCurrentLocation());
        area.move("south");
        Assertions.assertNotNull(area.getCurrentLocation());
    }

}
