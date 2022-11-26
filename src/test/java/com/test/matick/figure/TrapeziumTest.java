package com.test.matick.figure;

import com.test.matick.model.figure.Figure;
import com.test.matick.model.figure.Trapezium;
import com.test.matick.model.figure.component.Point;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TrapeziumTest {

    @ParameterizedTest
    @MethodSource("testCasesIsValidTrapezium")
    public void testIsValid(Point a,
                            Point b,
                            Point c,
                            Point d,
                            boolean expectedResult) {
        assertEquals(expectedResult, Trapezium.isValidTrapezium(a, b, c, d));
    }

    @ParameterizedTest
    @MethodSource("testCasesArea")
    public void testArea(Point a,
                         Point b,
                         Point c,
                         Point d,
                         double expectedArea) {
        assertEquals(expectedArea, new Trapezium(a, b, c, d, Figure.Color.BLACK).area(), 0.000001);
    }

    @ParameterizedTest
    @MethodSource("testCasesPerimeter")
    public void testPerimeter(Point p1,
                              Point p2,
                              Point p3,
                              Point p4,
                              double expectedResult) {
        assertEquals(expectedResult, new Trapezium(p1, p2, p3, p4, Figure.Color.BLACK).perimeter(), 0.001);
    }

    public Stream<Arguments> testCasesIsValidTrapezium() {
        return Stream.of(
                Arguments.of(
                        new Point(-8, 1),
                        new Point(-5, 1),
                        new Point(-7, 2),
                        new Point(-6, 2),
                        true
                ),
                Arguments.of(
                        new Point(-12, 5),
                        new Point(-11, 4),
                        new Point(-9, 5),
                        new Point(-10, 4),
                        true
                ),
                Arguments.of(
                        new Point(-12.5, 7),
                        new Point(-9.5, 7),
                        new Point(-10.5, 6),
                        new Point(-9.5, 6),
                        true
                ),
                Arguments.of(
                        new Point(-11, 3),
                        new Point(-6, 5),
                        new Point(-10, 5),
                        new Point(-8, 5),
                        false
                ),
                Arguments.of(
                        new Point(-11, 3),
                        new Point(-8, 6),
                        new Point(-10, 5),
                        new Point(-8, 6),
                        false
                ),
                Arguments.of(
                        new Point(-10, 3),
                        new Point(-9, 4),
                        new Point(-10, 5),
                        new Point(-8, 5),
                        false
                ),
                Arguments.of(
                        new Point(-11, 4.5),
                        new Point(-9, 7),
                        new Point(-10.5, 6),
                        new Point(-9.5, 6),
                        false
                ),
                Arguments.of(
                        new Point(-10, 7),
                        new Point(-9, 7),
                        new Point(-10.5, 6),
                        new Point(-9.5, 6),
                        false
                )
        );
    }

    public Stream<Arguments> testCasesArea() {
        return Stream.of(
                Arguments.of(
                        new Point(-8, 1),
                        new Point(-5, 1),
                        new Point(-7, 2),
                        new Point(-6, 2),
                        2
                ),
                Arguments.of(
                        new Point(-8, 1),
                        new Point(-5, 1),
                        new Point(-7, 3),
                        new Point(-6, 3),
                        4
                ),
                Arguments.of(
                        new Point(-7, 1),
                        new Point(-5, 1),
                        new Point(-7, 3),
                        new Point(-6, 3),
                        3
                ),
                Arguments.of(
                        new Point(-7, 1),
                        new Point(-5, 1),
                        new Point(-7, 4),
                        new Point(-6, 4),
                        4.5
                ),
                Arguments.of(
                        new Point(-12, 1),
                        new Point(-5, 1),
                        new Point(-7, 4),
                        new Point(-6, 4),
                        12
                ),
                Arguments.of(
                        new Point(-12, 1),
                        new Point(-5, 1),
                        new Point(-11, 4),
                        new Point(-5, 4),
                        19.5
                )
        );
    }

    public Stream<Arguments> testCasesPerimeter() {
        return Stream.of(
                Arguments.of(
                        new Point(-11, 3),
                        new Point(-7, 3),
                        new Point(-10, 5),
                        new Point(-8, 5),
                        4 + 2.2360679774998 + 2.2360679774998 + 2
                )
        );
    }


}