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

import org.joml.Matrix2f;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector2i;
import org.joml.Vector3f;
import org.joml.Vector3i;
import org.joml.Vector4f;
import org.joml.Vector4i;
import org.lwjgl.opengl.GL20;
import org.lwjgl.system.MemoryStack;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a shader program.
 */
public class Shader {

    /**
     * The logger for the shader.
     */
    private static final Logger LOGGER = Logger.getLogger(Shader.class.getName());

    /**
     * The number of components of a vec2.
     */
    private static final int SIZE_VEC2 = 2;

    /**
     * The number of components of a vec3.
     */
    private static final int SIZE_VEC3 = 3;

    /**
     * The number of components of a vec4.
     */
    private static final int SIZE_VEC4 = 4;

    /**
     * The number of components of a mat2.
     */
    private static final int SIZE_MAT2 = 4;

    /**
     * The number of components of a mat3.
     */
    private static final int SIZE_MAT3 = 9;

    /**
     * The number of components of a mat4.
     */
    private static final int SIZE_MAT4 = 16;

    /**
     * The program handle.
     */
    private final int handle;

    /**
     * Create a new shader program.
     *
     * @param vertexSource The source code of the vertex shader.
     * @param fragmentSource The source code of the fragment shader.
     */
    public Shader(final String vertexSource, final String fragmentSource) {
        handle = GL20.glCreateProgram();
        final int vertex = attachShader(GL20.GL_VERTEX_SHADER, vertexSource);
        final int fragment = attachShader(GL20.GL_FRAGMENT_SHADER, fragmentSource);
        GL20.glLinkProgram(handle);
        if (GL20.glGetProgrami(handle, GL20.GL_LINK_STATUS) == GL20.GL_FALSE) {
            if (LOGGER.isLoggable(Level.SEVERE)) {
                LOGGER.log(Level.SEVERE, GL20.glGetProgramInfoLog(handle));
            }
            GL20.glDeleteProgram(handle);
            GL20.glDeleteShader(vertex);
            GL20.glDeleteShader(fragment);
        }
        GL20.glDetachShader(handle, vertex);
        GL20.glDetachShader(handle, fragment);
    }

    /**
     * Install the shader program as part of current rendering state.
     */
    public void bind() {
        GL20.glUseProgram(handle);
    }

    /**
     * Uninstall the shader program as part of current rendering state.
     */
    public void unbind() {
        GL20.glUseProgram(0);
    }

    /**
     * Specifies the value of an int uniform variable for the shader program.
     *
     * @param name The name of the int uniform variable.
     * @param value The desired value for the int uniform variable.
     */
    public void uniform1i(final String name, final int value) {
        GL20.glUniform1i(GL20.glGetUniformLocation(handle, name), value);
    }

    /**
     * Specifies the value of a float uniform variable for the shader program.
     *
     * @param name The name of the float uniform variable.
     * @param value The desired value for the float uniform variable.
     */
    public void uniform1f(final String name, final float value) {
        GL20.glUniform1f(GL20.glGetUniformLocation(handle, name), value);
    }

