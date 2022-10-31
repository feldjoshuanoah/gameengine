package com.feldjoshuanoah.gameengine.event.input.mouse;

import org.lwjgl.glfw.GLFW;

/**
 * Represents a button event that is fired when a button is pressed.
 */
public class ButtonPressEvent extends ButtonEvent {

    /**
     * Create a new button press event.
     *
     * @param button The button that was pressed.
     */
    public ButtonPressEvent(final int button) {
        super(button, GLFW.GLFW_PRESS);
    }
}
