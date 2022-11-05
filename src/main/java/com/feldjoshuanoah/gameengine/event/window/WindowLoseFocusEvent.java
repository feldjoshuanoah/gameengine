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
 * Represents a window lose focus event that is fired when the window loses focus.
 */
public final class WindowLoseFocusEvent implements Event {

    /**
     * Create a new window lose focus event.
     */
    public WindowLoseFocusEvent() {
        // This is empty intentionally.
    }
}
