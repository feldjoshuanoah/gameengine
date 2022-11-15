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
import com.feldjoshuanoah.gameengine.render.Texture;
import org.joml.Vector2f;

/**
 * Represents a texture component.
 */
public class TextureComponent extends AbstractComponent {

    /**
     * The texture coordinates of a quad.
     */
    public static final Vector2f[] TEXTURE_COORDINATES = new Vector2f[] {
            new Vector2f(1.0f, 1.0f),
            new Vector2f(1.0f, 0.0f),
            new Vector2f(0.0f, 0.0f),
            new Vector2f(0.0f, 1.0f)
    };

    /**
     * The texture.
     */
    private final Texture texture;

    /**
     * Create a new texture component.
     *
     * @param texture The texture.
     */
    public TextureComponent(final Texture texture) {
        this.texture = texture;
    }

    @Override
    public void update() {
        // This is empty intentionally.
    }

    /**
     * Get the texture.
     *
     * @return The texture.
     */
    public Texture getTexture() {
        return texture;
    }
}
