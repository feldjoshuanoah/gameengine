package com.feldjoshuanoah.gameengine.event.input.keyboard;

import org.lwjgl.glfw.GLFW;

/**
 * Represents a key event that is fired when a key is released.
 */
public final class KeyReleaseEvent extends KeyEvent {

    /**
     * Create a new key release event.
     *
     * @param key The key that was released.
     * @param scanCode The system-specific scancode of the key.
     * @param mods Bit field describing which modifier keys were held down.
     */
    public KeyReleaseEvent(final int key, final int scanCode, final int mods) {
        super(key, scanCode, GLFW.GLFW_RELEASE, mods);
    }
}
