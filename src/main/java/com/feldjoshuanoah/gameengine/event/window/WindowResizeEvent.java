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
 * Represents a window resize event that is fired when the window is resized.
 */
public final class WindowResizeEvent implements Event {

    /**
     * The new width, in screen coordinates, of the window.
     */
    private final int width;

    /**
     * The new height, in screen coordinates, of the window.
     */
    private final int height;

    /**
     * Create a new window resize event.
     *
     * @param width The new width, in screen coordinates, of the window.
     * @param height The new height, in screen coordinates, of the window.
     */
    public WindowResizeEvent(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Get the new width, in screen coordinates, of the window.
     *
     * @return The new width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Get the new height, in screen coordinates, of the window.
     *
     * @return The new height.
     */
    public int getHeight() {
        return height;
    }
}
