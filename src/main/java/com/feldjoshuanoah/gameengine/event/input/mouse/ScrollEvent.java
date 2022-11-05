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
package com.feldjoshuanoah.gameengine.event.input.mouse;

import com.feldjoshuanoah.gameengine.event.Event;

/**
 * Represents a scroll event that is fired when a scrolling device is used, such as a mouse wheel or
 * scrolling area of a touchpad.
 */
public final class ScrollEvent implements Event {

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
