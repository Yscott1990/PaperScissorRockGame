package au.com.imc.test1.shape;

import au.com.imc.test1.visitor.Visitor;

public interface Shape {
    void accept(Visitor visitor);

    double getArea();
}
