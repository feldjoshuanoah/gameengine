package com.feldjoshuanoah.gameengine.util;

import java.util.Arrays;

/**
 * Contains the definition of a vector comprising floats and associated transformations.
 */
public class Vector {

    /**
     * Error message that is printed if the dimension of a given vector is too large.
     */
    private static final String DIMENSION_TOO_LARGE_ERROR = "Dimension of the given vector is too large";

    /**
     * The components of the vector.
     */
    private final float[] components;

    /**
     * Create a new vector with the given dimension.
     *
     * @param dimension The dimension of the vector.
     */
    public Vector(final int dimension) {
        components = new float[dimension];
    }

    /**
     * Create a new vector with the given dimension and initialize all three components with the given value.
     *
     * @param dimension The dimension of the vector.
     * @param value The value of all components.
     */
    public Vector(final int dimension, final float value) {
        this(dimension);
        Arrays.fill(components, value);
    }

    /**
     * Create a new vector and initialize its components from the elements of the given array.
     *
     * @param components The array containing the values for the components.
     */
    public Vector(final float[] components) {
        this.components = components.clone();
    }

    /**
     * Create a new vector with the same values as the given vector.
     *
     * @param vector The vector to copy the values from.
     */
    public Vector(final Vector vector) {
        this.components = vector.components;
    }

