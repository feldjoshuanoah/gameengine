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

/**
 * A manager that handles the scenes.
 */
public final class SceneManager {

    /**
     * The active scene.
     */
    private Scene scene;

    /**
     * Create a new scene manager.
     */
    public SceneManager() {
        // This is empty intentionally.
    }

    /**
     * Get the active scene.
     *
     * @return The active scene.
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Set the active scene.
     *
     * @param scene The active scene.
     */
    public void setScene(final Scene scene) {
        if (this.scene != null) {
            this.scene.destroy();
        }
        scene.create();
        this.scene = scene;
    }
}
