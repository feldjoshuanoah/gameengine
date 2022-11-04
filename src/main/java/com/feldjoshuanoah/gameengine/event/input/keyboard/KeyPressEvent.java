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
     * @param scanCode The system-specific scancode of the key.
     * @param mods Bit field describing which modifier keys were held down.
     */
    public KeyPressEvent(final int key, final int scanCode, final int mods) {
        super(key, scanCode, GLFW.GLFW_RELEASE, mods);
    }
}
