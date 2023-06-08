package ueb19;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DoppeltVerketteteListe <E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoppeltVerketteteListe(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node<? extends E> iteratorPoint = head;

        while(iteratorPoint != null){
            if(iteratorPoint.getValue().equals(o)){
                return true;
            }

            iteratorPoint = iteratorPoint.getNext();
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if(a == null){
            throw new NullPointerException();
        }

        try{
            if(a.length < size) {
                a = (T[]) new Object[size];
            }

            Node currentNode = head;
            int i = 0;

            while(currentNode != null){
                a[i] = (T) currentNode.getValue();
                currentNode = currentNode.getNext();
                i++;
            }

            if(i < size - 1){
                a[i] = null;
            }

        }
        catch(Exception e){
            throw new ArrayStoreException();
        }

        return a;
    }

    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>(e);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            Node<E> lastTail = tail;
            tail = newNode;
            lastTail.setNext(newNode);
            newNode.setPrevious(lastTail);
        }

        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(o == null){
            throw new NullPointerException();
        }

        Node<E> iteratorPos = head;

        while(iteratorPos != null){
            if(iteratorPos.getValue().equals(o)){
                Node<E> previous = iteratorPos.getPrevious();
                Node<E> next = iteratorPos.getNext();

                previous.setNext(next);
                next.setPrevious(previous);
                return true;
            }

            iteratorPos = iteratorPos.getNext();
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {

        for (E item : c) {
            add(item);
        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node<E> currentNode = head;
        for(int i = 0; i < index; i++){
            currentNode = currentNode.getNext();
        }

        return currentNode.getValue();
    }

    @Override
    public E set(int index, E element) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node<E> currentNode = head;
        E previousValue;

        for(int i = 0; i < index; i++){
            currentNode = currentNode.getNext();
        }
        previousValue = currentNode.getValue();
        currentNode.setValue(element);

        return previousValue;
    }

    @Override
    public void add(int index, E element) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        Node<E> currentNode = head;
        for(int i = 0; i < index; i++){
            currentNode = currentNode.getNext();
        }
        if(currentNode == null){
            tail.setNext(new Node<E>(element, null, tail));
            tail = currentNode;
        }
        else{
            Node<E> previous = currentNode.getPrevious();
            Node<E> next = currentNode.getNext();
            new Node<>(element, next, previous);
            if(previous != null) {
                previous.setNext(next);
            }
            if(next != null) {
                next.setPrevious(previous);
            }
        }
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        Node<E> currentNode = head;
        for(int i = 0; i < index; i++){
            currentNode = currentNode.getNext();
        }

        Node<E> previous = currentNode.getPrevious();
        Node<E> next = currentNode.getNext();
        if(previous != null){
            previous.setNext(next);
        }
        if(next != null){
            next.setPrevious(previous);
        }

        return currentNode.getValue();
    }

    @Override
    public int indexOf(Object o) {
        Node<E> currentNode = head;
        int index = 0;

        while(currentNode != null){
            if(currentNode.getValue().equals(o)){
                return index;
            }

            index++;
            currentNode = currentNode.getNext();
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    public static void main(String[] args) {
        DoppeltVerketteteListe<String> dp = new DoppeltVerketteteListe<>();
        dp.add("Hallo");
        dp.toArray(new String[0]);
    }
}
