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

import com.feldjoshuanoah.gameengine.render.Shader;
import org.lwjgl.opengl.GL30;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Represents a vertex buffer.
 */
public class VertexBuffer extends AbstractBuffer {

    /**
     * The amount of elements in the buffer layout.
     */
    private final int elements;

    /**
     * Create a new static vertex buffer.
     *
     * @param vertices The vertices to be stored in the buffer.
     * @param layout The buffer layout.
     */
    public VertexBuffer(final float[] vertices, final Shader.DataType[] layout) {
        super(GL30.glGenBuffers());
        GL30.glBindBuffer(GL30.GL_ARRAY_BUFFER, id);
        GL30.glBufferData(GL30.GL_ARRAY_BUFFER, vertices, GL30.GL_STATIC_DRAW);
        elements = layout.length;
        final int stride = Arrays.stream(layout).mapToInt(Shader.DataType::getByteSize).sum();
        for (int i = 0; i < elements; i++) {
            GL30.glEnableVertexAttribArray(i);
            GL30.glVertexAttribPointer(i, layout[i].getSize(), layout[i].getType(), false, stride,
                    IntStream.range(0, i).map(j -> layout[j].getByteSize()).sum());
        }
    }

    /**
     * Create a new dynamic vertex buffer.
     *
     * @param layout The buffer layout.
     */
    public VertexBuffer(final int size, final Shader.DataType[] layout) {
        super(GL30.glGenBuffers());
        GL30.glBindBuffer(GL30.GL_ARRAY_BUFFER, id);
        GL30.glBufferData(GL30.GL_ARRAY_BUFFER, (long) size * Float.BYTES, GL30.GL_DYNAMIC_DRAW);
        elements = layout.length;
        final int stride = Arrays.stream(layout).mapToInt(Shader.DataType::getByteSize).sum();
        for (int i = 0; i < elements; i++) {
            GL30.glEnableVertexAttribArray(i);
            GL30.glVertexAttribPointer(i, layout[i].getSize(), layout[i].getType(), false, stride,
                    IntStream.range(0, i).map(j -> layout[j].getByteSize()).sum());
        }
    }

    @Override
    public void bind() {
        GL30.glBindBuffer(GL30.GL_ARRAY_BUFFER, id);
    }

    @Override
    public void unbind() {
        GL30.glBindBuffer(GL30.GL_ARRAY_BUFFER, 0);
    }

    /**
     * Updates a subset of the data store of this vertex buffer.
     *
     * @param offset The offset into the vertex buffer's data store where data replacement will
     *               begin, measured in bytes.
     * @param vertices The new vertices that will be copied into the data store.
     */
    public void setSubData(final int offset, final float[] vertices) {
        GL30.glBufferSubData(GL30.GL_ARRAY_BUFFER, offset, vertices);
    }

    /**
     * Enable all vertex attribute arrays.
     */
    public void enableVertexAttribArrays() {
        for (int i = 0; i < elements; i++) {
            GL30.glEnableVertexAttribArray(i);
        }
    }

    /**
     * Disable all vertex attribute arrays.
     */
    public void disableVertexAttribArrays() {
        for (int i = 0; i < elements; i++) {
            GL30.glDisableVertexAttribArray(i);
        }
    }
}
