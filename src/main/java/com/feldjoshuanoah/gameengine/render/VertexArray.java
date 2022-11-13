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
package com.feldjoshuanoah.gameengine.render;

import org.lwjgl.opengl.GL30;

/**
 * Represents a vertex array.
 */
public class VertexArray {

    /**
     * The vertex array id.
     */
    private final int id;

    /**
     * Create a new vertex array.
     */
    public VertexArray() {
        id = GL30.glGenVertexArrays();
    }

    /**
     * Bind the vertex array.
     */
    public void bind() {
        GL30.glBindVertexArray(id);
    }

    /**
     * Unbind the vertex array.
     */
    public void unbind() {
        GL30.glBindVertexArray(0);
    }

    /**
     * Delete the vertex array.
     */
    public void delete() {
        GL30.glDeleteVertexArrays(id);
    }
}