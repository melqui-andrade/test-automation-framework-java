package com.melqui.portfolio.ui.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

public final class TestDataLoader {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private TestDataLoader() {
    }

    public static <T> T load(String resourcePath, Class<T> type) {
        try (InputStream inputStream = TestDataLoader.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Resource not found: " + resourcePath);
            }
            return OBJECT_MAPPER.readValue(inputStream, type);
        } catch (IOException exception) {
            throw new UncheckedIOException("Unable to load test data from " + resourcePath, exception);
        }
    }
}
