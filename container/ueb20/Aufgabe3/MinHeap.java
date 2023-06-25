package ueb20.Aufgabe3;


import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class MinHeap<E  extends Comparable<E>> implements Queue<E> {
    //Error-Messages
    private static final String ERROR_UNSUPPORTED_OP = "Methode nicht unterstuetzt.";

    //Konstanten
    private static final int STANDARD_GROESSE = 10;

    //Attribute
    private E [] minHeap;
    private int size;

    @SuppressWarnings({"unchecked"})
    public MinHeap(int heapGroesse){
        this.minHeap = (E []) new Object[heapGroesse];
        this.size = 0;
    }

    public MinHeap(){
        this(STANDARD_GROESSE);
    }

    @Override
    public E peek() {
        return minHeap[0];
    }

    @Override
    public boolean offer(E e) {
        if(size == minHeap.length){
            return false;
        }
        int insertPos = size;
        minHeap[size++] = e;

        while(  insertPos != 0 &&
                minHeap[(insertPos-1) / 2].compareTo(e) >= 0){
            E storeValue = minHeap[(insertPos-1) / 2];
            minHeap[(insertPos - 1) / 2] = minHeap[insertPos];
            minHeap[insertPos] = storeValue;
            insertPos = (insertPos - 1) / 2;
        }

        return true;
    }

    @Override
    public E poll() {
        if(size == 0){
            return null;
        }

        E storeValue = minHeap[0];
        minHeap[0] = minHeap[size];
        minHeap[size--] = null;
        int index = 0;

        while(  index*2+1 < minHeap.length &&
                index*2+2 < minHeap.length &&)
    }

    @Override
    public E remove() {
        throw new UnsupportedOperationException(ERROR_UNSUPPORTED_OP);
    }

    @Override
    public E element() {
        throw new UnsupportedOperationException(ERROR_UNSUPPORTED_OP);
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException(ERROR_UNSUPPORTED_OP);
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException(ERROR_UNSUPPORTED_OP);
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException(ERROR_UNSUPPORTED_OP);
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException(ERROR_UNSUPPORTED_OP);
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException(ERROR_UNSUPPORTED_OP);
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException(ERROR_UNSUPPORTED_OP);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException(ERROR_UNSUPPORTED_OP);
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException(ERROR_UNSUPPORTED_OP);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException(ERROR_UNSUPPORTED_OP);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException(ERROR_UNSUPPORTED_OP);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException(ERROR_UNSUPPORTED_OP);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException(ERROR_UNSUPPORTED_OP);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException(ERROR_UNSUPPORTED_OP);
    }
}
