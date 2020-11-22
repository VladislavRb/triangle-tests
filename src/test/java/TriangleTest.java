import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import triangleException.WrongInputException;
import triangleUtils.Triangle;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    private static Triangle triangle;

    private static Stream<Arguments> provideArgumentsForWrongArgumentsLengthException() {
        return Stream.of(
                Arguments.of((Object) new Object[] {2.4, 5.7, 3, 1}),
                Arguments.of((Object) new Object[] {1, 0, 8.12, -45}),
                Arguments.of((Object) new Object[] {5, 12.21, 44, 2.1})
        );
    }

    private static Stream<Arguments> provideArgumentsForWrongArgumentsTypeException() {
        return Stream.of(
                Arguments.of((Object) new Object[] {2, "3", 5}),
                Arguments.of((Object) new Object[] {8, 'a', 1}),
                Arguments.of((Object) new Object[] {0, true, 9})
        );
    }

    private static Stream<Arguments> provideArgumentsForZeroArgumentsException() {
        return Stream.of(
                Arguments.of((Object) new Object[] {2, 0, 5}),
                Arguments.of((Object) new Object[] {0, 0, 9}),
                Arguments.of((Object) new Object[] {0, 0, 0})
        );
    }

    private static Stream<Arguments> provideArgumentsForNegativeArgumentsException() {
        return Stream.of(
                Arguments.of((Object) new Object[] {-2, -3, 5}),
                Arguments.of((Object) new Object[] {1, 4, -5}),
                Arguments.of((Object) new Object[] {9 , -1, 4})
        );
    }

    private static Stream<Arguments> provideArgumentsForImpossibleTriangle() {
        return Stream.of(
                Arguments.of((Object) new Object[] {1, 6, 8}),
                Arguments.of((Object) new Object[] {5, 2, 10})
        );
    }

    private static Stream<Arguments> provideArgumentsForPossibleTriangle() {
        return Stream.of(
                Arguments.of((Object) new Object[] {3, 4, 5}),
                Arguments.of((Object) new Object[] {2, 7, 6})
        );
    }

    private static Stream<Arguments> provideArgumentsForAcuteTriangle() {
        return Stream.of(
                Arguments.of((Object) new Object[] {9, 12, 14}),
                Arguments.of((Object) new Object[] {5, 6, 7}),
                Arguments.of((Object) new Object[] {18, 21, 26})
        );
    }

    private static Stream<Arguments> provideArgumentsForRightTriangle() {
        return Stream.of(
                Arguments.of((Object) new Object[] {5, 12, 13}),
                Arguments.of((Object) new Object[] {1, 2, 2.23606797}),
                Arguments.of((Object) new Object[] {28, 35, 21})
        );
    }

    private static Stream<Arguments> provideArgumentsForObtuseTriangle() {
        return Stream.of(
                Arguments.of((Object) new Object[] {22, 31, 13}),
                Arguments.of((Object) new Object[] {2, 5, 6}),
                Arguments.of((Object) new Object[] {4, 7, 4})
        );
    }

    @BeforeAll
    static void initTriangle() {
        triangle = new Triangle();
    }

    @ParameterizedTest(name = "wrong arguments length")
    @MethodSource("provideArgumentsForWrongArgumentsLengthException")
    void wrongArgumentsLengthException(Object ...args) {
        Exception exception = assertThrows(WrongInputException.class, () -> triangle.isTriangle(args));

        String expectedMessage = "3 arguments should be passed";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);
    }

    @ParameterizedTest(name = "wrong arguments type")
    @MethodSource("provideArgumentsForWrongArgumentsTypeException")
    void wrongArgumentsTypeException(Object ...args) {
        Exception exception = assertThrows(WrongInputException.class, () -> triangle.isTriangle(args));

        String expectedMessage = "Wrong type of one ore more arguments";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);
    }

    @ParameterizedTest(name = "zero sides")
    @MethodSource("provideArgumentsForZeroArgumentsException")
    void zeroArgumentsException(Object... args) {
        Exception exception = assertThrows(WrongInputException.class, () -> triangle.isTriangle(args));

        String expectedMessage = "A side value can't be equal to 0";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);
    }

    @ParameterizedTest(name = "negative sides")
    @MethodSource("provideArgumentsForNegativeArgumentsException")
    void negativeArgumentsException(Object... args) {
        Exception exception = assertThrows(WrongInputException.class, () -> triangle.isTriangle(args));

        String expectedMessage = "A side value can't be negative";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);
    }

    @ParameterizedTest(name = "is not a triangle")
    @MethodSource("provideArgumentsForImpossibleTriangle")
    void impossibleTriangle(Object... args) throws WrongInputException {
        assertFalse(triangle.isTriangle(args));
    }

    @ParameterizedTest(name = "is a triangle")
    @MethodSource("provideArgumentsForPossibleTriangle")
    void possibleTriangle(Object... args) throws WrongInputException {
        assertTrue(triangle.isTriangle(args));
    }

    @ParameterizedTest(name = "triangle is acute")
    @MethodSource("provideArgumentsForAcuteTriangle")
    void acuteTriangle(Object ...args) throws WrongInputException {
        String expected = "acute";
        String actual = triangle.getType(args);

        assertEquals(actual, expected);
    }

    @ParameterizedTest(name = "triangle is right")
    @MethodSource("provideArgumentsForRightTriangle")
    void rightTriangle(Object ...args) throws WrongInputException {
        String expected = "right";
        String actual = triangle.getType(args);

        assertEquals(actual, expected);
    }

    @ParameterizedTest(name = "triangle is obtuse")
    @MethodSource("provideArgumentsForObtuseTriangle")
    void obtuseTriangle(Object ...args) throws WrongInputException {
        String expected = "obtuse";
        String actual = triangle.getType(args);

        assertEquals(actual, expected);
    }
}
