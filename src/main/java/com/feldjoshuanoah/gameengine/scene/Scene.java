package com.feldjoshuanoah.gameengine.scene;

/**
 * Represents a scene.
 */
public interface Scene {

    /**
     * Update the scene.
     */
    void update();

    /**
     * Render the scene.
     */
    void render();

    /**
     * Create the scene.
     */
    void create();

    /**
     * Destroy the scene.
     */
    void destroy();
}
