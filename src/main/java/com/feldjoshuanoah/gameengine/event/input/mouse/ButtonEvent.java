package com.feldjoshuanoah.gameengine.event.input.mouse;

import com.feldjoshuanoah.gameengine.event.Event;

/**
 * Represents a button event that is fired when a button is pressed or released.
 */
public abstract class ButtonEvent implements Event {

    /**
     * The mouse button that was pressed or released.
     */
    private final int button;
    /**
     * The button action.
     */
    private final int action;

    /**
     * Create a new button event.
     *
     * @param button The mouse button that was pressed or released.
     * @param action The button action.
     */
    public ButtonEvent(final int button, final int action) {
        this.button = button;
        this.action = action;
    }

    /**
     * Get the mouse button that was pressed or released.
     *
     * @return The mouse button that was pressed or released.
     */
    public int getButton() {
        return button;
    }

    /**
     * Get the button action.
     *
     * @return The button action.
     */
    public int getAction() {
        return action;
    }
}
