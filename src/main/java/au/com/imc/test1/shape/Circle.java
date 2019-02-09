package au.com.imc.test1.shape;

import au.com.imc.test1.visitor.Visitor;

public class Circle implements Shape {
    private double radis, area;

    public Circle(double radis) {
        this.radis = radis;
    }

    public void setArea(final double area) {
        this.area = area;
    }

    public double getRadis() {
        return radis;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double getArea() {
        return area;
    }
}
