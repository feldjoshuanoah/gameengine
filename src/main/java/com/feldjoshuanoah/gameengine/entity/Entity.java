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
package com.feldjoshuanoah.gameengine.entity;

import com.feldjoshuanoah.gameengine.render.Transform;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an entity.
 */
public class Entity {

    /**
     * The components.
     */
    private final List<AbstractComponent> components;

    /**
     * The transform.
     */
    private Transform transform;

    /**
     * The z-index.
     */
    private final int z;

    /**
     * Dirty flag for rendering.
     */
    private boolean dirty;

    /**
     * Create a new entity.
     *
     * @param transform The transform.
     * @param z The z-index.
     */
    public Entity(final Transform transform, final int z) {
        this.transform = transform;
        components = new ArrayList<>();
        this.dirty = true;
        this.z = z;
    }

    /**
     * Update the components.
     */
    public void update() {
        components.forEach(AbstractComponent::update);
    }

    /**
     * Get a component by its class.
     *
     * @param componentClass The class of the desired component.
     * @return The component.
     * @param <T> The component type.
     */
    public <T extends AbstractComponent> T getComponent(final Class<T> componentClass) {
        return components.stream().filter(component -> componentClass.isAssignableFrom(component
                .getClass())).findFirst().map(componentClass::cast).orElse(null);
    }

    /**
     * Add a component.
     *
     * @param component The component to add.
     */
    public void addComponent(final AbstractComponent component) {
        components.add(component);
        component.setEntity(this);
    }

    /**
     * Remove a component by its class.
     *
     * @param componentClass The class of the component to remove.
     * @param <T> The component type.
     */
    public <T extends AbstractComponent> void removeComponent(final Class<T> componentClass) {
        components.stream().filter(component -> componentClass.isAssignableFrom(component
                .getClass())).findFirst().ifPresent(components::remove);
    }

    /**
     * Get the transform.
     *
     * @return The transform.
     */
    public Transform getTransform() {
        return transform;
    }

    /**
     * Set the transform.
     *
     * @param transform The transform.
     */
    public void setTransform(final Transform transform) {
        if (!this.transform.equals(transform)) {
            this.transform = transform;
            dirty = true;
        }
    }

    /**
     * Get the z-index.
     *
     * @return The z-index.
     */
    public int getZ() {
        return z;
    }

    /**
     * Return {@code true} if the dirty flag for rendering is active.
     *
     * @return {@code true} if the dirty flag for rendering is active.
     */
    public boolean isDirty() {
        return dirty;
    }

    /**
     * Set the dirty flag for rendering.
     *
     * @param dirty The dirty flag for rendering.
     */
    public void setDirty(final boolean dirty) {
        this.dirty = dirty;
    }
}
