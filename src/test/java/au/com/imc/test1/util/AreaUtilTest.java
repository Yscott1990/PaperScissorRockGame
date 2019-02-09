package au.com.imc.test1.util;

import au.com.imc.test1.shape.Circle;
import au.com.imc.test1.shape.Rectangle;
import au.com.imc.test1.shape.Shape;
import au.com.imc.test1.shape.Triangle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AreaUtilTest {

    private Shape circle, rectangle, triangle;

    @Before
    public void init() {
        circle = new Circle(2.0d);
        rectangle = new Rectangle(2.0, 3.0);
        triangle = new Triangle(2.0, 3.0);
    }

    @Test
    public void calculateArea() {
        assertEquals(12.56, AreaUtil.calculateArea(circle), 0.0);
        assertEquals(6.0, AreaUtil.calculateArea(rectangle),0.0);
        assertEquals(3.0, AreaUtil.calculateArea(triangle), 0.0);
    }
}
