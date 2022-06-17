import org.example.PerimeterAndSquareException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcRectangle {

    public double perimeterCalc(double length, double width) throws PerimeterAndSquareException {
        if (length <= 0 || width <= 0) {
            throw new PerimeterAndSquareException("Number is incorrect");
        }
        double result = 2 * (length + width);
        return CalcRectangle.round(result, 2);
    }

    public double squareCalc(double length, double width) throws PerimeterAndSquareException {
        if (length <= 0 || width <= 0) {
            throw new PerimeterAndSquareException("Number is incorrect");
        }
        double result = length * width;
        return CalcRectangle.round(result, 2);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
