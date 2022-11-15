/*
 * Copyright 2022 Joshua Feld
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feldjoshuanoah.gameengine.util;

import java.io.IOException;
import java.lang.StackWalker.Option;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provides utility methods for handling resource files.
 */
public final class ResourceUtils {

    /**
     * The logger for the resource utilities.
     */
    private static final Logger LOGGER = Logger.getLogger(ResourceUtils.class.getName());

    /**
     * Not accessible.
     */
    private ResourceUtils() {
        // This is empty intentionally.
    }

    /**
     * Get the absolute path of a resource.
     *
     * @param name The resource name.
     * @return The absolute path of the resource.
     */
    public static String getAbsolutePath(final String name) {
        return Paths.get(Objects.requireNonNull(getResource(name))).toFile().getAbsolutePath();
    }

    /**
     * Get the content of a resource.
     *
     * @param name The resource name.
     * @return The absolute path of the resource.
     */
    public static String getResourceContent(final String name) {
        try {
            return Files.readString(Path.of(Objects.requireNonNull(getResource(name))));
        } catch (final IOException exception) {
            if (LOGGER.isLoggable(Level.SEVERE)) {
                LOGGER.log(Level.SEVERE, "Unable to read resource " + name, exception);
            }
        }
        return null;
    }

    /**
     * Find the resource with the given name.
     *
     * @param name The resource name.
     * @return The resource.
     */
    public static URI getResource(final String name) {
        try {
            return Objects.requireNonNull(ResourceUtils.class.getClassLoader().getResource(name))
                    .toURI();
        } catch (final URISyntaxException exception) {
            if (LOGGER.isLoggable(Level.SEVERE)) {
                LOGGER.log(Level.SEVERE, "Unable to load resource " + name, exception);
            }
        }
        return null;
    }
}
