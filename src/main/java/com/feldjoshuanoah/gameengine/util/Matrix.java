package com.feldjoshuanoah.gameengine.util;

import java.util.Arrays;

/**
 * Contains the definition of a matrix comprising floats and associated transformations.
 */
public class Matrix {

    /**
     * Error message that is printed if the dimension of a given matrix is too large.
     */
    private static final String DIMENSION_TOO_LARGE_ERROR = "Dimension of the given vector is too large";

    /**
     * The components of the matrix.
     */
    private final float[][] components;

    /**
     * Create a new matrix with the given dimensions and set it to identity.
     *
     * @param rows The row dimension of the matrix.
     * @param columns The column dimension of the matrix.
     */
    public Matrix(final int rows, final int columns) {
        components = new float[rows][columns];
    }

    /**
     * Create a new matrix and initialize its components from the elements of the given array.
     *
     * @param components The array containing the values for the components.
     */
    public Matrix(final float[][] components) {
        this.components = components.clone();
    }

    /**
     * Create a new matrix with the same values as the given matrix.
     *
     * @param matrix The matrix to copy the values from.
     */
    public Matrix(final Matrix matrix) {
        this.components = matrix.components;
    }

    /**
     * Add the supplied matrix to this one.
     *
     * @param matrix The matrix to add.
     * @throws IllegalArgumentException If the dimension the given matrix is too large.
     */
    public void add(final Matrix matrix) {
        if (rows() < matrix.rows() || columns() < matrix.columns()) {
            throw new IllegalArgumentException(DIMENSION_TOO_LARGE_ERROR);
        }
        for (int i = 0; i < matrix.rows(); i++) {
            for (int j = 0; j < matrix.columns(); j++) {
                components[i][j] += matrix.components[i][j];
            }
        }
    }

    /**
     * Subtract the supplied matrix from this one.
     *
     * @param matrix The matrix to subtract.
     * @throws IllegalArgumentException If the dimension the given matrix is too large.
     */
    public void subtract(final Matrix matrix) {
        if (rows() < matrix.rows() || columns() < matrix.columns()) {
            throw new IllegalArgumentException(DIMENSION_TOO_LARGE_ERROR);
        }
        for (int i = 0; i < matrix.rows(); i++) {
            for (int j = 0; j < matrix.columns(); j++) {
                components[i][j] -= matrix.components[i][j];
            }
        }
    }

    /**
     * Multiply this matrix by the given scalar value.
     *
     * @param scalar The scalar to multiply by.
     */
    public void multiply(final float scalar) {
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < columns(); i++) {
                components[i][j] *= scalar;
            }
        }
    }

    /**
     * Multiply this matrix by the supplied matrix.
     *
     * @param matrix The right operand of the matrix multiplication.
     * @return The product.
     */
    public Matrix multiply(final Matrix matrix) {
        if (columns() != matrix.rows()) {
            throw new IllegalArgumentException("Number of columns of this matrix does not match number of rows of the given matrix");
        }
        final float[][] product = new float[rows()][matrix.columns()];
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < matrix.columns(); j++) {
                for (int k = 0; k < columns(); k++) {
                    product[i][j] += components[i][k] * matrix.components[k][j];
                }
            }
        }
        return new Matrix(product);
    }

    /**
     * Negate this matrix.
     */
    public void negate() {
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < columns(); i++) {
                components[i][j] = -components[i][j];
            }
        }
    }

    /**
     * Set this matrix to the identity.
     */
    public void identity() {
        for (int i = 0; i < Math.min(rows(), columns()); i++) {
            components[i][i] = 1;
        }
    }

    /**
     * Get the row dimension of this matrix.
     *
     * @return The row dimension.
     */
    public int rows() {
        return components.length;
    }

    /**
     * Get the column dimension of this matrix.
     *
     * @return The column dimension.
     */
    public int columns() {
        return components[0].length;
    }

    /**
     * Get the determinant of this matrix.
     *
     * @return The determinant.
     * @throws IllegalArgumentException If the matrix is not a square matrix.
     */
    public float det() {
        if (!isSquare()) {
            throw new IllegalArgumentException("Determinant is only valid for square matrices");
        }
        if (rows() == 2) {
            return components[0][0] * components[1][1] - components[0][1] * components[1][0];
        }
        float det = 0.0f;
        for (int j = 0; j < columns(); j++) {
            det += Math.pow(-1.0f, j) * components[0][j] * minor(0, j).det();
        }
        return det;
    }

    /**
     * Get the minor matrix that results from removing the given row and column from this matrix.
     *
     * @param row The row to remove.
     * @param column The column to remove.
     * @return The minor matrix.
     */
    private Matrix minor(final int row, final int column) {
        final float[][] minor = new float[rows() - 1][columns() - 1];
        for (int i = 0; i < rows() - 1; i++) {
            for (int j = 0; j < columns() - 1; j++) {
                minor[i][j] = components[i < row ? i : i + 1][j < column ? j : j + 1];
            }
        }
        return new Matrix(minor);
    }

    /**
     * Determine whether the matrix is a square matrix.
     *
     * @return {@code true} if the matrix is a square matrix, {@code false} otherwise.
     */
    public boolean isSquare() {
        return rows() == columns();
    }

    /**
     * Determine whether the matrix is an identity matrix.
     *
     * @return {@code true} if the matrix is an identity matrix, {@code false} otherwise.
     */
    public boolean isIdentity() {
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < columns(); i++) {
                if (components[i][j] != (i == j ? 1.0f : 0.0f)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Determine whether the matrix is a symmetric matrix.
     *
     * @return {@code true} if the matrix is a symmetric matrix, {@code false} otherwise.
     */
    public boolean isSymmetric() {
        if (!isSquare()) {
            return false;
        }
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < columns(); j++) {
                if (components[i][j] != components[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Get the value of the specified component of this matrix.
     *
     * @param row The row index of the component.
     * @param column The column index of the component.
     * @return The value of the specified component.
     */
    public float get(final int row, final int column) {
        return components[row][column];
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "components=" + Arrays.deepToString(components) +
                '}';
    }
}
