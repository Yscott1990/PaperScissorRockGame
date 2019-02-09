package au.com.imc.test1.visitor;

import au.com.imc.test1.shape.Circle;
import au.com.imc.test1.shape.Rectangle;
import au.com.imc.test1.shape.Shape;
import au.com.imc.test1.shape.Triangle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AreaVisitorTest {

    private Visitor areaVisitor;
    private Shape circle;
    private Shape rectangle;
    private Shape triangle;

    @Before
    public void setUp() throws Exception {
        circle = new Circle(2.0d);
        rectangle = new Rectangle(2.0d, 3.0d);
        triangle = new Triangle(1.0, 2.0);
        areaVisitor = new AreaVisitor();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void visitCircle() {
        circle.accept(areaVisitor);
        assertEquals(12.56, circle.getArea(), 0.0);
    }

    @Test
    public void visitRectangle() {
        rectangle.accept(areaVisitor);
        assertEquals(6.0, rectangle.getArea(), 0.0);
    }

    @Test
    public void visitTriangle() {
        triangle.accept(areaVisitor);
        assertEquals(1.0, triangle.getArea(), 0.0);
    }
}