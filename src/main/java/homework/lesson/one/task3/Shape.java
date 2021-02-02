package homework.lesson.one.task3;

public abstract class Shape {

    protected double area;
    protected double perimeter;

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    protected abstract void calculateArea();
    protected abstract void calculatePerimeter();
}
