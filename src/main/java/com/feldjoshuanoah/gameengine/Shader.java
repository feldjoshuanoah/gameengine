package com.feldjoshuanoah.gameengine;

import org.lwjgl.opengl.GL20;

/**
 * Represents a shader program.
 */
public class Shader {

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
            System.err.println(GL20.glGetProgramInfoLog(handle));
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
            System.err.println(GL20.glGetShaderInfoLog(shader));
            GL20.glDeleteShader(shader);
        }
        GL20.glAttachShader(handle, shader);
        return shader;
    }
}
