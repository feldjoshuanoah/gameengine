package com.feldjoshuanoah.gameengine.event.window;

import com.feldjoshuanoah.gameengine.event.Event;

/**
 * Represents a window status event that is fired when the window status changes.
 */
public abstract class WindowStatusEvent implements Event {

    /**
     * Represents a window status.
     */
    public enum WindowStatus {

        ICONIFY, RESTORE, MAXIMIZE
    }

    /**
     * The new status of the window.
     */
    private final WindowStatus status;

    /**
     * Create a new window status event.
     *
     * @param status The new status of the window.
     */
    public WindowStatusEvent(final WindowStatus status) {
        this.status = status;
    }

    /**
     * Get the new status of the window.
     *
     * @return The new status of the window.
     */
    public WindowStatus getStatus() {
        return status;
    }
}
