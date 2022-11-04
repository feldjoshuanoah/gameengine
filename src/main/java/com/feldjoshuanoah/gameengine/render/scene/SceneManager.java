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
