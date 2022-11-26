package com.test.matick.model.figure;

import com.test.matick.model.figure.component.Point;
import com.test.matick.model.figure.component.Segment;
import com.test.matick.model.figure.util.ComparatorPoint;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Square extends Quadrilateral {

    public Square(Point p1,
                  Point p2,
                  Point p3,
                  Point p4,
                  Color colorFigure) {
        super(p1, p2, p3, p4, colorFigure);

        if (!isValidSquare(p1, p2, p3, p4)) {
            throw new IllegalArgumentException(String.format("the points [A: %s; B: %s;C: %s;D: %s] dont make a square", p1, p2, p3, p4));
        }
    }

    public static boolean isValidSquare(Point p1,
                                        Point p2,
                                        Point p3,
                                        Point p4) {
        List<Point> points = Stream.of(p1, p2, p3, p4)
                .sorted(new ComparatorPoint())
                .collect(Collectors.toList());

        p1 = points.get(0);
        p2 = points.get(1);
        p3 = points.get(2);
        p4 = points.get(3);

        final double EPS = 0.00001;


        Point centerSquare = new Point(
                (p1.getX() + p2.getX() + p3.getX() + p4.getX()) / 4,
                (p1.getY() + p2.getY() + p3.getY() + p4.getY()) / 4
        );

        double a = new Segment(p1, p2).length();
        double b = new Segment(p1, p3).length();
        double c = new Segment(p2, p4).length();
        double d = new Segment(p3, p4).length();

        return Math.abs(new Segment(centerSquare, p1).length() - new Segment(centerSquare, p2).length()) <= EPS &&
                Math.abs(new Segment(centerSquare, p2).length() - new Segment(centerSquare, p3).length()) <= EPS &&
                Math.abs(new Segment(centerSquare, p3).length() - new Segment(centerSquare, p4).length()) <= EPS &&
                (Math.abs(a - b) <= EPS && Math.abs(b - c) <= EPS && Math.abs(c - d) <= EPS);
    }

    @Override
    public void draw() {
        System.out.println("Квадрат був намальований!");
    }

    @Override
    public double perimeter() {
        return 4 * new Segment(pointsFigure.get(0), pointsFigure.get(1)).length();
    }

    public double diagonal() {
        return Math.sqrt(2) * new Segment(pointsFigure.get(0), pointsFigure.get(1)).length();
    }

    @Override
    public String toString() {
        return String.format(
                "Фігура %s [колір: %s, координати: [A: %s, B: %s, C: %s D: %s], площа: %.2f кв.одн., периметр: %.2f одн.]",
                "Квадрат",
                colorFigure,
                pointsFigure.get(0),
                pointsFigure.get(1),
                pointsFigure.get(2),
                pointsFigure.get(3),
                area(),
                perimeter()
        );
    }
}
