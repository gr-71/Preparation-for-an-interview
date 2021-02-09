package third.lesson.homework.thread.safe.counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private final Lock lock;
    private int counter;

    public Counter() {
        this.lock = new ReentrantLock();
    }

    public int getCounter() {
        return counter;
    }

    public void incrementCounter(){
        try{
            lock.lock();
            counter++;
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
