package com.test.matick.model.figure;

import com.test.matick.model.figure.component.Point;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Circle extends Figure {

    private double radius;

    public Circle(Point center,
                  double radius,
                  Color colorFigure) {
        super(Stream.of(center).collect(Collectors.toList()), colorFigure);
        setRadius(radius);
    }

    @Override
    public void draw() {
        System.out.println("Коло було намальоване");
    }

    @Override
    public double area() {
        return radius * radius * Math.PI;
    }

    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double perimeter() {
        return 2 * radius * Math.PI;
    }

    public Point getCenter() {
        return pointsFigure.get(0);
    }


    public double diameter(){
        return 2 * radius;
    }

    @Override
    public String toString() {
        return String.format(
                "Фігура %s [колір: %s, центр: %s, радіус: %.2f одн., площа: %.2f кв.одн.," +
                        " периметр: %.2f одн., діаметр: %.2f одн.]",
                "Коло",
                colorFigure,
                getCenter(),
                radius,
                area(),
                perimeter(),
                diameter()
        );
    }
}
