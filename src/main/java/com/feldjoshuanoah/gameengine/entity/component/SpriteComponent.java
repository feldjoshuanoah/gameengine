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
import com.feldjoshuanoah.gameengine.render.sprite.Sprite;

/**
 * Represents a sprite component.
 */
public class SpriteComponent extends AbstractComponent {

    /**
     * The texture.
     */
    private final Sprite sprite;

    /**
     * Create a new sprite component.
     *
     * @param sprite The texture.
     */
    public SpriteComponent(final Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public void update() {
        // This is empty intentionally.
    }

    /**
     * Get the sprite.
     *
     * @return The sprite.
     */
    public Sprite getSprite() {
        return sprite;
    }
}
