package com.test.matick.model.figure;

import com.test.matick.model.figure.component.Point;
import com.test.matick.model.figure.component.Segment;
import com.test.matick.model.figure.util.ComparatorPoint;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.*;

public abstract class Quadrilateral extends Figure {

    public Quadrilateral(Point p1,
                         Point p2,
                         Point p3,
                         Point p4,
                         Color colorFigure) {
        super(Stream.of(p1, p2, p3, p4)
                        .sorted(new ComparatorPoint())
                        .collect(Collectors.toList()),
                colorFigure
        );
    }

    public static boolean isValidQuadrilateral(Point a, Point b, Point c, Point d) {
        Point[] points = new Point[]{a, b, c, d};

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                for (int z = 0; z < points.length; z++) {
                    if (i == z || j == z) {
                        continue;
                    }
                    if (new Segment(points[i], points[j]).isTheSameLine(points[z])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    @Override
    public double area() {
        Point a = pointsFigure.get(1);
        Point b = pointsFigure.get(3);
        Point c = pointsFigure.get(0);
        Point d = pointsFigure.get(2);

        double distanceAB = new Segment(a, b).length();
        double distanceBC = new Segment(b, c).length();
        double distanceCD = new Segment(c, d).length();
        double distanceDA = new Segment(d, a).length();

        double p = (distanceAB + distanceBC + distanceCD + distanceDA) / 2;

        Point ab = new Point(b.getX() - a.getX(), b.getY() - a.getY());
        Point ad = new Point(d.getX() - a.getX(), d.getY() - a.getY());

        Point cb = new Point(b.getX() - c.getX(), b.getY() - c.getY());
        Point cd = new Point(d.getX() - c.getX(), d.getY() - c.getY());

        double theta1 = Math.acos((findMultiplyVector(ab, ad)) / (distanceAB * distanceDA));
        double theta2 = Math.acos((findMultiplyVector(cb, cd)) / (distanceCD * distanceBC));

        return sqrt((p - distanceAB) * (p - distanceBC) * (p - distanceCD) * (p - distanceDA) -
                distanceAB * distanceBC * distanceCD * distanceDA * pow(cos((theta1 + theta2) / 2), 2));
    }

    private double findMultiplyVector(Point a, Point b) {
        return a.getX() * b.getX() + a.getY() * b.getY();
    }
}
