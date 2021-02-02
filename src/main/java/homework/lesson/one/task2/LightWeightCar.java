package homework.lesson.one.task2;

class LightWeightCar extends Car implements Moveable{

    @Override
    public void open() {  // сделал public
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}