    /**
     * Add the supplied vector to this one.
     *
     * @param vector The vector to add.
     * @throws IllegalArgumentException If the dimensions of the vectors do not match.
     */
    public void add(final Vector vector) {
        if (components.length < vector.components.length) {
            throw new IllegalArgumentException(DIMENSION_TOO_LARGE_ERROR);
        }
        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }
    }

    /**
     * Subtract the supplied vector from this one.
     *
     * @param vector The vector to subtract.
     * @throws IllegalArgumentException If the dimensions of the vectors do not match.
     */
    public void subtract(final Vector vector) {
        if (components.length < vector.components.length) {
            throw new IllegalArgumentException(DIMENSION_TOO_LARGE_ERROR);
        }
        for (int i = 0; i < vector.components.length; i++) {
            components[i] -= vector.components[i];
        }
    }

    /**
     * Multiply this vector by the given scalar value.
     *
     * @param scalar The scalar to multiply by.
     */
    public void multiply(final float scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    /**
     * Multiply this vector component-wise by the supplied vector.
     *
     * @param vector The vector to multiply by.
     * @throws IllegalArgumentException If the dimensions of the vectors do not match.
     */
    public void multiply(final Vector vector) {
        if (components.length < vector.components.length) {
            throw new IllegalArgumentException(DIMENSION_TOO_LARGE_ERROR);
        }
        for (int i = 0; i < vector.components.length; i++) {
            components[i] *= vector.components[i];
        }
    }

    /**
     * Divide this vector by the given scalar value.
     *
     * @param scalar The scalar to divide by.
     */
    public void divide(final float scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] /= scalar;
        }
    }

    /**
     * Divide this vector component-wise by the supplied vector.
     *
     * @param vector The vector to multiply by.
     * @throws IllegalArgumentException If the dimensions of the vectors do not match.
     */
    public void divide(final Vector vector) {
        if (components.length < vector.components.length) {
            throw new IllegalArgumentException(DIMENSION_TOO_LARGE_ERROR);
        }
        for (int i = 0; i < vector.components.length; i++) {
            components[i] /= vector.components[i];
        }
    }

    /**
     * Negate this vector.
     */
    public void negate() {
        for (int i = 0; i < components.length; i++) {
            components[i] = -components[i];
        }
    }

    /**
     * Normalize this vector.
     */
    public void normalize() {
        float length = length();
        for (int i = 0; i < components.length; i++) {
            components[i] /= length;
        }
    }

    /**
     * Scale this vector to have the given length.
     *
     * @param length The desired length.
     */
    public void normalize(float length) {
        normalize();
        for (int i = 0; i < components.length; i++) {
            components[i] *= length;
        }
    }

    /**
     * Set each component of this vector to the largest (closest to positive infinity) float value that is less than or equal to the component and is equal to a mathematical integer.
     */
    public void floor() {
        for (int i = 0; i < components.length; i++) {
            components[i] = (float) Math.floor(components[i]);
        }
    }

    /**
     * Set each component of this vector to the smallest (closest to negative infinity) float value that is greater than or equal to the component and is equal to a mathematical integer.
     */
    public void ceil() {
        for (int i = 0; i < components.length; i++) {
            components[i] = (float) Math.ceil(components[i]);
        }
    }

    /**
     * Set each component of this vector to the closest float that is equal to a mathematical integer, with ties rounding to positive infinity.
     */
    public void round() {
        for (int i = 0; i < components.length; i++) {
            components[i] = Math.round(components[i]);
        }
    }

    /**
     * Set each component of this vector to its absolute value.
     */
    public void abs() {
        for (int i = 0; i < components.length; i++){
            components[i] = Math.abs(components[i]);
        }
    }

    /**
     * Set all components to zero.
     */
    public void zero() {
        Arrays.fill(components, 0.0f);
    }

    /**
     * Reflect this vector about the given normal vector.
     *
     * @param normal The vector to reflect about.
     * @throws IllegalArgumentException If the dimensions of the vectors do not match.
     */
    public void reflect(final Vector normal) {
        if (components.length != normal.components.length) {
            throw new IllegalArgumentException("Dimensions of the vectors do not match.");
        }
        final float dot = dot(normal);
        for (int i = 0; i < components.length; i++) {
            components[i] -= 2 * dot * normal.components[i];
        }
    }

    /**
     * Get the length of this vector.
     *
     * @return The length of this vector.
     */
    public float length() {
        float length = 0.0f;
        for (final float component : components) {
            length += Math.pow(component, 2);
        }
        return (float) Math.sqrt(length);
    }

    /**
     * Get the distance between this vector and the supplied vector.
     *
     * @param vector The other vector.
     * @return The distance.
     */
    public float distance(final Vector vector) {
        return (float) Math.sqrt(distanceSquared(vector));
    }

    /**
     * Get the squared distance between this vector and the supplied vector.
     *
     * @param vector The other vector.
     * @return The squared distance.
     */
    public float distanceSquared(final Vector vector) {
        float distanceSquared = 0.0f;
        for (int i = 0; i < components.length; i++) {
            distanceSquared += Math.pow(components[i] - vector.components[i], 2);
        }
        return distanceSquared;
    }

    /**
     * Get the dot product of this vector and the supplied vector.
     *
     * @param vector The other vector.
     * @return The dot product.
     * @throws IllegalArgumentException If the dimensions of the vectors do not match.
     */
    public float dot(final Vector vector) {
        if (components.length != vector.components.length) {
            throw new IllegalArgumentException("Dimensions of the vectors do not match.");
        }
        float dot = 0.0f;
        for (int i = 0; i < components.length; i++) {
            dot += components[i] * vector.components[i];
        }
        return dot;
    }

    /**
     * Get the value of the smallest component.
     *
     * @return The value of the smallest component.
     */
    public float min() {
        float min = Float.POSITIVE_INFINITY;
        for (final float component : components) {
            min = Math.min(min, component);
        }
        return min;
    }

    /**
     * Get the value of the largest component.
     *
     * @return The value of the largest component.
     */
    public float max() {
        float max = Float.NEGATIVE_INFINITY;
        for (final float component : components) {
            max = Math.max(max, component);
        }
        return max;
    }

    /**
     * Get the value of the specified component of this vector.
     *
     * @param index The index of the component.
     * @return The value of the specified component.
     */
    public float get(final int index) {
        return components[index];
    }

    /**
     * Get the value of the x component of this vector.
     *
     * @return The value of the x component.
     */
    public float x() {
        return components.length > 0 ? get(0) : Float.NaN;
    }

    /**
     * Get the value of the y component of this vector.
     *
     * @return The value of the y component.
     */
    public float y() {
        return components.length > 1 ? get(1) : Float.NaN;
    }

    /**
     * Get the value of the z component of this vector.
     *
     * @return The value of the z component.
     */
    public float z() {
        return components.length > 2 ? get(2) : Float.NaN;
    }

    @Override
    public String toString() {
        return Arrays.toString(components);
    }
}
