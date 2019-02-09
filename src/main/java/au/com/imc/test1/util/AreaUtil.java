package au.com.imc.test1.util;

import au.com.imc.test1.shape.Circle;
import au.com.imc.test1.shape.Rectangle;
import au.com.imc.test1.shape.Shape;
import au.com.imc.test1.shape.Triangle;

/**
 * AreaUtil class for calculating the area of each
 */
public final class AreaUtil {

    private static final double PI = 3.14;

    public static double calculateArea(Shape shape) {
        switch (shape.getClass().getSimpleName()) {
            case "Circle":
                return Math.pow(((Circle) shape).getRadis(), 2) * PI;
            case "Rectangle":
                return ((Rectangle) shape).getY() * ((Rectangle) shape).getX();
            case "Triangle":
                return ((Triangle) shape).getHeight() * ((Triangle) shape).getBase() / 2;
            default:
                throw new RuntimeException("unrecognized shape");
        }
    }
}
