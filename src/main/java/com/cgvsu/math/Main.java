package com.cgvsu.math;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== MATH LIBRARY DEMONSTRATION ===\n");

        // Демонстрация векторов
        System.out.println("1. VECTOR OPERATIONS:");

        Vector2f v2a = new Vector2f(1, 2);
        Vector2f v2b = new Vector2f(3, 4);
        System.out.println("   Vector2f: " + v2a + " + " + v2b + " = " + v2a.add(v2b));

        Vector3f v3a = new Vector3f(1, 2, 3);
        Vector3f v3b = new Vector3f(4, 5, 6);
        System.out.println("   Vector3f: " + v3a + " + " + v3b + " = " + v3a.add(v3b));
        System.out.println("   Cross product: " + v3a.cross(v3b));
        System.out.println("   Dot product: " + v3a.dot(v3b));
        System.out.println("   Length: " + v3a.length());

        Vector4f v4 = new Vector4f(1, 2, 3, 4);
        System.out.println("   Vector4f: " + v4 + " normalized = " + v4.normalize());

        // Демонстрация матриц
        System.out.println("\n2. MATRIX OPERATIONS:");

        Matrix3x3 m3 = new Matrix3x3(new float[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        System.out.println("   Matrix3x3:\n" + m3);
        System.out.println("   Determinant: " + m3.determinant());

        Matrix3x3 identity3 = new Matrix3x3().identity();
        System.out.println("   Identity matrix:\n" + identity3);

        Vector3f m3result = m3.multiply(v3a);
        System.out.println("   Matrix * Vector: " + m3result);

        Matrix4x4 m4 = new Matrix4x4(new float[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        });
        System.out.println("   Matrix4x4:\n" + m4);

        System.out.println("\n=== DEMONSTRATION COMPLETE ===");
    }
}