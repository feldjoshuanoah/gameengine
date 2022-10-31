package com.feldjoshuanoah.gameengine.event;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * A manager that handles the events and listeners.
 */
public class EventManager {

    /**
     * The registered listeners.
     */
    private final List<RegisteredListener> listeners;

    /**
     * Create a new event manager.
     */
    private EventManager() {
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

    /**
     * Get the event manager instance.
     *
     * @return The event manager instance.
     */
    public static EventManager getInstance() {
        return SingletonHelper.INSTANCE;
    }

    /**
     * A helper class to make the event manager a singleton.
     */
    private class SingletonHelper {

        /**
         * The event manager instance.
         */
        private static final EventManager INSTANCE = new EventManager();
    }
}