    /**
     * Specifies the value of a single vec2 uniform variable for the shader program.
     *
     * @param name The name of the vec2 uniform variable.
     * @param vector The desired value for the vec2 uniform variable.
     */
    public void uniform2f(final String name, final Vector2f vector) {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            GL20.glUniform2fv(GL20.glGetUniformLocation(handle, name),
                    vector.get(stack.mallocFloat(SIZE_VEC2)));
        }
    }

    /**
     * Specifies the value of a single vec2 uniform variable for the shader program.
     *
     * @param name The name of the vec2 uniform variable.
     * @param vector The desired value for the vec2 uniform variable.
     */
    public void uniform2i(final String name, final Vector2i vector) {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            GL20.glUniform2iv(GL20.glGetUniformLocation(handle, name),
                    vector.get(stack.mallocInt(SIZE_VEC2)));
        }
    }

    /**
     * Specifies the value of a single vec3 uniform variable for the shader program.
     *
     * @param name The name of the vec3 uniform variable.
     * @param vector The desired value for the vec3 uniform variable.
     */
    public void uniform3f(final String name, final Vector3f vector) {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            GL20.glUniform3fv(GL20.glGetUniformLocation(handle, name),
                    vector.get(stack.mallocFloat(SIZE_VEC3)));
        }
    }

    /**
     * Specifies the value of a single vec3 uniform variable for the shader program.
     *
     * @param name The name of the vec3 uniform variable.
     * @param vector The desired value for the vec3 uniform variable.
     */
    public void uniform3i(final String name, final Vector3i vector) {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            GL20.glUniform3iv(GL20.glGetUniformLocation(handle, name),
                    vector.get(stack.mallocInt(SIZE_VEC3)));
        }
    }

    /**
     * Specifies the value of a single vec4 uniform variable for the shader program.
     *
     * @param name The name of the vec4 uniform variable.
     * @param vector The desired value for the vec4 uniform variable.
     */
    public void uniform4f(final String name, final Vector4f vector) {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            GL20.glUniform4fv(GL20.glGetUniformLocation(handle, name),
                    vector.get(stack.mallocFloat(SIZE_VEC4)));
        }
    }

    /**
     * Specifies the value of a single vec4 uniform variable for the shader program.
     *
     * @param name The name of the vec4 uniform variable.
     * @param vector The desired value for the vec4 uniform variable.
     */
    public void uniform4i(final String name, final Vector4i vector) {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            GL20.glUniform4iv(GL20.glGetUniformLocation(handle, name),
                    vector.get(stack.mallocInt(SIZE_VEC4)));
        }
    }

    /**
     * Specifies the value of a single mat3 uniform variable for the shader program.
     *
     * @param name The name of the mat3 uniform variable.
     * @param matrix The desired value for the mat3 uniform variable.
     */
    public void uniformMatrix2f(final String name, final Matrix2f matrix) {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            GL20.glUniformMatrix2fv(GL20.glGetUniformLocation(handle, name), false,
                    matrix.get(stack.mallocFloat(SIZE_MAT2)));
        }
    }

    /**
     * Specifies the value of a single mat3 uniform variable for the shader program.
     *
     * @param name The name of the mat3 uniform variable.
     * @param matrix The desired value for the mat3 uniform variable.
     */
    public void uniformMatrix3f(final String name, final Matrix3f matrix) {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            GL20.glUniformMatrix3fv(GL20.glGetUniformLocation(handle, name), false,
                    matrix.get(stack.mallocFloat(SIZE_MAT3)));
        }
    }

    /**
     * Specifies the value of a single mat4 uniform variable for the shader program.
     *
     * @param name The name of the mat4 uniform variable.
     * @param matrix The desired value for the mat4 uniform variable.
     */
    public void uniformMatrix4f(final String name, final Matrix4f matrix) {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            GL20.glUniformMatrix4fv(GL20.glGetUniformLocation(handle, name), false,
                    matrix.get(stack.mallocFloat(SIZE_MAT4)));
        }
    }

    /**
     * Create and attach a shader to the program.
     *
     * @param type The type of shader to be created.
     * @param source The source code of the shader.
     * @return The shader handle.
     */
    private int attachShader(final int type, final String source) {
        final int shader = GL20.glCreateShader(type);
        GL20.glShaderSource(shader, source);
        GL20.glCompileShader(shader);
        if (GL20.glGetShaderi(shader, GL20.GL_COMPILE_STATUS) == GL20.GL_FALSE) {
            if (LOGGER.isLoggable(Level.SEVERE)) {
                LOGGER.log(Level.SEVERE, GL20.glGetShaderInfoLog(shader));
            }
            GL20.glDeleteShader(shader);
        }
        GL20.glAttachShader(handle, shader);
        return shader;
    }
}
