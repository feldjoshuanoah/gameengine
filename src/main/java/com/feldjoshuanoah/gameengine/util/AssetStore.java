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
package com.feldjoshuanoah.gameengine.util;

import com.feldjoshuanoah.gameengine.render.Shader;
import com.feldjoshuanoah.gameengine.render.sprite.Texture;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents an asset store.
 */
public final class AssetStore {

    /**
     * The shaders.
     */
    private static final Map<String, Shader> SHADERS = new HashMap<>();

    /**
     * The textures.
     */
    private static final Map<String, Texture> TEXTURES = new HashMap<>();

    /**
     * Not accessible.
     */
    private AssetStore() {
        // This is empty intentionally.
    }

    /**
     * Get the shader to which the specified name is mapped. If the shader does not exist in the
     * asset store, it is first created and then added to the store.
     *
     * @param name The name of the shader.
     * @return The shader to which the specified name is mapped.
     */
    public static Shader getShader(final String name) {
        if (SHADERS.containsKey(name)) {
            return SHADERS.get(name);
        }
        final Shader shader = new Shader(ResourceUtils.getContent(name + "_v.glsl"),
                ResourceUtils.getContent(name + "_f.glsl"));
        SHADERS.put(name, shader);
        return shader;
    }

    /**
     * Get the texture to which the specified name is mapped. If the texture does not exist in the
     * asset store, it is first created and then added to the store.
     *
     * @param name The name of the texture.
     * @return The texture to which the specified name is mapped.
     */
    public static Texture getTexture(final String name) {
        if (TEXTURES.containsKey(name)) {
            return TEXTURES.get(name);
        }
        final Texture texture = new Texture(ResourceUtils.getAbsolutePath(name + ".png"));
        TEXTURES.put(name, texture);
        return texture;
    }
}
