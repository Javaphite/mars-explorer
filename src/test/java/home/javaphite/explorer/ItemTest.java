package home.javaphite.explorer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class ItemTest {
    @ParameterizedTest
    @EnumSource(Item.class)
    void initializationWasSuccessful(Item poi) {
        Assertions.assertNotNull(poi.getName());
        Assertions.assertNotNull(poi.getType());
        Assertions.assertNotNull(poi.getDescription());
    }
}
