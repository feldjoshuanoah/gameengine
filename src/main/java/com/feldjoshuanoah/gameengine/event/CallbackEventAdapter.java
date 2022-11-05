/*
 * Copyright 2022 Joshua Feld
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feldjoshuanoah.gameengine.event;

import com.feldjoshuanoah.gameengine.Application;
import com.feldjoshuanoah.gameengine.event.input.keyboard.KeyPressEvent;
import com.feldjoshuanoah.gameengine.event.input.keyboard.KeyReleaseEvent;
import com.feldjoshuanoah.gameengine.event.input.keyboard.KeyRepeatEvent;
import com.feldjoshuanoah.gameengine.event.input.mouse.ButtonPressEvent;
import com.feldjoshuanoah.gameengine.event.input.mouse.ButtonReleaseEvent;
import com.feldjoshuanoah.gameengine.event.input.mouse.CursorEnterEvent;
import com.feldjoshuanoah.gameengine.event.input.mouse.CursorLeaveEvent;
import com.feldjoshuanoah.gameengine.event.input.mouse.CursorMoveEvent;
import com.feldjoshuanoah.gameengine.event.input.mouse.ScrollEvent;
import com.feldjoshuanoah.gameengine.event.window.WindowCloseEvent;
import com.feldjoshuanoah.gameengine.event.window.WindowGainFocusEvent;
import com.feldjoshuanoah.gameengine.event.window.WindowIconifyEvent;
import com.feldjoshuanoah.gameengine.event.window.WindowLoseFocusEvent;
import com.feldjoshuanoah.gameengine.event.window.WindowMaximizeEvent;
import com.feldjoshuanoah.gameengine.event.window.WindowMoveEvent;
import com.feldjoshuanoah.gameengine.event.window.WindowRefreshWindow;
import com.feldjoshuanoah.gameengine.event.window.WindowResizeEvent;
import com.feldjoshuanoah.gameengine.event.window.WindowRestoreEvent;
import org.lwjgl.glfw.GLFW;

/**
 * An adapter to let the event system interact with GLFW.
 */
public final class CallbackEventAdapter {

    /**
     * The application event manager.
     */
    private static final EventManager EVENT_MANAGER = Application.getInstance().getEventManager();

    /**
     * The previous cursor x-coordinate, relative to the left edge of the content area.
     */
    private static double previousX;

    /**
     * The previous cursor y-coordinate, relative to the top edge of the content area.
     */
    private static double previousY;

    /**
     * Since this is a utility class, we do not want any outer classes creating an instance of it.
     */
    private CallbackEventAdapter() {
    }

    /**
     * Will be called when the window is moved.
     *
     * @param window The window that received the event.
     * @param x The new x-coordinate, in screen coordinates, of the upper-left corner of the content
     *          area of the window.
     * @param y The new y-coordinate, in screen coordinates, of the upper-left corner of the content
     *          area of the window.
     */
    public static void windowPositionCallback(final long window, final int x, final int y) {
        EVENT_MANAGER.fire(new WindowMoveEvent(x, y));
    }

    /**
     * Will be called when the window is resized.
     *
     * @param window The window that received the event.
     * @param width The new width, in screen coordinates, of the window.
     * @param height The new height, in screen coordinates, of the window.
     */
    public static void windowSizeCallback(final long window, final int width, final int height) {
        EVENT_MANAGER.fire(new WindowResizeEvent(width, height));
    }

    /**
     * Will be called when the user attempts to close the window, for example by clicking the close
     * widget in the title bar.
     *
     * @param window The window that received the event.
     */
    public static void windowCloseCallback(final long window) {
        EVENT_MANAGER.fire(new WindowCloseEvent());
    }

    /**
     * Will be called when the content area of the window needs to be redrawn, for example if the
     * window has been exposed after having been covered by another window.
     *
     * @param window The window that received the event.
     */
    public static void windowRefreshCallback(final long window) {
        EVENT_MANAGER.fire(new WindowRefreshWindow());
    }

    /**
     * Will be called when the window gains or loses input focus.
     *
     * @param window The window that received the event.
     * @param focus {@code true} if the window was given input focus, or {@code false} if it's lost.
     */
    public static void windowFocusCallback(final long window, final boolean focus) {
        EVENT_MANAGER.fire(focus ? new WindowGainFocusEvent() : new WindowLoseFocusEvent());
    }

    /**
     * Will be called when the window is iconified or restored.
     *
     * @param window The window that received the event.
     * @param iconified {@code true} if the window was iconified, or {@code false} if it was
     *                  restored.
     */
    public static void windowIconifyCallback(final long window, final boolean iconified) {
        EVENT_MANAGER.fire(iconified ? new WindowIconifyEvent() : new WindowRestoreEvent());
    }

    /**
     * Will be called when the window is maximized or restored.
     *
     * @param window The window that received the event.
     * @param maximized {@code true} if the window was maximized, or {@code false} if it was
     *                  restored.
     */
    public static void windowMaximizeCallback(final long window, final boolean maximized) {
        EVENT_MANAGER.fire(maximized ? new WindowMaximizeEvent() : new WindowRestoreEvent());
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
            case GLFW.GLFW_PRESS -> EVENT_MANAGER.fire(new KeyPressEvent(key, scanCode, mods));
            case GLFW.GLFW_RELEASE -> EVENT_MANAGER.fire(new KeyReleaseEvent(key, scanCode, mods));
            case GLFW.GLFW_REPEAT -> EVENT_MANAGER.fire(new KeyRepeatEvent(key, scanCode, mods));
        }
    }

    /**
     * Will be called when the cursor is moved.
     *
     * @param window The window that received the event.
     * @param x The new cursor x-coordinate, relative to the left edge of the content area.
     * @param y The new cursor y-coordinate, relative to the top edge of the content area.
     */
    public static void cursorPositionCallback(final long window, final double x, final double y) {
        EVENT_MANAGER.fire(new CursorMoveEvent(x, y, previousX, previousY));
        previousX = x;
        previousY = y;
    }

    /**
     * Will be called when the cursor enters or leaves the client area of the window.
     *
     * @param window The window that received the event.
     * @param entered {@code true} if the cursor entered the window's content area, or {@code false}
     *                if it left it.
     */
    public static void cursorEnterCallback(final long window, final boolean entered) {
        EVENT_MANAGER.fire(entered ? new CursorEnterEvent() : new CursorLeaveEvent());
    }

    /**
     * Will be called when a button is pressed or released.
     *
     * @param window The window that received the event.
     * @param button The mouse button that was pressed or released.
     * @param action The button action.
     * @param mods Bit field describing which modifier keys were held down.
     */
    public static void mouseButtonCallback(final long window, final int button, final int action,
            final int mods) {
        switch (action) {
            case GLFW.GLFW_RELEASE -> EVENT_MANAGER.fire(new ButtonReleaseEvent(button, mods));
            case GLFW.GLFW_PRESS -> EVENT_MANAGER.fire(new ButtonPressEvent(button, mods));
        }
    }

    /**
     * Will be called when a scrolling device is used, such as a mouse wheel or scrolling area of a
     * touchpad.
     *
     * @param window The window that received the event.
     * @param xOffset The scroll offset along the x-axis.
     * @param yOffset The scroll offset along the y-axis.
     */
    public static void scrollCallback(final long window, final double xOffset,
            final double yOffset) {
        EVENT_MANAGER.fire(new ScrollEvent(xOffset, yOffset));
    }
}
