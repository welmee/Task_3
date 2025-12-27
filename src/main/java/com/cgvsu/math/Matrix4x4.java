package com.cgvsu.math;

public final class Matrix4x4 {
    private final float[][] data;

    public Matrix4x4() {
        this.data = new float[4][4];
    }

    public Matrix4x4(float[][] data) {
        if (data.length != 4 || data[0].length != 4) {
            throw new IllegalArgumentException("Matrix4x4 must be 4x4");
        }
        this.data = new float[4][4];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(data[i], 0, this.data[i], 0, 4);
        }
    }

    public Matrix4x4 add(Matrix4x4 other) {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = data[i][j] + other.data[i][j];
            }
        }
        return new Matrix4x4(result);
    }

    public Matrix4x4 subtract(Matrix4x4 other) {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = data[i][j] - other.data[i][j];
            }
        }
        return new Matrix4x4(result);
    }

    public Matrix4x4 multiply(Matrix4x4 other) {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    result[i][j] += data[i][k] * other.data[k][j];
                }
            }
        }
        return new Matrix4x4(result);
    }

    public Vector4f multiply(Vector4f vector) {
        float x = data[0][0] * vector.x + data[0][1] * vector.y +
                data[0][2] * vector.z + data[0][3] * vector.w;
        float y = data[1][0] * vector.x + data[1][1] * vector.y +
                data[1][2] * vector.z + data[1][3] * vector.w;
        float z = data[2][0] * vector.x + data[2][1] * vector.y +
                data[2][2] * vector.z + data[2][3] * vector.w;
        float w = data[3][0] * vector.x + data[3][1] * vector.y +
                data[3][2] * vector.z + data[3][3] * vector.w;
        return new Vector4f(x, y, z, w);
    }

    public Matrix4x4 transpose() {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = data[j][i];
            }
        }
        return new Matrix4x4(result);
    }

    public Matrix4x4 identity() {
        float[][] identity = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        return new Matrix4x4(identity);
    }

    public Matrix4x4 zero() {
        return new Matrix4x4(new float[4][4]);
    }

    public float get(int row, int col) {
        if (row < 0 || row >= 4 || col < 0 || col >= 4) {
            throw new IllegalArgumentException("Matrix indices out of bounds");
        }
        return data[row][col];
    }

    public void set(int row, int col, float value) {
        if (row < 0 || row >= 4 || col < 0 || col >= 4) {
            throw new IllegalArgumentException("Matrix indices out of bounds");
        }
        data[row][col] = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append("[");
            for (int j = 0; j < 4; j++) {
                sb.append(String.format("%8.2f", data[i][j]));
                if (j < 3) sb.append(" ");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }
}