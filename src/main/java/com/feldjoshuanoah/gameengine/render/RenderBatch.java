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

import com.feldjoshuanoah.gameengine.Application;
import com.feldjoshuanoah.gameengine.entity.Entity;
import com.feldjoshuanoah.gameengine.entity.component.ColorComponent;
import com.feldjoshuanoah.gameengine.entity.component.TextureComponent;
import com.feldjoshuanoah.gameengine.render.Shader.DataType;
import com.feldjoshuanoah.gameengine.render.buffer.IndexBuffer;
import com.feldjoshuanoah.gameengine.render.buffer.VertexBuffer;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a render batch.
 */
public class RenderBatch {

    /**
     * The number of vertices used for a quad.
     */
    private static final int QUAD_VERTICES = 4;

    /**
     * The number of indices used for a quad.
     */
    private static final int QUAD_INDICES = 6;

    /**
     * The base indices for a quad.
     */
    private static final int[] BASE_INDICES = new int[] { 0, 3, 1, 1, 3, 2 };

    /**
     * The texture slots.
     */
    private static final int[] TEXTURE_SLOTS = new int[] { 0, 1, 2, 3, 4, 5, 6, 7 };

    /**
     * The layout of the vertex shader.
     */
    private static final DataType[] LAYOUT = new DataType[] {
            DataType.VEC2, DataType.VEC4, DataType.VEC2, DataType.FLOAT
    };

    /**
     * The batch capacity.
     */
    private final int capacity;

    /**
     * The shader.
     */
    private final Shader shader;

    /**
     * The size of a vertex.
     */
    private final int vertexSize;

    /**
     * The vertices.
     */
    private final float[] vertices;

    /**
     * The entities.
     */
    private final List<Entity> entities;

    /**
     * The textures.
     */
    private final List<Texture> textures;

    /**
     * The vertex array.
     */
    private final VertexArray vertexArray;

    /**
     * The vertex buffer.
     */
    private final VertexBuffer vertexBuffer;

    /**
     * Create a new render batch with the given capacity using the given shader.
     *
     * @param capacity The desired capacity of the batch.
     * @param shader The shader to use.
     */
    public RenderBatch(final int capacity, final Shader shader) {
        this.capacity = capacity;
        this.shader = shader;
        entities = new ArrayList<>();
        textures = new ArrayList<>();
        vertexSize = Arrays.stream(LAYOUT).mapToInt(DataType::getSize).sum();
        vertices = new float[vertexSize * QUAD_VERTICES * capacity];

        vertexArray = new VertexArray();
        vertexArray.bind();

        vertexBuffer = new VertexBuffer(vertices.length, LAYOUT);

        final int[] indices = new int[QUAD_INDICES * capacity];
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < QUAD_INDICES; j++) {
                indices[QUAD_INDICES * i + j] = QUAD_VERTICES * i + BASE_INDICES[j];
            }
        }
        final IndexBuffer indexBuffer = new IndexBuffer(indices);
    }

    /**
     * Render all entities in the batch.
     */
    public void render() {
        vertexBuffer.bind();
        vertexBuffer.setSubData(0, vertices);

        shader.bind();
        final Camera camera = Application.getInstance().getSceneManager().getScene().getCamera();
        shader.uniformMatrix4f("u_Projection", camera.getProjection());
        shader.uniformMatrix4f("u_View", camera.getView());
        for (int i = 0; i < textures.size(); i++) {
            GL30.glActiveTexture(GL13.GL_TEXTURE0 + i + 1);
            textures.get(i).bind();
        }
        shader.uniform1iv("u_Textures", TEXTURE_SLOTS);

        vertexArray.bind();
        vertexBuffer.enableVertexAttribArrays();
        GL30.glDrawElements(GL30.GL_TRIANGLES, capacity * QUAD_INDICES,
                GL30.GL_UNSIGNED_INT, 0);
        vertexBuffer.disableVertexAttribArrays();
        vertexArray.unbind();

        textures.forEach(Texture::unbind);
        shader.unbind();
    }

    /**
     * Add an entity to the batch.
     *
     * @param entity The entity to add.
     */
    public void addEntity(final Entity entity) {
        if (isFull()) {
            throw new IllegalStateException("Render batch has no more capacity.");
        }
        entities.add(entity);

        final Transform transform = entity.getTransform();
        int offset = (entities.size() - 1) * vertexSize * QUAD_VERTICES;
        float x = 1.0f;
        float y = 1.0f;
        for (int i = 0; i < QUAD_VERTICES; i++) {
            switch (i) {
                case 1 -> y = 0.0f;
                case 2 -> x = 0.0f;
                case 3 -> y = 1.0f;
            }
            vertices[offset] = transform.getPosition().x() + x * transform.getScale().x();
            vertices[offset + 1] = transform.getPosition().y() + y * transform.getScale().y();
            final ColorComponent colorComponent = entity.getComponent(ColorComponent.class);
            final Vector4f color = colorComponent == null ? new Vector4f(1.0f, 1.0f, 1.0f, 1.0f)
                    : colorComponent.getColor();
            for (int j = 0; j < 4; j++) {
                vertices[offset + 2 + j] = color.get(j);
            }
            final TextureComponent textureComponent = entity.getComponent(TextureComponent.class);
            int textureId = 0;
            if (textureComponent != null) {
                final Texture texture = textureComponent.getTexture();
                if (!textures.contains(texture)) {
                    textures.add(texture);
                }
                textureId = textures.indexOf(texture) + 1;
            }
            vertices[offset + 6] = TextureComponent.TEXTURE_COORDINATES[i].x();
            vertices[offset + 7] = TextureComponent.TEXTURE_COORDINATES[i].y();
            vertices[offset + 8] = textureId;
            offset += vertexSize;
        }
    }

    /**
     * Determine whether the batch is full or not.
     *
     * @return {@code true} if the batch is full, {@code false} otherwise.
     */
    public boolean isFull() {
        return entities.size() == capacity;
    }
}
