package au.com.imc.test1.visitor;

import au.com.imc.test1.shape.Circle;
import au.com.imc.test1.shape.Rectangle;
import au.com.imc.test1.shape.Triangle;
import au.com.imc.test1.util.AreaUtil;

/**
 * AreaVisitor class compute and update the area of each shape sub-classes.
 */
public class AreaVisitor implements Visitor {

    public void visit(Circle circle) {
        circle.setArea(AreaUtil.calculateArea(circle));
    }

    public void visit(Rectangle rectangle) {
        rectangle.setArea(AreaUtil.calculateArea(rectangle));
    }

    public void visit(Triangle triangle) {
        triangle.setArea(AreaUtil.calculateArea(triangle));
    }
}
