package home.javaphite.explorer.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Location {

    private static final Logger LOG = LoggerFactory.getLogger(Location.class);

    private Relief relief;

    public Map<Integer, PlaceOfInterest> placesOfInterest;

    public Location(Relief relief, Map<Integer, PlaceOfInterest> placesOfInterest) {
        this.relief = relief;
        this.placesOfInterest = new HashMap<>(placesOfInterest);
    }

    static Location randomized() {
        Random random = new Random();

        // Grab random relief
        Relief[] reliefs = Relief.values();
        int nReliefs = reliefs.length;
        Relief relief = reliefs[random.nextInt(nReliefs)];

        // Grab random place of interest for each placeholder in relief description
        Map<Integer, PlaceOfInterest> pois = new HashMap<>();
        Matcher matcher = Relief.PLACEHOLDER_PATTERN.matcher(relief.description);
        while (matcher.find()) {
            Item[] items = Item.values();
            int nItems = items.length;
            int randomItemOrdinal = random.nextInt(nItems);
            Item randomItem = items[randomItemOrdinal];
            PlaceOfInterest poi = new PlaceOfInterest(randomItem);

            pois.put(poi.getId(), poi);
        }

        Location randomizedLocation = new Location(relief, pois);
        LOG.debug("Created randomized Location - {}", randomizedLocation.relief);

        return randomizedLocation;
    }

    public String details() {
        StringBuilder details = new StringBuilder(140);

        for (PlaceOfInterest poi: placesOfInterest.values()) {
            details.append(poi)
                    .append(": ")
                    .append(poi.getStatus())
                    .append(System.lineSeparator());
        }

        return details.toString();
    }

    @Override
    public String toString() {
        String result = relief.description;

        for (PlaceOfInterest poi: placesOfInterest.values()) {
            Matcher matcher = Relief.PLACEHOLDER_PATTERN.matcher(result);
            result = matcher.replaceFirst(poi.toString());
        }

        return result;
    }

    private enum Relief {

        ROCKS("rocks");

        static final String DESCRIPTION_TEMPLATES_PATH = "/public/descriptions/relief_descriptions.json";
        static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("[{]}");

        private final String description;

        Relief(String descriptionId) {
            ObjectMapper mapper = new ObjectMapper();

            try (InputStream inStream = getClass().getResourceAsStream(DESCRIPTION_TEMPLATES_PATH)) {
                JsonNode node = mapper.readTree(inStream).get(descriptionId);
                description = node.get("description_template").asText();
            }
            catch (IOException treeReadingError) {
                LOG.error("Relief descriptions JSON parsing error: ", treeReadingError);
                throw new UncheckedIOException(treeReadingError);
            }

            LOG.debug("Relief variant successfully initialized: {}", descriptionId);
        }
    }
}




