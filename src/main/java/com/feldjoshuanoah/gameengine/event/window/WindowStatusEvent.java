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
 * Represents a window status event that is fired when the window status changes.
 */
public abstract class WindowStatusEvent implements Event {

    /**
     * Represents a window status.
     */
    public enum WindowStatus {

        ICONIFY, MAXIMIZE, RESTORE
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
