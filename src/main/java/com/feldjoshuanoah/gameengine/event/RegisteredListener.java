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
package com.feldjoshuanoah.gameengine.event;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a registered listener.
 */
public class RegisteredListener {

    /**
     * The listener.
     */
    private final Listener listener;

    /**
     * The handlers of the listener.
     */
    private final List<Method> handlers;

    /**
     * Create a new registered listener.
     *
     * @param listener The listener.
     */
    public RegisteredListener(final Listener listener) {
        this.listener = listener;
        this.handlers = Arrays.stream(listener.getClass().getMethods())
                .filter(method -> method.isAnnotationPresent(EventHandler.class)).toList();
    }

    /**
     * Get the listener.
     *
     * @return The listener.
     */
    public Listener getListener() {
        return listener;
    }

    /**
     * Get the list of handler methods of the listener.
     *
     * @return The list of handler methods.
     */
    public List<Method> getHandlers() {
        return handlers;
    }
}
