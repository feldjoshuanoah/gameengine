package com.feldjoshuanoah.gameengine;

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
     * Create a new application with the given title.
     *
     * @param title The initial, UTF-8 encoded window title.
     */
    public Application(final String title) {
        this(1920, 1080, title, GLFW.glfwGetPrimaryMonitor());
    }

    /**
     * Create a new application with the given dimensions and title.
     *
     * @param width The desired width, in screen coordinates, of the window.
     * @param height The desired height, in screen coordinates, of the window.
     * @param title The initial, UTF-8 encoded window title.
     */
    public Application(final int width, final int height, final String title) {
        this(width, height, title, MemoryUtil.NULL);
    }

    /**
     * Create a new application with the given dimensions, title, and monitor.
     *
     * @param width The desired width, in screen coordinates, of the window.
     * @param height The desired height, in screen coordinates, of the window.
     * @param title The initial, UTF-8 encoded window title.
     * @param monitor The monitor to use for full screen mode.
     */
    public Application(final int width, final int height, final String title, final long monitor) {
        GLFWErrorCallback.createPrint(System.err).set();
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        window = new Window(width, height, title, monitor);
        window.show();
        window.vSync(true);
    }

    /**
     * Terminate the application.
     */
    public void terminate() {
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
}
