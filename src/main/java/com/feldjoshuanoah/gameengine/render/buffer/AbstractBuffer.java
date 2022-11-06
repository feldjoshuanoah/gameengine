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
package com.feldjoshuanoah.gameengine.render.buffer;

import org.lwjgl.opengl.GL30;

/**
 * Represents a buffer.
 */
public abstract class AbstractBuffer {

    /**
     * The buffer id.
     */
    protected final int id;

    /**
     * Create a new buffer.
     *
     * @param id The buffer id.
     */
    public AbstractBuffer(final int id) {
        this.id = id;
    }

    /**
     * Bind the buffer.
     */
    public abstract void bind();

    /**
     * Unbind the buffer.
     */
    public abstract void unbind();

    /**
     * Delete the buffer.
     */
    public void delete() {
        GL30.glDeleteBuffers(id);
    }
}
