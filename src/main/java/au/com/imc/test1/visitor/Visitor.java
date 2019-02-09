package au.com.imc.test1.visitor;

import au.com.imc.test1.shape.Circle;
import au.com.imc.test1.shape.Rectangle;
import au.com.imc.test1.shape.Triangle;

/**
 *
 */
public interface Visitor {
    void visit(Circle circle);

    void visit(Rectangle rectangle);

    void visit(Triangle triangle);
}
