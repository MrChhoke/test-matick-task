package com.test.matick.model.figure.component;

public class Vector {

    private final static double EPS = 0.00001;

    private final double x;
    private final double y;


    public Vector(Point start, Point tail) {
        if (start == null || tail == null) {
            throw new IllegalArgumentException("Points cannot be null");
        }

        x = tail.getX() - start.getX();
        y = tail.getY() - start.getY();
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isParallel(Vector vector) {
        if (vector == null) {
            return false;
        }

        return Math.abs(getX() * vector.getY() - getY() * vector.getX()) <= EPS;
    }
}
