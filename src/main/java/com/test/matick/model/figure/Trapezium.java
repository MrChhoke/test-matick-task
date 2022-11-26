package com.test.matick.model.figure;

import com.test.matick.model.figure.component.Point;
import com.test.matick.model.figure.component.Segment;
import com.test.matick.model.figure.component.Vector;
import com.test.matick.model.figure.util.ComparatorPoint;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Trapezium extends Quadrilateral {

    public Trapezium(Point p1,
                     Point p2,
                     Point p3,
                     Point p4,
                     Color colorFigure) {
        super(p1, p2, p3, p4, colorFigure);

        if (!isValidTrapezium(p1, p2, p3, p4)) {
            throw new IllegalArgumentException(String.format("the points [A: %s; B: %s;C: %s;D: %s] dont make a trapezium", p1, p2, p3, p4));
        }
    }

    public static boolean isValidTrapezium(Point a, Point b, Point c, Point d) {
        if (!isValidQuadrilateral(a, b, c, d)) {
            return false;
        }

        List<Point> points = Stream.of(a, b, c, d)
                .sorted(new ComparatorPoint())
                .collect(Collectors.toList());

        a = points.get(0);
        b = points.get(1);
        c = points.get(2);
        d = points.get(3);

        Vector ac = new Vector(a, c);
        Vector ab = new Vector(a, b);
        Vector bd = new Vector(b, d);
        Vector cd = new Vector(c, d);

        boolean cdParallelAB = cd.isParallel(ab);
        boolean acParallelDB = ac.isParallel(bd);

        Vector ad = new Vector(a, d);
        Vector bc = new Vector(b, c);
        boolean isADParallelBC = ad.isParallel(bc);
        boolean isABParallelCD = ab.isParallel(cd);

        if ((isABParallelCD && isADParallelBC) || (cdParallelAB && acParallelDB)) {
            return false;
        }

        return isABParallelCD || isADParallelBC || cdParallelAB || acParallelDB;
    }

    @Override
    public void draw() {
        System.out.println("Трапеція була намальована!");
    }

    @Override
    public double perimeter() {
        Point a = pointsFigure.get(0);
        Point b = pointsFigure.get(1);
        Point c = pointsFigure.get(2);
        Point d = pointsFigure.get(3);

        double distanceAB = new Segment(a, b).length();
        double distanceBC = new Segment(b, c).length();
        double distanceCD = new Segment(c, d).length();
        double distanceDA = new Segment(d, a).length();

        return distanceAB + distanceBC + distanceCD + distanceDA;
    }

    @Override
    public String toString() {
        return String.format(
                "Фігура %s [колір: %s, координати: [A: %s, B: %s, C: %s, D: %s]," +
                        " площа: %.2f кв.одн., периметр: %.2f одн.]",
                "Трапеція",
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
