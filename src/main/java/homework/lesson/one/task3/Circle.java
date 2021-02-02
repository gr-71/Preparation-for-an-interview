package homework.lesson.one.task3;

public class Circle extends Shape{

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    protected void calculateArea() {
        area = Math.PI * radius;
    }

    @Override
    protected void calculatePerimeter() {
        perimeter = 2.0 * Math.PI * radius;
    }
}
