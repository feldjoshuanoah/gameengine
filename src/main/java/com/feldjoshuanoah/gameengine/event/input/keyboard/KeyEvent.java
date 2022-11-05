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
package com.feldjoshuanoah.gameengine.event.input.keyboard;

import com.feldjoshuanoah.gameengine.event.Event;

/**
 * Represents a key event that is fired when a key is pressed, held, or released.
 */
public abstract class KeyEvent implements Event {

    /**
     * The keyboard key that was pressed or released.
     */
    private final int key;

    /**
     * The system-specific scancode of the key.
     */
    private final int scanCode;

    /**
     * The key action.
     */
    private final int action;

    /**
     * Bit field describing which modifier keys were held down.
     */
    private final int mods;

    /**
     * Create a new keyboard key event.
     *
     * @param key The keyboard key that was pressed or released.
     * @param scanCode The system-specific scancode of the key.
     * @param action The key action.
     * @param mods Bit field describing which modifier keys were held down.
     */
    public KeyEvent(final int key, final int scanCode, final int action, final int mods) {
        this.key = key;
        this.scanCode = scanCode;
        this.action = action;
        this.mods = mods;
    }

    /**
     * Get the keyboard key that was pressed or released.
     *
     * @return The keyboard key that was pressed or released.
     */
    public int getKey() {
        return key;
    }

    /**
     * Get the system-specific scancode of the key.
     *
     * @return The system-specific scancode of the key.
     */
    public int getScanCode() {
        return scanCode;
    }

    /**
     * Get the key action.
     *
     * @return The key action.
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
