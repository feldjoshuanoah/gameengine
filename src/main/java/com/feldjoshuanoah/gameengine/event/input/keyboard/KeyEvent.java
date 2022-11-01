package com.feldjoshuanoah.gameengine.event.input.keyboard;

import com.feldjoshuanoah.gameengine.event.Event;

/**
 * Represents a key event that is fired when a key is pressed, held, or released.
 */
public abstract class KeyEvent implements Event {

    /**
     * The keyboard key that was pressed or released.
     */
    private final int key;

    /**
     * The key action.
     */
    private final int action;

    /**
     * Create a new keyboard key event.
     *
     * @param key The keyboard key that was pressed or released.
     * @param action The key action.
     */
    public KeyEvent(final int key, final int action) {
        this.key = key;
        this.action = action;
    }

    /**
     * Get the keyboard key that was pressed or released.
     *
     * @return The keyboard key that was pressed or released.
     */
    public int getKey() {
        return key;
    }

    /**
     * Get the key action.
     *
     * @return The key action.
     */
    public int getAction() {
        return action;
    }
}
