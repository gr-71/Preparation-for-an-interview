package homework.lesson.one.task3;

public class Square extends Shape{

    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    protected void calculateArea() {
        area = side * side;
    }

    @Override
    protected void calculatePerimeter() {
        perimeter = 4 * side;
    }
}
