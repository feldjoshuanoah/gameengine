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
 * Represents an index buffer.
 */
public class IndexBuffer extends AbstractBuffer {

    /**
     * Create a new index buffer.
     *
     * @param indices The indices to be stored in the buffer.
     */
    public IndexBuffer(final int[] indices) {
        super(GL30.glGenBuffers());
        GL30.glBindBuffer(GL30.GL_ELEMENT_ARRAY_BUFFER, id);
        GL30.glBufferData(GL30.GL_ELEMENT_ARRAY_BUFFER, indices, GL30.GL_STATIC_DRAW);
    }

    @Override
    public void bind() {
        GL30.glBindBuffer(GL30.GL_ELEMENT_ARRAY_BUFFER, id);
    }

    @Override
    public void unbind() {
        GL30.glBindBuffer(GL30.GL_ELEMENT_ARRAY_BUFFER, 0);
    }
}
