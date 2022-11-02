package com.feldjoshuanoah.gameengine;

import com.feldjoshuanoah.gameengine.event.EventManager;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

/**
 * Represents an application.
 */
public class Application {

    /**
     * The window.
     */
    private final Window window;

    /**
     * The event manager.
     */
    private final EventManager eventManager;

    /**
     * Create a new application.
     */
    public Application() {
        GLFWErrorCallback.createPrint(System.err).set();
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        window = new Window(640, 480, "Game Engine", MemoryUtil.NULL);
        eventManager = new EventManager();
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
        GL.createCapabilities();
        while (!window.shouldClose()) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
            window.swapBuffers();
            GLFW.glfwPollEvents();
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
    private static class SingletonHelper {

        /**
         * The application instance.
         */
        private static final Application INSTANCE = new Application();
    }
}
