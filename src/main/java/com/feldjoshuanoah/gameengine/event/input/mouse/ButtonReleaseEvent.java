package com.feldjoshuanoah.gameengine.event.input.mouse;

import org.lwjgl.glfw.GLFW;

/**
 * Represents a button event that is fired when a button is released.
 */
public final class ButtonReleaseEvent extends ButtonEvent {

    /**
     * Create a new button release event.
     *
     * @param button The button that was released.
     * @param mods Bit field describing which modifier keys were held down.
     */
    public ButtonReleaseEvent(final int button, final int mods) {
        super(button, GLFW.GLFW_RELEASE, mods);
    }
}
