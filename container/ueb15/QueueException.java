package ueb15;

public class QueueException extends RuntimeException{
    //Prompts
    private static final String ERROR_QUEUE_EMPTY       = "Warteschlange ist leer.\n";

    public QueueException(){
        super();
    }

    public QueueException(String msg){
        super(msg);
    }

    /**
     * Wirft Exception wenn Queue leer.
     *
     * @param q Zu ueberpruefende Queue.
     * @throws QueueException Wenn Queue leer.
     */
    public static void queueEmpty(Queue q){
        if(q.empty()){
            throw new QueueException(ERROR_QUEUE_EMPTY);
        }
    }
}
