package com.feldjoshuanoah.gameengine.event.window;

/**
 * Represents a window maximize event that is fired when the window is maximized.
 */
public final class WindowMaximizeEvent extends WindowStatusEvent {

    /**
     * Create a new window maximize event.
     */
    public WindowMaximizeEvent() {
        super(WindowStatus.MAXIMIZE);
    }
}
