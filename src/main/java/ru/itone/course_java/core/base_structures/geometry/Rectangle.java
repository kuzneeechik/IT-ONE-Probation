package ru.itone.course_java.core.base_structures.geometry;

public sealed class Rectangle implements Shape
        permits Square {

    private final float a;

    private final float b;

    public Rectangle(float a, float b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getArea() {
        return a * b;
    }

    @Override
    public double getPerimeter() {
        return (a + b) * 2;
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.RECTANGLE;
    }
}
