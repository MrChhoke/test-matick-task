package com.test.matick.model.figure.component;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Segment {

    private final Point first;
    private final Point second;

    public Segment(Point first, Point second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Points cannot be null");
        }

        this.first = first;
        this.second = second;
    }

    public double length() {
        return sqrt(pow(second.getX() - first.getX(), 2) + pow(second.getY() - first.getY(), 2));
    }

    public boolean isTheSameLine(final Point checkPoint) {
        if (checkPoint == null) {
            return false;
        }

        return Math.abs(((checkPoint.getX() - first.getX()) * (second.getY() - first.getY())) -
                ((checkPoint.getY() - first.getY()) * (second.getX() - first.getX()))) <= 0.0001;
    }
}
