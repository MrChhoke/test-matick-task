package com.test.matick.model.figure.util;

import com.test.matick.model.figure.component.Point;

import java.util.Comparator;

public class ComparatorPoint implements Comparator<Point> {

    @Override
    public int compare(Point point1, Point point2) {
        if (point1 == null || point2 == null) {
            return 0;
        }

        int comparingInfo = Double.compare(point1.getX(), point2.getX());

        if (comparingInfo != 0) {
            return comparingInfo;
        }

        return Double.compare(point2.getY(), point1.getY());
    }
}
