package com.cgvsu.math;

public final class Matrix3x3 {
    private final float[][] data;

    public Matrix3x3() {
        this.data = new float[3][3];
    }

    public Matrix3x3(float[][] data) {
        if (data.length != 3 || data[0].length != 3) {
            throw new IllegalArgumentException("Matrix3x3 must be 3x3");
        }
        this.data = new float[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(data[i], 0, this.data[i], 0, 3);
        }
    }

    public Matrix3x3 add(Matrix3x3 other) {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = data[i][j] + other.data[i][j];
            }
        }
        return new Matrix3x3(result);
    }

    public Matrix3x3 subtract(Matrix3x3 other) {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = data[i][j] - other.data[i][j];
            }
        }
        return new Matrix3x3(result);
    }

    public Matrix3x3 multiply(Matrix3x3 other) {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    result[i][j] += data[i][k] * other.data[k][j];
                }
            }
        }
        return new Matrix3x3(result);
    }

    public Vector3f multiply(Vector3f vector) {
        float x = data[0][0] * vector.x + data[0][1] * vector.y + data[0][2] * vector.z;
        float y = data[1][0] * vector.x + data[1][1] * vector.y + data[1][2] * vector.z;
        float z = data[2][0] * vector.x + data[2][1] * vector.y + data[2][2] * vector.z;
        return new Vector3f(x, y, z);
    }

    public Matrix3x3 transpose() {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = data[j][i];
            }
        }
        return new Matrix3x3(result);
    }

    public Matrix3x3 identity() {
        float[][] identity = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        return new Matrix3x3(identity);
    }

    public Matrix3x3 zero() {
        return new Matrix3x3(new float[3][3]);
    }

    public float determinant() {
        return data[0][0] * (data[1][1] * data[2][2] - data[1][2] * data[2][1])
                - data[0][1] * (data[1][0] * data[2][2] - data[1][2] * data[2][0])
                + data[0][2] * (data[1][0] * data[2][1] - data[1][1] * data[2][0]);
    }

    public float get(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            throw new IllegalArgumentException("Matrix indices out of bounds");
        }
        return data[row][col];
    }

    public void set(int row, int col, float value) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            throw new IllegalArgumentException("Matrix indices out of bounds");
        }
        data[row][col] = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append("[");
            for (int j = 0; j < 3; j++) {
                sb.append(String.format("%8.2f", data[i][j]));
                if (j < 2) sb.append(" ");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }
}