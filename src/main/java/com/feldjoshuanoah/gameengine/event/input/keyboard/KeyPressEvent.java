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

import org.lwjgl.glfw.GLFW;

/**
 * Represents a key event that is fired when a key is pressed.
 */
public final class KeyPressEvent extends KeyEvent {

    /**
     * Create a new key press event.
     *
     * @param key The key that was pressed.
     * @param scanCode The system-specific scancode of the key.
     * @param mods Bit field describing which modifier keys were held down.
     */
    public KeyPressEvent(final int key, final int scanCode, final int mods) {
        super(key, scanCode, GLFW.GLFW_RELEASE, mods);
    }
}
