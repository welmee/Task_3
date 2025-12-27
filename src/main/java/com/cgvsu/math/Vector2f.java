package com.cgvsu.math;

public final class Vector2f {
    public float x, y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2f add(Vector2f other) {
        return new Vector2f(x + other.x, y + other.y);
    }

    public Vector2f subtract(Vector2f other) {
        return new Vector2f(x - other.x, y - other.y);
    }

    public Vector2f multiply(float scalar) {
        return new Vector2f(x * scalar, y * scalar);
    }

    public Vector2f divide(float scalar) {
        if (Math.abs(scalar) < 1e-7f) {
            throw new ArithmeticException("Division by zero");
        }
        return new Vector2f(x / scalar, y / scalar);
    }

    public float length() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public Vector2f normalize() {
        float len = length();
        if (len < 1e-7f) {
            throw new ArithmeticException("Cannot normalize zero-length vector");
        }
        return divide(len);
    }

    public float dot(Vector2f other) {
        return x * other.x + y * other.y;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector2f other = (Vector2f) obj;
        final float eps = 1e-7f;
        return Math.abs(x - other.x) < eps && Math.abs(y - other.y) < eps;
    }
}