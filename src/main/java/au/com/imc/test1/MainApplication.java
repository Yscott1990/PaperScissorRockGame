package au.com.imc.test1;

import au.com.imc.test1.shape.Circle;
import au.com.imc.test1.shape.Rectangle;
import au.com.imc.test1.shape.Shape;
import au.com.imc.test1.shape.Triangle;
import au.com.imc.test1.visitor.AreaVisitor;
import au.com.imc.test1.visitor.Visitor;

public class MainApplication {
    public static void main(String[] args) {
        final Shape circle = new Circle(2.0d);
        final Shape rectangle = new Rectangle(2.0d, 2.0d);
        final Shape triangle = new Triangle(2.0d, 3.0d);
        final Visitor areaVisitor = new AreaVisitor();

        circle.accept(areaVisitor);
        rectangle.accept(areaVisitor);
        triangle.accept(areaVisitor);

        System.out.println("circle area is : " + circle.getArea());
        System.out.println("rectangle area is : " + rectangle.getArea());
        System.out.println("triangle area is : " + triangle.getArea());
    }
}
