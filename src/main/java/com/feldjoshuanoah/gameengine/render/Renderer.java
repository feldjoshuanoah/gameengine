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
import com.feldjoshuanoah.gameengine.entity.component.SpriteComponent;

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
        batches.stream().filter(renderBatch -> {
            final SpriteComponent spriteComponent = entity.getComponent(SpriteComponent.class);
            boolean textureCapacity = true;
            if (spriteComponent != null) {
                textureCapacity = !renderBatch.isTextureStoreFull() || renderBatch.containsTexture(
                        spriteComponent.getSprite().getTexture());
            }
            return !renderBatch.isFull() && textureCapacity && entity.getZ() == renderBatch.getZ();
        }).findFirst().ifPresentOrElse(
                renderBatch -> renderBatch.addEntity(entity),
                () -> {
                    final RenderBatch renderBatch = new RenderBatch(BATCH_CAPACITY, shader,
                            entity.getZ());
                    batches.add(renderBatch);
                    renderBatch.addEntity(entity);
                }
        );
    }

    /**
     * Render all render batches.
     */
    public void render() {
        batches.stream().sorted().forEach(RenderBatch::render);
    }
}
