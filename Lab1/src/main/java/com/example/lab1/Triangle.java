package com.example.lab1;

public class Triangle {
    public static String isTriangle(double a, double b, double c) {
        if (a + b > c && a + c > b && b + c > a) {
        double aSquare = a * a;
        double bSquare = b * b;
        double cSquare = c * c;

        if (aSquare + bSquare == cSquare || aSquare + cSquare == bSquare || bSquare + cSquare == aSquare) {
            return "Прямоугольный треугольник";
        } else if (aSquare + bSquare > cSquare && aSquare + cSquare > bSquare && bSquare + cSquare > aSquare) {
            return "Остроугольный треугольник";
        } else {
            return "Тупоугольный треугольник";
        }
    } else {
        return "Треугольник с такими сторонами не существует";
    }
}
}