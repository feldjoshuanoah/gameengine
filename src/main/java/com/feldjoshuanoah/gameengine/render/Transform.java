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

import org.joml.Vector2f;

/**
 * Represents a transform.
 */
public class Transform {

    /**
     * The position.
     */
    private Vector2f position;

    /**
     * The scale.
     */
    private Vector2f scale;

    /**
     * The rotation.
     */
    private float rotation;

    /**
     * The z-index.
     */
    private int z;

    /**
     * Create a new transform with the given position and scale.
     *
     * @param position The desired position.
     * @param scale The desired scale.
     */
    public Transform(final Vector2f position, final Vector2f scale) {
        this.position = position;
        this.scale = scale;
    }

    /**
     * Create a new transform with the given position.
     *
     * @param position The desired position.
     */
    public Transform(final Vector2f position) {
        this(position, new Vector2f());
    }

    /**
     * Create a new transform.
     */
    public Transform() {
        this(new Vector2f(), new Vector2f());
    }

    /**
     * Create a new transform that contains the values of the given transform.
     *
     * @param transform The transform to copy the values from.
     */
    public Transform(final Transform transform) {
        this.position = new Vector2f(transform.position);
        this.scale = new Vector2f(transform.scale);
        this.rotation = transform.rotation;
        this.z = transform.z;
    }

    /**
     * Get the position.
     *
     * @return The position.
     */
    public Vector2f getPosition() {
        return new Vector2f(position);
    }

    /**
     * Set the position.
     *
     * @param position The position.
     */
    public void setPosition(final Vector2f position) {
        this.position = new Vector2f(position);
    }

    /**
     * Get the scale.
     *
     * @return The scale.
     */
    public Vector2f getScale() {
        return new Vector2f(scale);
    }

    /**
     * Set the scale.
     *
     * @param scale The scale.
     */
    public void setScale(final Vector2f scale) {
        this.scale =new Vector2f( scale);
    }

    /**
     * Get the rotation.
     *
     * @return The rotation.
     */
    public float getRotation() {
        return rotation;
    }

    /**
     * Set the rotation.
     *
     * @param rotation The rotation.
     */
    public void setRotation(final float rotation) {
        this.rotation = rotation;
    }

    /**
     * Get the z-index.
     *
     * @return The z-index.
     */
    public int getZ() {
        return z;
    }

    /**
     * Set the z-index.
     *
     * @param z The z-index.
     */
    public void setZ(final int z) {
        this.z = z;
    }
}
