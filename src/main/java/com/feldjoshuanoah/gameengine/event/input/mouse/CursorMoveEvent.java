package com.feldjoshuanoah.gameengine.event.input.mouse;

import com.feldjoshuanoah.gameengine.event.Event;

/**
 * Represents a cursor move event that is fired when the cursor is moved.
 */
public final class CursorMoveEvent implements Event {

    /**
     * The new cursor x-coordinate, relative to the left edge of the content area.
     */
    private final double x;

    /**
     * The new cursor y-coordinate, relative to the top edge of the content area.
     */
    private final double y;

    /**
     * The previous cursor x-coordinate, relative to the left edge of the content area.
     */
    private final double previousX;

    /**
     * The previous cursor y-coordinate, relative to the top edge of the content area.
     */
    private final double previousY;

    /**
     * Create a new cursor move event.
     *
     * @param x The new cursor x-coordinate.
     * @param y The new cursor y-coordinate.
     * @param previousX The previous cursor x-coordinate.
     * @param previousY The previous cursor y-coordinate.
     */
    public CursorMoveEvent(final double x, final double y,
                           final double previousX, final double previousY) {
        this.x = x;
        this.y = y;
        this.previousX = previousX;
        this.previousY = previousY;
    }

    /**
     * Get the new cursor x-coordinate, relative to the left edge of the content area.
     *
     * @return The new cursor x-coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * Get the new cursor y-coordinate, relative to the top edge of the content area.
     *
     * @return The new cursor y-coordinate.
     */
    public double getY() {
        return y;
    }

    /**
     * Get the previous cursor x-coordinate, relative to the left edge of the content area.
     *
     * @return The previous cursor x-coordinate.
     */
    public double getPreviousX() {
        return previousX;
    }

    /**
     * Get the previous cursor y-coordinate, relative to the top edge of the content area.
     *
     * @return The previous cursor y-coordinate.
     */
    public double getPreviousY() {
        return previousY;
    }
}
