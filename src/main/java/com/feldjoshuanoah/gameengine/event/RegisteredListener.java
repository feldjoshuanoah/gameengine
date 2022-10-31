package com.feldjoshuanoah.gameengine.event;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

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
        this.handlers = Arrays.stream(listener.getClass().getMethods()).filter(method -> method.isAnnotationPresent(EventHandler.class)).toList();
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
