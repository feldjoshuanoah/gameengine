package com.feldjoshuanoah.gameengine.event.input.mouse;

import org.lwjgl.glfw.GLFW;

/**
 * Represents a button event that is fired when a button is pressed.
 */
public final class ButtonPressEvent extends ButtonEvent {

    /**
     * Create a new button press event.
     *
     * @param button The button that was pressed.
     * @param mods Bit field describing which modifier keys were held down.
     */
    public ButtonPressEvent(final int button, final int mods) {
        super(button, GLFW.GLFW_PRESS, mods);
    }
}
