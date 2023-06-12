package ueb19;

/**
 * Knoten fuer doppelt verkettete Listen.
 *
 * @param <E> Oberklasse der zu speichernden Werte
 */
public class Node <E>{
    private E value;
    private Node<E> next;
    private Node<E> previous;

    /**
     * Vollkonstruktor der den Wert setzt, sowie Vorgaenger und Nachfolger.
     *
     * @param value Zu speichernder Wert
     * @param next Naechster Knoten
     * @param previous Vorheriger Knoten
     */
    public Node(E value, Node<E> next, Node<E> previous){
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    /**
     * Konstruktor um lediglich Wert zu setzten, Vorgaenger und Nachfolger werden auf null gesetzt
     * @param value Zu speichernder Wert
     */
    public Node(E value){
        this(value, null, null);
    }

    /**
     *
     * @return value
     */
    public E getValue() {
        return value;
    }

    /**
     *
     * @return Nachfolger
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     *
     * @return Vorgaenger
     */
    public Node<E> getPrevious() {
        return previous;
    }

    /**
     * Setze wert
     * @param value value
     */
    public void setValue(E value) {
        this.value = value;
    }

    /**
     * Setze Nachfolger
     * @param next Nachfolger
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }

    /**
     * Setze Vorgaenger
     * @param previous Vorgaenger
     */
    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }
}
