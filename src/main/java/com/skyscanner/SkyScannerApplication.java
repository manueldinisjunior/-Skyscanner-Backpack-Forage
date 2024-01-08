package com.skyscanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SkyScannerApplication extends Application<SkyScannerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new SkyScannerApplication().run(args);
    }

    @Override
    public String getName() {
        return "hoen-scanner";
    }

    @Override
    public void initialize(final Bootstrap<SkyScannerConfiguration> bootstrap) {

    }

    @Override
    public void run(final SkyScannerConfiguration configuration, final Environment environment) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<SearchResult> searchResults = new ArrayList<>();

        // Add all the SearchResult objects from json files
        searchResults.addAll(readSearch(mapper, "rental_cars.json"));
        searchResults.addAll(readSearch(mapper, "hotels.json"));

        final SearchResource resource = new SearchResource(searchResults);
        environment.jersey().register(resource);
    }

    private List<SearchResult> readSearch(ObjectMapper mapper, String fileName) throws IOException {
        return Arrays.asList(
                mapper.readValue(
                        getClass().getClassLoader().getResource(fileName),
                        SearchResult[].class)
        );
    }

}
