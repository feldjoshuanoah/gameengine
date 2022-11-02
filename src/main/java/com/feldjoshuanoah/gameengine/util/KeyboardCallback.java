package com.feldjoshuanoah.gameengine.util;

import com.feldjoshuanoah.gameengine.Application;
import com.feldjoshuanoah.gameengine.event.EventManager;
import com.feldjoshuanoah.gameengine.event.input.keyboard.KeyPressEvent;
import com.feldjoshuanoah.gameengine.event.input.keyboard.KeyReleaseEvent;
import com.feldjoshuanoah.gameengine.event.input.keyboard.KeyRepeatEvent;
import org.lwjgl.glfw.GLFW;

/**
 * Contains callback methods for keyboard input.
 */
public final class KeyboardCallback {

    /**
     * The application event manager.
     */
    private static final EventManager EVENT_MANAGER = Application.getInstance().getEventManager();

    /**
     * Since this is a utility class, we do not want any outer classes creating an instance of it.
     */
    private KeyboardCallback() {
    }

    /**
     * Will be called when a key is pressed, repeated or released.
     *
     * @param window The window that received the event.
     * @param key The keyboard key that was pressed or released.
     * @param scanCode The system-specific scancode of the key.
     * @param action The key action.
     * @param mods Bit field describing which modifier keys were held down.
     */
    public static void keyCallback(final long window, final int key, final int scanCode,
                                   final int action, final int mods) {
        switch (action) {
            case GLFW.GLFW_PRESS -> EVENT_MANAGER.fire(new KeyPressEvent(key));
            case GLFW.GLFW_RELEASE -> EVENT_MANAGER.fire(new KeyReleaseEvent(key));
            case GLFW.GLFW_REPEAT -> EVENT_MANAGER.fire(new KeyRepeatEvent(key));
        }
    }
}
