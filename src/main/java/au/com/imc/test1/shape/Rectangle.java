package au.com.imc.test1.shape;

import au.com.imc.test1.visitor.Visitor;

public class Rectangle implements Shape {
    private double x, y, area;

    public Rectangle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public double getArea() {
        return area;
    }
}
