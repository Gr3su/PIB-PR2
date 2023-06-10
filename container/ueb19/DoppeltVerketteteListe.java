package ueb19;

import java.lang.reflect.Array;
import java.util.*;

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

        for(E item: this){
            if(item.equals(o)){
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {

        return new DVLIterator();
    }

    @Override
    public Object[] toArray() {
        throw new java.lang.UnsupportedOperationException();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        if(a == null){
            throw new NullPointerException();
        }

        try{
            if(a.length < size) {
                a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
            }

            int i = 0;
            for(E item: this){
                a[i++] = (T) item;
            }

            if(i < size - 1){
                a[i] = null;
            }

        }
        catch(Exception e){
            throw new ArrayStoreException(e.getMessage());
        }

        return a;
    }

    @Override
    public boolean add(E e) {
        if(e == null){
            throw new NullPointerException();
        }

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

        ListIterator<E> iterator = new DVLListIterator();
        while(iterator.hasNext()){
            if(iterator.next().equals(o)){
                remove(iterator.previousIndex());
                return true;
            }

        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if(c == null || c.size() == 0){
            return false;
        }

        for (E item : c) {
            if(item == null){
                throw new NullPointerException();
            }
            add(item);
        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new java.lang.UnsupportedOperationException();
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
        if(element == null){
            throw new NullPointerException();
        }

        Node<E> newNode;

        if(size == 0){
            newNode = new Node<>(element, null, null);
            head = newNode;
            tail = newNode;
        }
        else if(index == size){
            newNode = new Node<>(element, null, tail);
            tail = newNode;
        }
        else{
            Node<E> currentNode = head;
            for(int i = 0; i < index; i++){
                currentNode = currentNode.getNext();
            }

            Node<E> previous = currentNode.getPrevious();
            newNode = new Node<>(element, currentNode, previous);
            previous.setNext(newNode);
            currentNode.setPrevious(newNode);
        }

        size++;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size){
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

        size--;
        return currentNode.getValue();
    }

    @Override
    public int indexOf(Object o) {

        int index = 0;
        for(E item: this){
            if(item.equals(o)){
                return index;
            }
            index++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new DVLListIterator();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new java.lang.UnsupportedOperationException();
    }

    private class DVLIterator implements Iterator<E>{
        protected Node<E> iteratorPos;
        protected Node<E> lastIteratorPos;
        protected int index;
        protected int lastIndex;

        public DVLIterator(){
            this.iteratorPos = head;
            this.lastIteratorPos = null;
            this.index = 0;
            this.lastIndex = -1;
        }

        @Override
        public boolean hasNext() {
            return iteratorPos != null;
        }

        @Override
        public E next() {
            if(hasNext()){
                E value = iteratorPos.getValue();
                lastIteratorPos = iteratorPos;
                iteratorPos = iteratorPos.getNext();
                lastIndex = index;
                index++;

                return value;
            }

            throw new NoSuchElementException();
        }

        @Override
        public void remove(){
            if(lastIndex == -1 || lastIteratorPos == null){
                throw new IllegalArgumentException();
            }
            DoppeltVerketteteListe.this.remove(lastIndex);
            lastIndex = -1;
            lastIteratorPos = null;
        }
    }

    private class DVLListIterator extends DVLIterator implements ListIterator<E>{

        @Override
        public boolean hasPrevious() {
            return iteratorPos.getPrevious() != null;
        }

        @Override
        public E previous() {
            if(hasPrevious()){
                E value = iteratorPos.getValue();
                iteratorPos = iteratorPos.getPrevious();
                index--;

                return value;
            }

            throw new NoSuchElementException();
        }

        @Override
        public int nextIndex() {
            return index == size ? size : index + 1;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void set(E e) {
            if(lastIndex == -1 || lastIteratorPos == null){
                throw new IllegalArgumentException();
            }

            lastIteratorPos.setValue(e);
        }

        @Override
        public void add(E e) {
            DoppeltVerketteteListe.this.add(index, e);
        }
    }
}
