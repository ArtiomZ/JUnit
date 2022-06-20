import org.example.PerimeterAndSquareException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test {
    CalcRectangle sut;

    @BeforeEach
    public void init() {
        System.out.println("test started");
        sut = new CalcRectangle();
    }

    @BeforeAll
    public static void started() {
        System.out.println("tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("test completed");
    }

    @BeforeAll
    public static void finishedAll() {
        System.out.println("tests completed");
    }

    @org.junit.jupiter.api.Test
    public void testPerimeter() throws PerimeterAndSquareException {
        double length = 5;
        double width = 4;
        double expected = 18;
        double result = sut.perimeterCalc(length, width);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    public void testSquare() throws PerimeterAndSquareException {
        double length = 12;
        double width = 10;
        double expected = 120;
        double result = sut.squareCalc(length, width);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    public void testIncorrectInputPerimeter() {
        double length = 4;
        double width = 0;
        var expected = PerimeterAndSquareException.class;
        assertThrows(expected, () -> sut.perimeterCalc(length, width));
    }

    @org.junit.jupiter.api.Test
    public void testIncorrectInputSquare() {
        double length = 0;
        double width = 4;
        var expected = PerimeterAndSquareException.class;
        assertThrows(expected, () -> sut.squareCalc(length, width));
    }


    @ParameterizedTest
    @MethodSource("comma")
    public void testInputCommaSquare(double length, double width, double expected) throws PerimeterAndSquareException {
        double result = sut.squareCalc(length, width);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> comma() {
        return Stream.of(Arguments.of(10.3, 5.7, 58.71),
                Arguments.of(3.25, 4.12, 13.39));
    }
}
