package com.test.matick.model.generator;

import com.test.matick.model.figure.*;
import com.test.matick.model.figure.component.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGeneratorFigure {

    private final Random random;

    public static final int AVAILABLE_COUNT_FIGURE = 4;
    public static final int MAX_COORDINATE = 100;
    public static final int MIN_COORDINATE = -100;

    public RandomGeneratorFigure() {
        random = new Random();
    }

    public Figure generatorRandomFigure() {
        int type = random.nextInt(AVAILABLE_COUNT_FIGURE);

        switch (type) {
            case 0:
                return generateRandomSquare();
            case 1:
                return generateRandomCircle();
            case 2:
                return generateRandomTriangle();
            case 3:
                return generateRandomTrapezium();
            default:
                throw new IllegalArgumentException("Please check a variable \"AVAILABLE_COUNT_FIGURE\"");
        }
    }

    public List<Figure> generateRandomFigures(int countFigures) {
        if (countFigures < 0) {
            throw new IllegalArgumentException("Count of figures cannot be negative");
        }

        List<Figure> randomFigures = new ArrayList<>(countFigures);

        for (int i = 0; i < countFigures; i++) {
            randomFigures.add(generatorRandomFigure());
        }

        return randomFigures;
    }

    public Figure.Color generateRandomColor() {
        Figure.Color[] arrColors = Figure.Color.values();
        return arrColors[random.nextInt(arrColors.length)];
    }


    public Square generateRandomSquare() {
        double x = generateCoordinate();
        double y = generateCoordinate();
        double z = Math.abs(generateCoordinate());

        return new Square(
                new Point(x, y),
                new Point(x + z, y),
                new Point(x, y + z),
                new Point(x + z, y + z),
                generateRandomColor()
        );
    }

    public Triangle generateRandomTriangle() {
        while (true) {
            double x = generateCoordinate();
            double y = generateCoordinate();

            double x2 = generateCoordinate();
            double y2 = generateCoordinate();

            double x3 = generateCoordinate();
            double y3 = generateCoordinate();

            try {
                return new Triangle(
                        new Point(x, y),
                        new Point(x2, y2),
                        new Point(x3, y3),
                        generateRandomColor()
                );
            } catch (Exception ignored) {
            }
        }
    }

    public Circle generateRandomCircle() {
        double x = generateCoordinate();
        double y = generateCoordinate();
        double radius = Math.abs(generateCoordinate());

        return new Circle(
                new Point(x, y),
                radius,
                generateRandomColor()
        );
    }

    public Trapezium generateRandomTrapezium() {
        double x = generateCoordinate();
        double y = generateCoordinate();
        double z = Math.abs(generateCoordinate());

        return new Trapezium(
                new Point(x, y),
                new Point(x + z, y),
                new Point(x - z, y + z),
                new Point(x + 1.5 * z, y + z),
                generateRandomColor()
        );
    }

    private double generateCoordinate() {
        return MIN_COORDINATE + random.nextDouble() * (MAX_COORDINATE - MIN_COORDINATE);
    }
}
