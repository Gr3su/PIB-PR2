package ueb20.Aufgabe3;


import java.lang.reflect.Array;
import java.util.ArrayList;
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
    public MinHeap(Class<E> tClass, int heapGroesse){
        this.minHeap = (E []) Array.newInstance(tClass, heapGroesse);
        this.size = 0;
    }

    public MinHeap(Class<E> tClass){
        this(tClass, STANDARD_GROESSE);
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

    public void swap(int a, int b){
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
