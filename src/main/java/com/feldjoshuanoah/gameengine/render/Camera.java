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

import org.joml.Matrix4f;
import org.joml.Vector3f;

/**
 * Represents an orthographic camera.
 */
public class Camera {

    /**
     * The projection matrix.
     */
    private final Matrix4f projection;

    /**
     * The view matrix.
     */
    private Matrix4f view;

    /**
     * The position.
     */
    private Vector3f position;

    /**
     * The rotation, in radians.
     */
    private float rotation;

    /**
     * Create a new orthographic camera with the given parameters.
     *
     * @param left The distance from the center to the left frustum edge.
     * @param right The distance from the center to the right frustum edge.
     * @param top The distance from the center to the top frustum edge.
     * @param bottom The distance from the center to the bottom frustum edge.
     * @param near The near clipping plane distance.
     * @param far The far clipping plane distance.
     */
    public Camera(final float left, final float right, final float top, final float bottom,
            final float near, final float far) {
        projection = new Matrix4f().ortho(left, right, top, bottom, near, far);
        view = new Matrix4f();
        position = new Vector3f();
    }

    /**
     * Get the position of the camera.
     *
     * @return The position.
     */
    public Vector3f getPosition() {
        return new Vector3f(position);
    }

    /**
     * Set the position of the camera.
     *
     * @param position The position.
     */
    public void setPosition(final Vector3f position) {
        this.position = position;
        recalculateView();
    }

    /**
     * Get the rotation, in radians, of the camera.
     *
     * @return The rotation.
     */
    public float getRotation() {
        return rotation;
    }

    /**
     * Set the rotation of the camera.
     *
     * @param rotation The rotation.
     */
    public void setRotation(final float rotation) {
        this.rotation = rotation;
        recalculateView();
    }

    /**
     * Get the projection matrix of the camera.
     *
     * @return The projection matrix.
     */
    public Matrix4f getProjection() {
        return new Matrix4f(projection);
    }

    /**
     * Get the view matrix of the camera.
     *
     * @return The view matrix.
     */
    public Matrix4f getView() {
        return new Matrix4f(view);
    }

    /**
     * Recalculate the view matrix after the position or rotation of the camera is modified.
     */
    private void recalculateView() {
        view = new Matrix4f().translate(position)
                .rotate(rotation, new Vector3f(0.0f, 0.0f, 1.0f)).invert();
    }
}
