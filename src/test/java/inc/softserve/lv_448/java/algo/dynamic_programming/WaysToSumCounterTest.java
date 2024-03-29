package inc.softserve.lv_448.java.algo.dynamic_programming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WaysToSumCounterTest {
    private WaysToSumCounter waysToSumCounter;

    @BeforeEach
    void setUp() {
        waysToSumCounter = new WaysToSumCounter();
    }

    @ParameterizedTest
    @MethodSource("supplyTestData")
    void countWaysToSumToN(List<Integer> possibleNumbers, int n, int expected) {
        assertEquals(expected, waysToSumCounter.countWaysToSumToN(possibleNumbers, n));
    }

    @ParameterizedTest
    @MethodSource("supplyTestDataThrowsIllegalArgumentException")
    void countWaysToSumToNThrowsIllegalArgumentException(List<Integer> possibleNumbers, int n) {
        assertThrows(IllegalArgumentException.class,
                () -> waysToSumCounter.countWaysToSumToN(possibleNumbers, n));
    }

    static Stream<Arguments> supplyTestData() {
        return Stream.of(Arguments.arguments(Collections.singletonList(1), 1, 1),
                Arguments.arguments(Arrays.asList(1, 2, 3), 5, 13),
                Arguments.arguments(Arrays.asList(3, 4, 5, 6), 10, 6));
    }

    static Stream<Arguments> supplyTestDataThrowsIllegalArgumentException() {
        return Stream.of(Arguments.arguments(Arrays.asList(0, 1, 2), 1),
                Arguments.arguments(Arrays.asList(-1, 5, 6), 1),
                Arguments.arguments(Arrays.asList(4, 5, 6), 0));
    }
}
