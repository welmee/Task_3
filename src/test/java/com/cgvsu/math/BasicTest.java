package com.cgvsu.math;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BasicTest {

    // Vector2f Tests
    @Test
    void vector2fAddition() {
        Vector2f v1 = new Vector2f(1, 2);
        Vector2f v2 = new Vector2f(3, 4);
        Vector2f result = v1.add(v2);
        assertEquals(4, result.x, 1e-7);
        assertEquals(6, result.y, 1e-7);
    }

    @Test
    void vector2fSubtraction() {
        Vector2f v1 = new Vector2f(5, 7);
        Vector2f v2 = new Vector2f(2, 3);
        Vector2f result = v1.subtract(v2);
        assertEquals(3, result.x, 1e-7);
        assertEquals(4, result.y, 1e-7);
    }

    @Test
    void vector2fLength() {
        Vector2f v = new Vector2f(3, 4);
        assertEquals(5, v.length(), 1e-7);
    }

    @Test
    void vector2fNormalize() {
        Vector2f v = new Vector2f(3, 4);
        Vector2f normalized = v.normalize();
        assertEquals(1, normalized.length(), 1e-7);
    }

    @Test
    void vector2fDotProduct() {
        Vector2f v1 = new Vector2f(1, 2);
        Vector2f v2 = new Vector2f(3, 4);
        assertEquals(11, v1.dot(v2), 1e-7);
    }

    // Vector3f Tests
    @Test
    void vector3fCrossProduct() {
        Vector3f v1 = new Vector3f(1, 0, 0);
        Vector3f v2 = new Vector3f(0, 1, 0);
        Vector3f result = v1.cross(v2);
        assertEquals(0, result.x, 1e-7);
        assertEquals(0, result.y, 1e-7);
        assertEquals(1, result.z, 1e-7);
    }

    @Test
    void vector3fOrthogonality() {
        Vector3f v1 = new Vector3f(1, 2, 3);
        Vector3f v2 = new Vector3f(4, 5, 6);
        Vector3f cross = v1.cross(v2);
        assertEquals(0, v1.dot(cross), 1e-7);
        assertEquals(0, v2.dot(cross), 1e-7);
    }

    @Test
    void vector3fOperations() {
        Vector3f v1 = new Vector3f(1, 2, 3);
        Vector3f v2 = new Vector3f(4, 5, 6);
        Vector3f sum = v1.add(v2);
        assertEquals(5, sum.x, 1e-7);
        assertEquals(7, sum.y, 1e-7);
        assertEquals(9, sum.z, 1e-7);
    }

    // Vector4f Tests
    @Test
    void vector4fOperations() {
        Vector4f v1 = new Vector4f(1, 2, 3, 4);
        Vector4f v2 = new Vector4f(5, 6, 7, 8);
        Vector4f sum = v1.add(v2);
        assertEquals(6, sum.x, 1e-7);
        assertEquals(8, sum.y, 1e-7);
        assertEquals(10, sum.z, 1e-7);
        assertEquals(12, sum.w, 1e-7);
    }

    // Matrix3x3 Tests
    @Test
    void matrix3x3Addition() {
        Matrix3x3 m1 = new Matrix3x3(new float[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Matrix3x3 m2 = new Matrix3x3(new float[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}});
        Matrix3x3 result = m1.add(m2);
        assertEquals(10, result.get(0, 0), 1e-7);
        assertEquals(10, result.get(1, 1), 1e-7);
        assertEquals(10, result.get(2, 2), 1e-7);
    }

    @Test
    void matrix3x3Multiplication() {
        Matrix3x3 m1 = new Matrix3x3(new float[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Matrix3x3 m2 = new Matrix3x3(new float[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}});
        Matrix3x3 result = m1.multiply(m2);
        assertEquals(30, result.get(0, 0), 1e-7);
        assertEquals(24, result.get(0, 1), 1e-7);
        assertEquals(18, result.get(0, 2), 1e-7);
    }

    @Test
    void matrix3x3VectorMultiplication() {
        Matrix3x3 m = new Matrix3x3(new float[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Vector3f v = new Vector3f(1, 2, 3);
        Vector3f result = m.multiply(v);
        assertEquals(14, result.x, 1e-7);
        assertEquals(32, result.y, 1e-7);
        assertEquals(50, result.z, 1e-7);
    }

    @Test
    void matrix3x3Identity() {
        Matrix3x3 identity = new Matrix3x3().identity();
        Matrix3x3 m = new Matrix3x3(new float[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Matrix3x3 result = m.multiply(identity);
        assertEquals(m.get(0, 0), result.get(0, 0), 1e-7);
        assertEquals(m.get(1, 1), result.get(1, 1), 1e-7);
        assertEquals(m.get(2, 2), result.get(2, 2), 1e-7);
    }

    @Test
    void matrix3x3Determinant() {
        Matrix3x3 m = new Matrix3x3(new float[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        assertEquals(0, m.determinant(), 1e-7);
    }

    @Test
    void matrix3x3Transpose() {
        Matrix3x3 m = new Matrix3x3(new float[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Matrix3x3 transposed = m.transpose();
        assertEquals(m.get(0, 1), transposed.get(1, 0), 1e-7);
        assertEquals(m.get(1, 2), transposed.get(2, 1), 1e-7);
    }

    // Matrix4x4 Tests
    @Test
    void matrix4x4Operations() {
        Matrix4x4 m = new Matrix4x4(new float[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        });
        Matrix4x4 identity = new Matrix4x4().identity();
        Matrix4x4 result = m.multiply(identity);
        assertEquals(m.get(0, 0), result.get(0, 0), 1e-7);
        assertEquals(m.get(1, 1), result.get(1, 1), 1e-7);
        assertEquals(m.get(2, 2), result.get(2, 2), 1e-7);
        assertEquals(m.get(3, 3), result.get(3, 3), 1e-7);
    }

    @Test
    void matrix4x4VectorMultiplication() {
        Matrix4x4 m = new Matrix4x4().identity();
        Vector4f v = new Vector4f(1, 2, 3, 4);
        Vector4f result = m.multiply(v);
        assertEquals(1, result.x, 1e-7);
        assertEquals(2, result.y, 1e-7);
        assertEquals(3, result.z, 1e-7);
        assertEquals(4, result.w, 1e-7);
    }

    // Error Tests
    @Test
    void divisionByZeroThrows() {
        Vector2f v = new Vector2f(1, 1);
        assertThrows(ArithmeticException.class, () -> v.divide(0));
    }

    @Test
    void zeroVectorNormalizeThrows() {
        Vector2f zero = new Vector2f(0, 0);
        assertThrows(ArithmeticException.class, zero::normalize);
    }

    @Test
    void invalidMatrixIndicesThrow() {
        Matrix3x3 m = new Matrix3x3();
        assertThrows(IllegalArgumentException.class, () -> m.get(5, 5));
        assertThrows(IllegalArgumentException.class, () -> m.set(-1, 0, 1));
    }
}