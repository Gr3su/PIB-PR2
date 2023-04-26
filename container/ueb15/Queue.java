/**
 * Interface fuer Queues.
 *
 * @author STL
 * @version 20.01.2023
 */

public interface Queue {
    public void addLast (Object o) ; // Objekt hinten anfuegen
    public Object removeFirst(); //erstes Element entfernen und
    //eine Referenz darauf zurueck geben.
    public Object get(int i ) ; // Das i-te Element zurueck geben
    public boolean empty(); //Testen, die Queue leer ist
    public boolean full(); //Testen, ob noch Elemente einfuegbar sind
    public int size(); //Anzahl eingefuegter Elemente
    public int getCapacity(); //Anzahl der moeglich einzufuegenden Elemente
}