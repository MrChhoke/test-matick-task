package com.test.matick.figure;

import com.test.matick.model.figure.Figure;
import com.test.matick.model.figure.Triangle;
import com.test.matick.model.figure.component.Point;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TriangleTest {


    @ParameterizedTest
    @MethodSource("testCasesIsValidTriangle")
    void testIsValidTriangle(Point a, Point b, Point c, boolean expectedResult) {
        assertEquals(expectedResult, Triangle.isValidTriangle(a, b, c));
    }

    @ParameterizedTest
    @MethodSource("testCasesAreaTriangles")
    void testArea(Point a, Point b, Point c, double expectedResult) {
        assertEquals(expectedResult, new Triangle(a, b, c, Figure.Color.BLACK).area(), 0.0001);
    }

    public static Stream<Arguments> testCasesAreaTriangles() {
        return Stream.of(
                Arguments.of(
                        new Point(0, 1),
                        new Point(0, 0),
                        new Point(1, 0),
                        1D / 2
                ),
                Arguments.of(
                        new Point(0, 2),
                        new Point(2, 0),
                        new Point(0, 0),
                        2
                ),
                Arguments.of(
                        new Point(-0.5, 2),
                        new Point(2, 0),
                        new Point(0, 0),
                        2
                ),
                Arguments.of(
                        new Point(-0.5, 2),
                        new Point(2, 0.5),
                        new Point(0, 0),
                        2.125
                ),
                Arguments.of(
                        new Point(-0.5, 2),
                        new Point(2, 1.5),
                        new Point(0.5, 0.5),
                        1.625
                )
        );
    }

    public static Stream<Arguments> testCasesIsValidTriangle() {
        return Stream.of(
                Arguments.of(
                        new Point(0, 1),
                        new Point(1, 0),
                        new Point(0, 0),
                        true
                ),
                Arguments.of(
                        new Point(0, 1),
                        new Point(1, 0),
                        new Point(1.5, 0),
                        true
                ),
                Arguments.of(
                        new Point(0, 1),
                        new Point(1, 0),
                        new Point(1, 0),
                        false
                ),
                Arguments.of(
                        new Point(0, 1),
                        new Point(1, 0),
                        new Point(0.5, 0.5),
                        false
                )
        );
    }
}