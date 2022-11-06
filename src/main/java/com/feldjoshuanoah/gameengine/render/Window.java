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
package com.feldjoshuanoah.gameengine.render;

import com.feldjoshuanoah.gameengine.event.CallbackEventAdapter;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
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
            throw new IllegalStateException("Failed to create the GLFW window");
        }
        GLFW.glfwMakeContextCurrent(handle);

        GLFW.glfwSetWindowPosCallback(handle, CallbackEventAdapter::windowPositionCallback);
        GLFW.glfwSetWindowSizeCallback(handle, CallbackEventAdapter::windowSizeCallback);
        GLFW.glfwSetWindowCloseCallback(handle, CallbackEventAdapter::windowCloseCallback);
        GLFW.glfwSetWindowRefreshCallback(handle, CallbackEventAdapter::windowRefreshCallback);
        GLFW.glfwSetWindowFocusCallback(handle, CallbackEventAdapter::windowFocusCallback);
        GLFW.glfwSetWindowIconifyCallback(handle, CallbackEventAdapter::windowIconifyCallback);
        GLFW.glfwSetWindowMaximizeCallback(handle, CallbackEventAdapter::windowMaximizeCallback);

        GLFW.glfwSetKeyCallback(handle, CallbackEventAdapter::keyCallback);

        GLFW.glfwSetCursorPosCallback(handle, CallbackEventAdapter::cursorPositionCallback);
        GLFW.glfwSetCursorEnterCallback(handle, CallbackEventAdapter::cursorEnterCallback);
        GLFW.glfwSetMouseButtonCallback(handle, CallbackEventAdapter::mouseButtonCallback);
        GLFW.glfwSetScrollCallback(handle, CallbackEventAdapter::scrollCallback);

        GL.createCapabilities();
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
    public void setVSync(final boolean vSync) {
        GLFW.glfwSwapInterval(vSync ? 1 : 0);
    }

    /**
     * Set the size, in screen coordinates, of the content area of the window.
     *
     * @param width The desired width, in screen coordinates, of the window content area.
     * @param height The desired height, in screen coordinates, of the window content area.
     */
    public void setSize(final int width, final int height) {
        GLFW.glfwSetWindowSize(handle, width, height);
    }

    /**
     * Set the window title, encoded as UTF-8, of the window.
     *
     * @param title The UTF-8 encoded window title.
     */
    public void setTitle(final String title) {
        GLFW.glfwSetWindowTitle(handle, title);
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
     * Returns the aspect ratio of the content area of the window.
     *
     * @return The aspect ratio.
     */
    public float getAspectRatio() {
        final IntBuffer width = BufferUtils.createIntBuffer(1);
        final IntBuffer height = BufferUtils.createIntBuffer(1);
        GLFW.glfwGetWindowSize(handle, width, height);
        return (float) width.get() / (float) height.get();
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
