package ueb15;
/**
 * Interface fuer Queues.
 *
 * @author STL
 * @version 20.01.2023
 */

public interface Queue {
    void addLast (Object o) ; // Objekt hinten anfuegen
    Object removeFirst(); //erstes Element entfernen und
    //eine Referenz darauf zurueck geben.
    Object get(int i ) ; // Das i-te Element zurueck geben
    boolean empty(); //Testen, die Queue leer ist
    boolean full(); //Testen, ob noch Elemente einfuegbar sind
    int size(); //Anzahl eingefuegter Elemente
    int getCapacity(); //Anzahl der moeglich einzufuegenden Elemente

}