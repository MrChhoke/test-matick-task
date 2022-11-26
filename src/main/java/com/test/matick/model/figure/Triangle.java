package com.test.matick.model.figure;

import com.test.matick.model.figure.component.Point;
import com.test.matick.model.figure.component.Segment;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.sqrt;

public class Triangle extends Figure {

    public Triangle(Point a,
                    Point b,
                    Point c,
                    Color colorFigure) {
        super(Stream.of(a, b, c).collect(Collectors.toList()), colorFigure);

        if (!isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException(String.format("the points [A: %s, B: %s, C: %s] dont make a triangle", a, b, c));
        }
    }


    public static boolean isValidTriangle(Point a, Point b, Point c) {
        return !((c.getY() - a.getY()) / (b.getY() - a.getY()) == (c.getX() - a.getX()) / (b.getX() - a.getX())
                || (a.getX() == b.getX() && c.getX() == b.getX() && a.getX() == c.getX()));
    }

    @Override
    public void draw() {
        System.out.println("Трикутник був намальований");
    }

    @Override
    public double area() {
        Point a = pointsFigure.get(0);
        Point b = pointsFigure.get(1);
        Point c = pointsFigure.get(2);

        double lengthA = new Segment(a, b).length();
        double lengthB = new Segment(b, c).length();
        double lengthC = new Segment(a, c).length();

        double halfP = (lengthA + lengthC + lengthB) / 2;
        return sqrt(halfP * (halfP - lengthA) * (halfP - lengthB) * (halfP - lengthC));

    }

    @Override
    public double perimeter() {
        Double[] lengths = getLengthSegments();
        return lengths[0] + lengths[1] + lengths[2];
    }

    public double hypotenuse() {
        Double[] lengths = getLengthSegments();

        return Math.max(lengths[0], Math.max(lengths[1], lengths[2]));
    }

    private Double[] getLengthSegments() {
        Point a = pointsFigure.get(0);
        Point b = pointsFigure.get(1);
        Point c = pointsFigure.get(2);

        return new Double[]{
                new Segment(a, b).length(),
                new Segment(b, c).length(),
                new Segment(a, c).length()
        };
    }

    @Override
    public String toString() {
        return String.format(
                "Фігура %s [колір: %s, координати: [A: %s, B: %s, C: %s]," +
                        " площа: %.2f кв.одн., периметр: %.2f одн., гіпотенуза: %.2f одн.]",
                "Трикутник",
                colorFigure,
                pointsFigure.get(0),
                pointsFigure.get(1),
                pointsFigure.get(2),
                area(),
                perimeter(),
                hypotenuse()
        );
    }
}
