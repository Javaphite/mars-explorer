package home.javaphite.explorer.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Location {
    public Map<Integer, PlaceOfInterest> pois = new HashMap<>();
    private Relief relief;

    enum Relief {
        ROCKS("rocks");

        static final String DESCRIPTION_TEMPLATES_PATH = "/descriptions/relief_descriptions.json";
        static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("[{]}");

        private final String descriptionTemplate;

        Relief(String descrTemplateId) {
            ObjectMapper mapper = new ObjectMapper();
            try (InputStream inStream = getClass().getResourceAsStream(DESCRIPTION_TEMPLATES_PATH)) {
                JsonNode node = mapper.readTree(inStream).get(descrTemplateId);
                descriptionTemplate = node.get("description_template").asText();
            } catch (IOException treeReadingError) {
                throw new UncheckedIOException(treeReadingError);
            }
        }
    }

    // Generates random location
   public Location() {
        // Grab random relief
        Random randomGenerator = new Random();
        int bound = Relief.values().length;
        relief = Relief.values()[randomGenerator.nextInt(bound)];

        // Grab random place of interest for each placeholder in relief description
        Matcher matcher = Relief.PLACEHOLDER_PATTERN.matcher(relief.descriptionTemplate);
        while (matcher.find()) {
            int ordinalBound = Item.values().length;
            int randomOrdinal = randomGenerator.nextInt(ordinalBound);
            Item randomItem = Item.values()[randomOrdinal];
            PlaceOfInterest poi = new PlaceOfInterest(randomItem);
            pois.put(poi.getId(), poi);
        }
    }

    @Override
    public String toString() {
        String result = relief.descriptionTemplate;
        for (PlaceOfInterest poi: pois.values()) {
            Matcher matcher = Relief.PLACEHOLDER_PATTERN.matcher(result);
            result = matcher.replaceFirst(poi.toString());
        }
        return result;
    }

    public String getPoisStatuses() {
        StringBuilder statuses = new StringBuilder(140);
        for (PlaceOfInterest poi: pois.values()) {
            statuses.append(poi)
                    .append(": ")
                    .append(poi.getStatus())
                    .append(System.lineSeparator());
        }
        return statuses.toString();
    }
}



