package third.lesson.homework.thread.safe.counter;

public class CounterApplication {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        for (int i = 0; i < 1_000; i++) {
            new Thread(()->{
                for (int j = 0; j < 1_000; j++) {
                    counter.incrementCounter();
                }
            }).start();
        }
        Thread.sleep(2_000);
        System.out.println(counter.getCounter());

    }

}
