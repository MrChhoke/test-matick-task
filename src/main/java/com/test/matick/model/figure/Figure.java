package com.test.matick.model.figure;

import com.test.matick.model.figure.component.Point;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public abstract class Figure {

    public enum Color {
        BLACK,
        RED,
        YELLOW,
        PURPLE,
        WHITE;

    }

    protected Color colorFigure;
    protected List<Point> pointsFigure;

    public Figure(List<Point> pointsFigure, Color colorFigure) {
        setPointsFigure(pointsFigure);
        setColorFigure(colorFigure);
    }

    public abstract void draw();

    public abstract double area();

    public abstract double perimeter();

    /**
     * Method for routing figures.
     * The pivot point (0,0)
     *
     * @param angle at which it is necessary to make a turn
     */
    public void rotate(double angle) {
        double s = sin(angle);
        double c = cos(angle);

        pointsFigure = pointsFigure.stream().
                map(p -> {
                    double xnew = p.getX() * c - p.getY() * s;
                    double ynew = p.getX() * s + p.getY() * c;
                    return new Point(xnew, ynew);
                })
                .collect(Collectors.toUnmodifiableList());
    }

    protected void setPointsFigure(List<Point> pointsFigure) {
        if (pointsFigure == null || pointsFigure.isEmpty()) {
            throw new IllegalArgumentException("The list with points of figure cannot be null or empty");
        }

        pointsFigure.forEach(point -> {
            if (point == null) {
                throw new IllegalArgumentException("Points cannot be null");
            }
        });

        this.pointsFigure = pointsFigure.stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Point> getPointsFigure() {
        return pointsFigure;
    }

    public final void setColorFigure(Color colorFigure) {
        if (colorFigure == null) {
            throw new IllegalArgumentException("The color of figure cannot be null");
        }

        this.colorFigure = colorFigure;
    }

    public final Color getColorFigure() {
        return colorFigure;
    }

}
