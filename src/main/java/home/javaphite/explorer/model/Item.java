package home.javaphite.explorer.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

enum Item {
    STONE("stone"),
    STRANGE_STONE("strange_stone");

    static final String DESCRIPTIONS_FILE = "/item_descriptions.json";

    enum Type {
        WATER_PRESENCE_PROOF,
        ORGANIC_PRESENCE_PROOF,
        ALIEN_TECHNOLOGY,
        MISCELLANEOUS
    }

    private String name;
    private Type type;
    private String description;

    Item(String descriptionId) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode fields;
        try (InputStream inStream = String.class.getResourceAsStream(DESCRIPTIONS_FILE)) {
            fields = mapper.readTree(inStream).findValue(descriptionId);
        }
        catch (IOException treeReadingError) {
            throw new UncheckedIOException(treeReadingError);
        }
        name = fields.get("name").asText();
        type = mapType(fields.get("type").asText());
        description = fields.get("description").asText();
    }

    private Type mapType(String typeTag) {
        switch (typeTag) {
            case "W": return Type.WATER_PRESENCE_PROOF;
            case "O": return Type.ORGANIC_PRESENCE_PROOF;
            case "A": return Type.ALIEN_TECHNOLOGY;
            default: return Type.MISCELLANEOUS;
        }
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
