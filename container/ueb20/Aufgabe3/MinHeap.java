package ueb20.Aufgabe3;


import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * Implementierung eines MinHeaps mit einem Array fester Groesse.
 *
 * @param <E> Type der zu speichernden Elemente
 */
public class MinHeap<E  extends Comparable<E>> implements Queue<E> {
    //Error-Messages
    private static final String ERROR_UNSUPPORTED_OP = "Methode nicht unterstuetzt.";

    //Konstanten
    private static final int STANDARD_GROESSE = 10;

    //Attribute
    private E [] minHeap;
    private int size;

    /**
     * Konstruktor der ein initiales Array erstellt.
     *
     * @param tClass Typ der Elemente
     * @param heapGroesse Groesse des Arrays
     */
    @SuppressWarnings({"unchecked"})
    public MinHeap(Class<E> tClass, int heapGroesse){
        this.minHeap = (E []) Array.newInstance(tClass, heapGroesse);
        this.size = 0;
    }

    /**
     * Standard-Konstruktor der ein Array der Groesse STANDARD_GROESSE erstellt.
     *
     * @param tClass Typ der Elemente
     */
    public MinHeap(Class<E> tClass){
        this(tClass, STANDARD_GROESSE);
    }

    /**
     *
     * @return Wurzel des MinHeap.
     */
    @Override
    public E peek() {
        return minHeap[0];
    }

    /**
     * Fuegt ein Element in den MinHeap ein und stellt die MinHeap-Bedingungen wieder her.
     *
     * @param e the element to add
     * @return true wenn hinzugefuegt, false wenn nicht
     */
    @Override
    public boolean offer(E e) {
        if(size == minHeap.length){
            return false;
        }

        minHeap[size++] = e;
        int index = size - 1;
        int parentIndex = (index-1)/2;

        while(index != 0 &&
                minHeap[index].compareTo(minHeap[parentIndex]) < 0){
            swap(index, parentIndex);
            index = parentIndex;
        }

        return true;
    }

    /**
     * Entfernt die Wurzel des MinHeap und sorgt dafuer dass die MinHeap-Bedingungen wiederhergestellt werden.
     *
     * @return Wurzel des MinHeap
     */
    @Override
    public E poll() {
        if(size == 0){
            return null;
        }

        E storeValue = minHeap[0];
        minHeap[0] = minHeap[size - 1];
        minHeap[size--] = null;
        int index = 0;
        int swapIndex = 0;

        while(true){
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;

            if(leftChildIndex < size &&
                minHeap[leftChildIndex].compareTo(minHeap[index]) < 0){
                swapIndex = leftChildIndex;
            }
            if(rightChildIndex < size &&
                minHeap[rightChildIndex].compareTo(minHeap[index]) < 0 &&
                minHeap[rightChildIndex].compareTo(minHeap[leftChildIndex]) > 0){
                swapIndex = rightChildIndex;
            }
            if(swapIndex == index){
                break;
            }
            swap(index, swapIndex);
            index = swapIndex;
        }
        return storeValue;
    }

    /**
     * Hilfsmethode um die zwei Werte an Index a und b zu tauschen.
     *
     * @param a Index 1
     * @param b Index 2
     */
    private void swap(int a, int b){
        E storeValue = minHeap[a];
        minHeap[a] = minHeap[b];
        minHeap[b] = storeValue;
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

    /**
     * Gibt die Anzahl an Elementen im MinHeap zurueck
     *
     * @return Anzahl der Elemente
     */
    @Override
    public int size() {
        return size;
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
