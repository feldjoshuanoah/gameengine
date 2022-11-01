package com.feldjoshuanoah.gameengine.event.input.keyboard;

import org.lwjgl.glfw.GLFW;

/**
 * Represents a key event that is fired when a key is pressed.
 */
public final class KeyPressEvent extends KeyEvent {

    /**
     * Create a new key press event.
     *
     * @param key The key that was pressed.
     */
    public KeyPressEvent(final int key) {
        super(key, GLFW.GLFW_RELEASE);
    }
}
