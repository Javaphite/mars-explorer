package home.javaphite.explorer.model;

import home.javaphite.explorer.utils.TestLifecycleLogger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@DisplayName("Item class")
class ItemTest extends TestLifecycleLogger {

    @ParameterizedTest
    @EnumSource(Item.class)
    @Tag("initialization")
    void allFieldsWereInitialized(Item item) {
        Assertions.assertNotNull(item.getName());
        Assertions.assertNotNull(item.getType());
        Assertions.assertNotNull(item.getDescription());
    }

    @Test
    @Tag("method")
    @Tag("Type.mapType")
    void haveMappingPolicyForAllItemTypes() {
        String[] testTypeTags = {"A", "B", "C", "W", "O", "M", "random text"};

        Set<Item.Type> typesMappedFromTags = Arrays.stream(testTypeTags)
                                    .map(Item.Type::mapType)
                                    .distinct()
                                    .collect(Collectors.toSet());

        for (Item.Type type: Item.Type.values()) {
            Assertions.assertTrue(typesMappedFromTags.contains(type));
        }
    }
}
