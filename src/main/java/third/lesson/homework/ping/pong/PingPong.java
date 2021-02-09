package third.lesson.homework.ping.pong;

public class PingPong {

    private int counter;
    private Status status;

    synchronized void ping(){
        status = Status.PING;
        notify();
        while (status == Status.PING){
            try {
                wait();
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        try{
            Thread.sleep(500);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println(++counter + " PING");
    }

    synchronized void pong(){
        status = Status.PONG;
        notify();
        while (status == Status.PONG){
            try {
                wait();
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        try{
            Thread.sleep(500);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println(++counter + " PONG");
    }

}
