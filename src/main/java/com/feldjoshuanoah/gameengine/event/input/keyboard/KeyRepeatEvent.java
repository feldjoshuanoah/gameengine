package com.feldjoshuanoah.gameengine.event.input.keyboard;

import org.lwjgl.glfw.GLFW;

/**
 * Represents a key event that is fired when a key is repeated.
 */
public class KeyRepeatEvent extends KeyEvent {

    /**
     * Create a new key repeat event.
     *
     * @param key The key that was repeated.
     */
    public KeyRepeatEvent(final int key) {
        super(key, GLFW.GLFW_REPEAT);
    }
}
