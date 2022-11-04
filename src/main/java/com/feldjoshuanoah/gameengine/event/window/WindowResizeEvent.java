package com.feldjoshuanoah.gameengine.event.window;

import com.feldjoshuanoah.gameengine.event.Event;

/**
 * Represents a window resize event that is fired when the window is resized.
 */
public final class WindowResizeEvent implements Event {

    private final int width;

    private final int height;

    public WindowResizeEvent(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
