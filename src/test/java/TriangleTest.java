import org.junit.jupiter.params.provider.Arguments;
import triangleUtils.Triangle;

import java.util.stream.Stream;

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
}
