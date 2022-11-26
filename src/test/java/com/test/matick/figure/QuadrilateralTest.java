package com.test.matick.figure;

import com.test.matick.model.figure.Quadrilateral;
import com.test.matick.model.figure.component.Point;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class QuadrilateralTest {

    @ParameterizedTest
    @MethodSource("testCasesIsValidQuadrilateral")
    public void testIsValidQuadrilateral(Point p1,
                                         Point p2,
                                         Point p3,
                                         Point p4,
                                         boolean expectedResult) {
        assertEquals(expectedResult, Quadrilateral.isValidQuadrilateral(p1, p2, p3, p4));
    }

    public Stream<Arguments> testCasesIsValidQuadrilateral() {
        return Stream.of(
                Arguments.of(
                        new Point(0, 0),
                        new Point(0, 1),
                        new Point(1, 0),
                        new Point(1, 1),
                        true
                ),
                Arguments.of(
                        new Point(-12, 5),
                        new Point(-11, 4),
                        new Point(-10.5, 6),
                        new Point(-10.5, 4.5),
                        true
                ),
                Arguments.of(
                        new Point(-12, 5),
                        new Point(-11, 5),
                        new Point(-10.5, 6),
                        new Point(-9.5, 5.5),
                        true
                ),
                Arguments.of(
                        new Point(-10.5, 5),
                        new Point(-9.5, 5),
                        new Point(-10.5, 6),
                        new Point(-9.5, 6),
                        true
                ),
                Arguments.of(
                        new Point(-12, 5),
                        new Point(-11, 4),
                        new Point(-10, 5),
                        new Point(-10.5, 4.5),
                        false
                ),
                Arguments.of(
                        new Point(-12, 5),
                        new Point(-11, 4),
                        new Point(-10.5, 6),
                        new Point(-12, 5),
                        false
                )
        );
    }

}