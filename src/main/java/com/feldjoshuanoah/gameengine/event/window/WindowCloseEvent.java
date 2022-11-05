package com.feldjoshuanoah.gameengine.event.window;

import com.feldjoshuanoah.gameengine.event.Event;

/**
 * Represents a window close event that is fired when the user attempts to close the window, for
 * example by clicking the close widget in the title bar.
 */
public final class WindowCloseEvent implements Event {

    /**
     * Create a new window close event.
     */
    public WindowCloseEvent() {
    }
}
