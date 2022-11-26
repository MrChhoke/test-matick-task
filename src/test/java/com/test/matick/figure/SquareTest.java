package com.test.matick.figure;

import com.test.matick.model.figure.Figure;
import com.test.matick.model.figure.Square;
import com.test.matick.model.figure.component.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SquareTest {


    @Test
    public void testConstructorSquare() {
        assertDoesNotThrow(() -> {
            new Square(
                    new Point(1, 1),
                    new Point(0, 1),
                    new Point(1, 0),
                    new Point(0, 0),
                    Figure.Color.BLACK
            );
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Square(
                    null,
                    new Point(0, 1),
                    new Point(1, 0),
                    new Point(0, 0),
                    Figure.Color.BLACK
            );
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Square(
                    new Point(1, 1),
                    new Point(0, 1),
                    new Point(1, 0),
                    new Point(0, 0),
                    null
            );
        });
    }

    @ParameterizedTest
    @MethodSource("testCasesPerimeter")
    public void testPerimeter(Point p1,
                              Point p2,
                              Point p3,
                              Point p4,
                              double expectedResult) {
        assertEquals(expectedResult, new Square(p1, p2, p3, p4, Figure.Color.BLACK).perimeter(), 0.001);
    }

    @ParameterizedTest
    @MethodSource("testCasesIsValidSquares")
    public void testIsValidSquare(Point p1,
                                  Point p2,
                                  Point p3,
                                  Point p4,
                                  boolean expectedResult) {
        assertEquals(expectedResult, Square.isValidSquare(p1, p2, p3, p4));
    }

    public Stream<Arguments> testCasesPerimeter() {
        return Stream.of(
                Arguments.of(
                       new Point(0,0),
                       new Point(1,0),
                       new Point(0,1),
                       new Point(1,1),
                        4
                ),
                Arguments.of(
                        new Point(-10,3),
                        new Point(-8,3),
                        new Point(-10,5),
                        new Point(-8,5),
                        8
                )
        );
    }

    public Stream<Arguments> testCasesIsValidSquares() {
        return Stream.of(
                Arguments.of(
                        new Point(0, 0),
                        new Point(1, 1),
                        new Point(0, 1),
                        new Point(1, 0),
                        true
                ),
                Arguments.of(
                        new Point(20, 0),
                        new Point(1, 1),
                        new Point(0, 1),
                        new Point(1, 0),
                        false
                ),
                Arguments.of(
                        new Point(0, 0),
                        new Point(1.6, 1),
                        new Point(0, 1),
                        new Point(1, 0),
                        false
                ),
                Arguments.of(
                        new Point(0, 1),
                        new Point(1, 0),
                        new Point(-1, 0),
                        new Point(0, -1),
                        true
                ),
                Arguments.of(
                        new Point(0, 1),
                        new Point(1, 0),
                        new Point(-1.0001, 0),
                        new Point(0, -1),
                        false
                ),
                Arguments.of(
                        new Point(0, -2),
                        new Point(0, 2),
                        new Point(0, 2),
                        new Point(0, -2),
                        false
                ),
                Arguments.of(
                        new Point(-2, 0),
                        new Point(2, 0),
                        new Point(2, 0),
                        new Point(-2, 0),
                        false
                ),
                Arguments.of(
                        new Point(-2, 0),
                        new Point(0, 2),
                        new Point(0, 2),
                        new Point(-2, 0),
                        false
                ),
                Arguments.of(
                        new Point(0, -2),
                        new Point(2, 0),
                        new Point(2, 0),
                        new Point(0, -2),
                        false
                ),
                Arguments.of(
                        new Point(0, 0),
                        new Point(1, 0),
                        new Point(2, -2),
                        new Point(0, -1),
                        false
                ),
                Arguments.of(
                        new Point(0, 0),
                        new Point(1, 0),
                        new Point(2, -1),
                        new Point(0, -1),
                        false
                ),
                Arguments.of(
                        new Point(0, 0),
                        new Point(1, 0),
                        new Point(1, -1),
                        new Point(0, -1),
                        true
                ),
                Arguments.of(
                        new Point(0, 0),
                        new Point(2, 0),
                        new Point(2, -2),
                        new Point(0, -2),
                        true
                )
        );
    }
}