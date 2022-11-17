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
package com.feldjoshuanoah.gameengine.render.sprite;

import org.joml.Vector2f;

/**
 * Represents a sprite.
 */
public class Sprite {

    /**
     * The texture.
     */
    private final Texture texture;
    /**
     * The texture coordinates.
     */
    private final Vector2f[] textureCoordinates;

    /**
     * Create a new sprite with the given texture.
     *
     * @param texture The texture.
     */
    public Sprite(final Texture texture) {
        this.texture = texture;
        textureCoordinates = new Vector2f[] {
                new Vector2f(1.0f, 1.0f),
                new Vector2f(1.0f, 0.0f),
                new Vector2f(0.0f, 0.0f),
                new Vector2f(0.0f, 1.0f)
        };
    }

    /**
     * Create a new sprite with the given texture and texture coordinates.
     *
     * @param texture The texture.
     * @param textureCoordinates The texture coordinates.
     */
    public Sprite(final Texture texture, final Vector2f[] textureCoordinates) {
        this.texture = texture;
        this.textureCoordinates = textureCoordinates.clone();
    }

    /**
     * Get the texture.
     *
     * @return The texture.
     */
    public Texture getTexture() {
        return texture;
    }

    /**
     * Get the texture coordinates.
     *
     * @return The texture coordinates.
     */
    public Vector2f[] getTextureCoordinates() {
        return textureCoordinates.clone();
    }
}
