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

/**
 * Represents an entity component.
 */
public abstract class AbstractComponent {

    /**
     * The parent entity.
     */
    private Entity entity;

    /**
     * Create a new entity component.
     */
    public AbstractComponent() {
        // This is empty intentionally.
    }

    /**
     * Update the component.
     */
    public abstract void update();

    /**
     * Get the parent entity.
     *
     * @return The parent entity.
     */
    public Entity getEntity() {
        return entity;
    }

    /**
     * Set the parent entity.
     *
     * @param entity The parent entity.
     */
    public void setEntity(final Entity entity) {
        this.entity = entity;
    }
}
