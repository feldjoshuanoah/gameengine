package com.feldjoshuanoah.gameengine.event.window;

/**
 * Represents a window iconify event that is fired when the window is iconified.
 */
public final class WindowIconifyEvent extends WindowStatusEvent {

    /**
     * Create a new window iconify event.
     */
    public WindowIconifyEvent() {
        super(WindowStatus.ICONIFY);
    }
}
