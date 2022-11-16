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

import com.feldjoshuanoah.gameengine.entity.Entity;
import com.feldjoshuanoah.gameengine.entity.component.TextureComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a renderer.
 */
public class Renderer {

    /**
     * The batch capacity to use for all render batches.
     */
    private static final int BATCH_CAPACITY = 1000;

    /**
     * The shader.
     */
    private final Shader shader;

    /**
     * The render batches.
     */
    private final List<RenderBatch> batches;

    /**
     * Create a new renderer which uses the given shader.
     *
     * @param shader The shader to use.
     */
    public Renderer(final Shader shader) {
        this.shader = shader;
        this.batches = new ArrayList<>();
    }

    /**
     * Add an entity.
     *
     * @param entity The entity to render.
     */
    public void add(Entity entity) {
        batches.stream().filter(batch -> {
            final TextureComponent textureComponent = entity.getComponent(TextureComponent.class);
            boolean textureCapacity = true;
            if (textureComponent != null) {
                textureCapacity = !batch.isTextureStoreFull() || batch.containsTexture(textureComponent.getTexture());
            }
            return !batch.isFull() && textureCapacity;
        }).findFirst().ifPresentOrElse(
                batch -> batch.addEntity(entity),
                () -> {
                    final RenderBatch renderBatch = new RenderBatch(BATCH_CAPACITY, shader);
                    batches.add(renderBatch);
                    renderBatch.addEntity(entity);
                }
        );
    }

    /**
     * Render all render batches.
     */
    public void render() {
        batches.forEach(RenderBatch::render);
    }
}
