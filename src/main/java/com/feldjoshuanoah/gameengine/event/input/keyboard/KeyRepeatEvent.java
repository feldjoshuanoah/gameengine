package com.feldjoshuanoah.gameengine.event.input.keyboard;

import org.lwjgl.glfw.GLFW;

/**
 * Represents a key event that is fired when a key is repeated.
 */
public final class KeyRepeatEvent extends KeyEvent {

    /**
     * Create a new key repeat event.
     *
     * @param key The key that was repeated.
     * @param scanCode The system-specific scancode of the key.
     * @param mods Bit field describing which modifier keys were held down.
     */
    public KeyRepeatEvent(final int key, final int scanCode, final int mods) {
        super(key, scanCode, GLFW.GLFW_REPEAT, mods);
    }
}
