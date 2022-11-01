package com.feldjoshuanoah.gameengine.util.input;

import com.feldjoshuanoah.gameengine.event.EventManager;
import com.feldjoshuanoah.gameengine.event.input.mouse.*;
import org.lwjgl.glfw.GLFW;

/**
 * Contains callback methods for mouse input.
 */
public final class MouseCallback {

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
    private MouseCallback() {
    }

    /**
     * Will be called when the cursor is moved.
     *
     * @param window The window that received the event.
     * @param x The new cursor x-coordinate, relative to the left edge of the content area.
     * @param y The new cursor y-coordinate, relative to the top edge of the content area.
     */
    public static void cursorPositionCallback(final long window, final double x, final double y) {
        EventManager.getInstance().fire(new CursorMoveEvent(x, y, previousX, previousY));
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
        EventManager.getInstance().fire(entered ? new CursorEnterEvent() : new CursorLeaveEvent());
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
        final EventManager eventManager = EventManager.getInstance();
        switch (action) {
            case GLFW.GLFW_RELEASE -> eventManager.fire(new ButtonReleaseEvent(button));
            case GLFW.GLFW_PRESS -> eventManager.fire(new ButtonPressEvent(button));
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
        EventManager.getInstance().fire(new ScrollEvent(xOffset, yOffset));
    }
}
