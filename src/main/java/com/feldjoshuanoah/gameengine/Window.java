package com.feldjoshuanoah.gameengine;

import com.feldjoshuanoah.gameengine.util.input.KeyboardCallback;
import com.feldjoshuanoah.gameengine.util.input.MouseCallback;

import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.MemoryUtil;

/**
 * Represents a window.
 */
public class Window {

    /**
     * The window handle.
     */
    private final long handle;

    /**
     * Create a new window.
     *
     * @param width The desired width, in screen coordinates, of the window.
     * @param height The desired height, in screen coordinates, of the window.
     * @param title The initial, UTF-8 encoded window title.
     * @param monitor The monitor to use for full screen mode.
     */
    public Window(final int width, final int height, final String title, final long monitor) {
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);

        handle = GLFW.glfwCreateWindow(width, height, title, monitor, MemoryUtil.NULL);
        if (handle == MemoryUtil.NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        }
        GLFW.glfwMakeContextCurrent(handle);

        GLFW.glfwSetKeyCallback(handle, KeyboardCallback::keyCallback);
        GLFW.glfwSetCursorPosCallback(handle, MouseCallback::cursorPositionCallback);
        GLFW.glfwSetCursorEnterCallback(handle, MouseCallback::cursorEnterCallback);
        GLFW.glfwSetMouseButtonCallback(handle, MouseCallback::mouseButtonCallback);
        GLFW.glfwSetScrollCallback(handle, MouseCallback::scrollCallback);
    }

    /**
     * Make the window visible if it was previously hidden.
     */
    public void show() {
        GLFW.glfwShowWindow(handle);
    }

    /**
     * Destroy the window and its context.
     */
    public void destroy() {
        Callbacks.glfwFreeCallbacks(handle);
        GLFW.glfwDestroyWindow(handle);
    }

    /**
     * Enable or disable v-sync.
     *
     * @param vSync Whether v-sync should be enabled or not.
     */
    public void vSync(final boolean vSync) {
        GLFW.glfwSwapInterval(vSync ? 1 : 0);
    }

    /**
     * Swaps the front and back buffers of the window.
     */
    public void swapBuffers() {
        GLFW.glfwSwapBuffers(handle);
    }

    /**
     * Get the value of the close flag of the window.
     *
     * @return The value of the close flag.
     */
    public boolean shouldClose() {
        return GLFW.glfwWindowShouldClose(handle);
    }

    /**
     * Get the window handle.
     *
     * @return The window handle.
     */
    public long getHandle() {
        return handle;
    }
}
