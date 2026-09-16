package ru.itone.course_java.core.base_structures.geometry;

public final class Circle implements Shape {

    private final float r;

    public Circle(float r) {
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }

    @Override
    public double getPerimeter() {
        return 2  * Math.PI * r;
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.CIRCLE;
    }
}
