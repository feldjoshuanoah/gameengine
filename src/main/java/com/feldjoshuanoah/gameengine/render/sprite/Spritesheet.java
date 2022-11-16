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

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a spritesheet.
 */
public class Spritesheet {

    /**
     * The sprites on the spritesheet.
     */
    private final List<Sprite> sprites;

    /**
     * Create a new spritesheet.
     *
     * @param texture The texture.
     * @param width The width of an individual sprite.
     * @param height The height of an individual sprite.
     * @param count The number of sprites on the spritesheet.
     * @param spacing The spacing between each sprite on the spritesheet.
     */
    public Spritesheet(final Texture texture, final int width, final int height, final int count,
                       final int spacing) {
        sprites = new ArrayList<>();

        int x = 0;
        int y = texture.getHeight() - height;
        for (int i = 0; i < count; i++) {
            final float leftX = x / (float) texture.getWidth();
            final float rightX = (x + width) / (float) texture.getWidth();
            final float bottomY = y / (float) texture.getHeight();
            final float topY = (y + height) / (float) texture.getHeight();
            sprites.add(new Sprite(texture, new Vector2f[] {
                    new Vector2f(rightX, topY),
                    new Vector2f(rightX, bottomY),
                    new Vector2f(leftX, bottomY),
                    new Vector2f(leftX, topY)
            }));
            x += width + spacing;
            if (x >= texture.getWidth()) {
                x = 0;
                y -= height + spacing;
            }
        }
    }

    /**
     * Get the sprite at the specified position on the spritesheet.
     *
     * @param index The of the sprite to return.
     * @return The sprite at the specified position on the spritesheet.
     */
    public Sprite getSprite(final int index) {
        return sprites.get(index);
    }
}
