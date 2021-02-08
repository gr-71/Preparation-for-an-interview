package third.lesson.homework.ping.pong;

public class PingPongApplication {

    public static void main(String[] args) {

        PingPong pingPong = new PingPong();
        Thread t1 = new Thread(() -> {
            while (true){
                pingPong.ping();
            }
        });
        Thread t2 = new Thread(() -> {
            while (true){
                pingPong.pong();
            }
        });
        t1.start();
        t2.start();
    }
}
