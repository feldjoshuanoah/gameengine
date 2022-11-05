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
package com.feldjoshuanoah.gameengine;

import com.feldjoshuanoah.gameengine.event.EventManager;
import com.feldjoshuanoah.gameengine.render.Window;
import com.feldjoshuanoah.gameengine.render.scene.SceneManager;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

/**
 * Represents an application.
 */
public class Application {

    /**
     * The default width for newly created windows.
     */
    private static final int DEFAULT_WIDTH = 1280;

    /**
     * The default height for newly created windows.
     */
    private static final int DEFAULT_HEIGHT = 720;

    /**
     * The window.
     */
    private final Window window;

    /**
     * The event manager.
     */
    private final EventManager eventManager;

    /**
     * The scene manager.
     */
    private final SceneManager sceneManager;

    /**
     * Create a new application.
     */
    public Application() {
        GLFWErrorCallback.createPrint(System.err).set();
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        window = new Window(DEFAULT_WIDTH, DEFAULT_HEIGHT, "Game Engine", MemoryUtil.NULL);
        eventManager = new EventManager();
        sceneManager = new SceneManager();
    }

    /**
     * Terminate the application.
     */
    public void terminate() {
        window.destroy();
        GLFW.glfwTerminate();
        GLFW.glfwSetErrorCallback(null).free();
    }

    /**
     * Some GLFW getting started boilerplate code.
     */
    public void loop() {
        float lastFrameTime = 0.0f;

        while (!window.shouldClose()) {
            final float time = (float) GLFW.glfwGetTime();
            final float timeStep = time - lastFrameTime;
            lastFrameTime = time;

            GLFW.glfwPollEvents();
            sceneManager.getScene().update(timeStep);

            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
            sceneManager.getScene().render();
            window.swapBuffers();
        }
    }

    /**
     * Get the window.
     *
     * @return The window.
     */
    public Window getWindow() {
        return window;
    }

    /**
     * Get the event manager.
     *
     * @return The event manager.
     */
    public EventManager getEventManager() {
        return eventManager;
    }

    /**
     * Get the scene manager.
     *
     * @return The scene manager.
     */
    public SceneManager getSceneManager() {
        return sceneManager;
    }

    /**
     * Get the application instance.
     *
     * @return The application instance.
     */
    public static Application getInstance() {
        return SingletonHelper.INSTANCE;
    }

    /**
     * A helper class to make the application a singleton.
     */
    private static final class SingletonHelper {

        /**
         * The application instance.
         */
        private static final Application INSTANCE = new Application();

        /**
         * Since this is a singleton helper this should be instantiated.
         */
        private SingletonHelper() {
        }
    }
}
