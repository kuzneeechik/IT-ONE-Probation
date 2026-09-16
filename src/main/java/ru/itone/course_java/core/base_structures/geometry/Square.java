package ru.itone.course_java.core.base_structures.geometry;

public final class Square extends Rectangle {

    public Square(float a, float b) {
        super(a, b);
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.SQUARE;
    }
}
