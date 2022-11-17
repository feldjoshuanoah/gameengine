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
package com.feldjoshuanoah.gameengine.entity.component;

import com.feldjoshuanoah.gameengine.entity.AbstractComponent;
import org.joml.Vector4f;

/**
 * Represents a sprite component.
 */
public class ColorComponent extends AbstractComponent {

    /**
     * The color.
     */
    private Vector4f color;

    /**
     * Create a new sprite component.
     *
     * @param color The color.
     */
    public ColorComponent(final Vector4f color) {
        super();
        this.color = color;
    }

    @Override
    public void update() {
        // This is empty intentionally.
    }

    /**
     * Get the color.
     *
     * @return The color.
     */
    public Vector4f getColor() {
        return color;
    }

    /**
     * Set the color.
     *
     * @param color The color.
     */
    public void setColor(final Vector4f color) {
        if (!this.color.equals(color)) {
            this.color = color;
            getEntity().setDirty(true);
        }
    }
}
