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
package com.feldjoshuanoah.gameengine.event.window;

import com.feldjoshuanoah.gameengine.event.Event;

/**
 * Represents a window move event that is fired when the window is moved.
 */
public final class WindowMoveEvent implements Event {

    /**
     * The new x-coordinate, in screen coordinates, of the upper-left corner of the content area of
     * the window.
     */
    private final int x;

    /**
     * The new y-coordinate, in screen coordinates, of the upper-left corner of the content area of
     * the window.
     */
    private final int y;

    /**
     * Create a new window move event.
     *
     * @param x The new x-coordinate, in screen coordinates.
     * @param y The new y-coordinate, in screen coordinates.
     */
    public WindowMoveEvent(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the new x-coordinate, in screen coordinates, of the upper-left corner of the content area
     * of the window.
     *
     * @return The new x-coordinate, in screen coordinates.
     */
    public int getX() {
        return x;
    }

    /**
     * Get the new y-coordinate, in screen coordinates, of the upper-left corner of the content area
     * of the window.
     *
     * @return The new y-coordinate, in screen coordinates.
     */
    public int getY() {
        return y;
    }
}
