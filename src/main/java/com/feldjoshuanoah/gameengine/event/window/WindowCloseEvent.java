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
 * Represents a window close event that is fired when the user attempts to close the window, for
 * example by clicking the close widget in the title bar.
 */
public final class WindowCloseEvent implements Event {

    /**
     * Create a new window close event.
     */
    public WindowCloseEvent() {
        // This is empty intentionally.
    }
}
