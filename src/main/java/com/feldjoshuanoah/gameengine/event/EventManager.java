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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * A manager that handles the events and listeners.
 */
public final class EventManager {

    /**
     * The registered listeners.
     */
    private final List<RegisteredListener> listeners;

    /**
     * Create a new event manager.
     */
    public EventManager() {
        listeners = new ArrayList<>();
    }

    /**
     * Fire an event.
     *
     * @param event The event to fire.
     */
    public void fire(final Event event) {
        listeners.forEach(listener -> listener.getHandlers().stream().filter(handler -> handler.getParameterTypes()[0].isAssignableFrom(event.getClass())).forEach(handler -> {
            try {
                handler.invoke(listener.getListener(), event);
            } catch (final IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }));
    }

    /**
     * Register a listener with its handlers.
     *
     * @param listener The listener to register.
     */
    public void register(final Listener listener) {
        listeners.add(new RegisteredListener(listener));
    }
}
