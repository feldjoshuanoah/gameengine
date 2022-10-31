package com.feldjoshuanoah.gameengine.event.input.keyboard;

import org.lwjgl.glfw.GLFW;

/**
 * Represents a key event that is fired when a key is released.
 */
public class KeyReleaseEvent extends KeyEvent {

    /**
     * Create a new key release event.
     *
     * @param key The key that was released.
     */
    public KeyReleaseEvent(final int key) {
        super(key, GLFW.GLFW_RELEASE);
    }
}
