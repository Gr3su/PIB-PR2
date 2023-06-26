package ueb20.Aufgabe1;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ProcessNumbers {
    private static final String ERROR_FALSCHE_COLLECTION = "Uebergebener Parameter stellt keine moegliche Collection dar.";

    private AbstractQueue<Integer> queue;

    public ProcessNumbers(boolean fifo){
        if(fifo){
            queue = new ConcurrentLinkedQueue<>();
        }
        else{
            queue = new PriorityQueue<>();
        }
    }

    public Queue<Integer> getQueue(){
        return queue;
    }

    public static void main(String[] args) {
        //Auslesung welche Collection gewaehlt wird
        boolean fifo;
        if(args[0].equalsIgnoreCase("fifo")){
            fifo = true;
        }
        else if(args[0].equalsIgnoreCase("prio")){
            fifo = false;
        }
        else{
            throw new IllegalArgumentException(ERROR_FALSCHE_COLLECTION);
        }

        ProcessNumbers processNumbers = new ProcessNumbers(fifo);
        Random ran = new Random();
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        for (int i = 0; i < 10000; i++) {
            if (ran.nextInt(2) > 0) {
                int value = producer.produce();
                processNumbers.getQueue().add(value);
            }
            else {

                Integer value =  processNumbers.getQueue().poll() ;
                System.out.println("Entnommener Wert: " + value);
                if(value == null){
                    continue;
                }

                consumer.consume(value);

            }
        }
    }
}
