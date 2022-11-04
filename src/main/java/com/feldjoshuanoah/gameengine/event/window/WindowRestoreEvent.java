package com.feldjoshuanoah.gameengine.event.window;

/**
 * Represents a window restore event that is fired when the window is restored.
 */
public final class WindowRestoreEvent extends WindowStatusEvent {

    /**
     * Create a new window restore event.
     */
    public WindowRestoreEvent() {
        super(WindowStatus.RESTORE);
    }
}
