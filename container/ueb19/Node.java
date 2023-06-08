package ueb19;

public class Node <E>{
    private E value;
    private Node<E> next;
    private Node<E> previous;

    public Node(E value, Node<E> next, Node<E> previous){
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public Node(E value){
        this(value, null, null);
    }

    public E getValue() {
        return value;
    }

    public Node<E> getNext() {
        return next;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }
}
