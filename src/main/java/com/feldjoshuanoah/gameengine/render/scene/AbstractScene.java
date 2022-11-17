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
package com.feldjoshuanoah.gameengine.render.scene;

import com.feldjoshuanoah.gameengine.entity.Entity;
import com.feldjoshuanoah.gameengine.render.Camera;
import com.feldjoshuanoah.gameengine.render.Renderer;
import com.feldjoshuanoah.gameengine.render.Shader;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a scene.
 */
public abstract class AbstractScene {

    /**
     * The camera.
     */
    private final Camera camera;

    /**
     * The entities.
     */
    private final List<Entity> entities;

    /**
     * The renderer.
     */
    private final Renderer renderer;

    /**
     * Create a new scene.
     *
     * @param camera The camera.
     * @param shader The shader.
     */
    public AbstractScene(final Camera camera, final Shader shader) {
        this.camera = camera;
        entities = new ArrayList<>();
        renderer = new Renderer(shader);
    }

    /**
     * Update the scene.
     */
    public abstract void update();

    /**
     * Create the scene.
     */
    public abstract void create();

    /**
     * Destroy the scene.
     */
    public abstract void destroy();

    /**
     * Render the scene.
     */
    public void render() {
        renderer.render();
    }

    /**
     * Update the entities.
     */
    public void updateEntities() {
        entities.forEach(Entity::update);
    }

    /**
     * Get the camera.
     *
     * @return The camera.
     */
    public Camera getCamera() {
        return camera;
    }

    /**
     * Add an entity to the scene.
     *
     * @param entity The entity to add.
     */
    public void addEntity(final Entity entity) {
        entities.add(entity);
        renderer.add(entity);
    }

    /**
     * Remove an entity from the scene.
     *
     * @param entity The entity to remove.
     */
    public void removeEntity(final Entity entity) {
        entities.remove(entity);
    }
}
