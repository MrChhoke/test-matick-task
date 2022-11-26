package com.test.matick.figure.component;

import com.test.matick.model.figure.component.Point;
import com.test.matick.model.figure.component.Segment;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SegmentTest {

    @ParameterizedTest
    @MethodSource("testCasesIsTheSameLime")
    public void testIsTheSameLime(Point startPointSegment,
                                  Point tailPointSegment,
                                  Point checkPoint,
                                  boolean expectedResult) {
        assertEquals(expectedResult, new Segment(startPointSegment, tailPointSegment).isTheSameLine(checkPoint));
    }

    @ParameterizedTest
    @MethodSource("testCasesLength")
    public void testLength(Point first, Point second, double expectedLength) {
        assertEquals(expectedLength, new Segment(first, second).length(), 0.0001D);
    }

    public Stream<Arguments> testCasesIsTheSameLime() {
        return Stream.of(
                Arguments.of(
                        new Point(0, 0),
                        new Point(1, 1),
                        new Point(0.6, 0.6),
                        true
                ),
                Arguments.of(
                        new Point(0, 0),
                        new Point(1, 1),
                        new Point(-0.6, -0.6),
                        true
                ),
                Arguments.of(
                        new Point(0, 0),
                        new Point(2, 2),
                        new Point(0.6, 0.6),
                        true
                ),
                Arguments.of(
                        new Point(0, 0),
                        new Point(1, 1),
                        new Point(0.7, 0.6),
                        false
                )
        );
    }

    public Stream<Arguments> testCasesLength() {
        return Stream.of(
                Arguments.of(
                        new Point(0, 0),
                        new Point(0, 0),
                        0
                ),
                Arguments.of(
                        new Point(0, 0),
                        new Point(0, 1),
                        1
                ),
                Arguments.of(
                        new Point(0, 0),
                        new Point(1, 1),
                        Math.sqrt(2)
                ),
                Arguments.of(
                        new Point(0, 0),
                        new Point(3, 3),
                        Math.sqrt(18)
                )
        );
    }
}