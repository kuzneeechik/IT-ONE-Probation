package ru.itone.course_java.core.base_structures.geometry;

public final class Triangle implements Shape {

    private final float a;

    private final float b;

    private final float c;

    public Triangle(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        float p = (a + b + c) / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.TRIANGLE;
    }
}
