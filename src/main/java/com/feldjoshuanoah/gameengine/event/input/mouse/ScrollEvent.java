package com.feldjoshuanoah.gameengine.event.input.mouse;

import com.feldjoshuanoah.gameengine.event.Event;

/**
 * Represents a scroll event that is fired when a scrolling device is used, such as a mouse wheel or scrolling area of a touchpad.
 */
public class ScrollEvent implements Event {

    /**
     * The scroll offset along the x-axis.
     */
    private final double xOffset;
    /**
     * The scroll offset along the y-axis.
     */
    private final double yOffset;

    /**
     * Create a new scroll event.
     *
     * @param xOffset The scroll offset along the x-axis.
     * @param yOffset The scroll offset along the y-axis.
     */
    public ScrollEvent(final double xOffset, final double yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    /**
     * Get the scroll offset along the x-axis.
     *
     * @return The scroll offset along the x-axis.
     */
    public double getXOffset() {
        return xOffset;
    }

    /**
     * Get the scroll offset along the y-axis.
     *
     * @return The scroll offset along the y-axis.
     */
    public double getYOffset() {
        return yOffset;
    }
}
