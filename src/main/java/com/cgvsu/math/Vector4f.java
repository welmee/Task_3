package com.cgvsu.math;

public final class Vector4f {
    public float x, y, z, w;

    public Vector4f(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4f add(Vector4f other) {
        return new Vector4f(x + other.x, y + other.y, z + other.z, w + other.w);
    }

    public Vector4f subtract(Vector4f other) {
        return new Vector4f(x - other.x, y - other.y, z - other.z, w - other.w);
    }

    public Vector4f multiply(float scalar) {
        return new Vector4f(x * scalar, y * scalar, z * scalar, w * scalar);
    }

    public Vector4f divide(float scalar) {
        if (Math.abs(scalar) < 1e-7f) {
            throw new ArithmeticException("Division by zero");
        }
        return new Vector4f(x / scalar, y / scalar, z / scalar, w / scalar);
    }

    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z + w * w);
    }

    public Vector4f normalize() {
        float len = length();
        if (len < 1e-7f) {
            throw new ArithmeticException("Cannot normalize zero-length vector");
        }
        return divide(len);
    }

    public float dot(Vector4f other) {
        return x * other.x + y * other.y + z * other.z + w * other.w;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f, %.2f)", x, y, z, w);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector4f other = (Vector4f) obj;
        final float eps = 1e-7f;
        return Math.abs(x - other.x) < eps &&
                Math.abs(y - other.y) < eps &&
                Math.abs(z - other.z) < eps &&
                Math.abs(w - other.w) < eps;
    }
}