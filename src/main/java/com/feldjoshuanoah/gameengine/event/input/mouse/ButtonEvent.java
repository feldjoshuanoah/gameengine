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
 * Represents a button event that is fired when a button is pressed or released.
 */
public class ButtonEvent implements Event {

    /**
     * The mouse button that was pressed or released.
     */
    private final int button;

    /**
     * The button action.
     */
    private final int action;

    /**
     * Bit field describing which modifier keys were held down.
     */
    private final int mods;

    /**
     * Create a new button event.
     *
     * @param button The mouse button that was pressed or released.
     * @param action The button action.
     * @param mods Bit field describing which modifier keys were held down.
     */
    public ButtonEvent(final int button, final int action, final int mods) {
        this.button = button;
        this.action = action;
        this.mods = mods;
    }

    /**
     * Get the mouse button that was pressed or released.
     *
     * @return The mouse button that was pressed or released.
     */
    public int getButton() {
        return button;
    }

    /**
     * Get the button action.
     *
     * @return The button action.
     */
    public int getAction() {
        return action;
    }

    /**
     * Get the bit field describing which modifier keys were held down.
     *
     * @return Bit field describing which modifier keys were held down.
     */
    public int getMods() {
        return mods;
    }
}
