package com.feldjoshuanoah.gameengine.event.input.mouse;

import org.lwjgl.glfw.GLFW;

/**
 * Represents a button event that is fired when a button is released.
 */
public class ButtonReleaseEvent extends ButtonEvent {

    /**
     * Create a new button release event.
     *
     * @param button The button that was released.
     */
    public ButtonReleaseEvent(final int button) {
        super(button, GLFW.GLFW_RELEASE);
    }
}
