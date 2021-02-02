package homework.lesson.one.task3;

public class Triangle extends Shape{

    private int a, b, c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    @Override
    protected void calculateArea() {
        calculatePerimeter();
        // Считаем площадь треугольника по формуле Герона:
        area = Math.sqrt(perimeter / 2.0 * (perimeter / 2.0 - a) * (perimeter / 2.0 - b) * (perimeter / 2.0 - c));
    }

    @Override
    protected void calculatePerimeter() {
        perimeter = a + b + c;
    }
}
