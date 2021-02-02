package homework.lesson.one.task2;

class Lorry extends Car implements Moveable, Stopable{ // сделал, чтобы интерфейсы Moveable, Stopable имплементились

    // добавил этот метод от родителя Car
    @Override
    public void open(){
        System.out.println("The lorry is open");
    }

    public void move(){
        System.out.println("Car is moving");
    }
    public void stop(){
        System.out.println("Car is stop");
    }
}
