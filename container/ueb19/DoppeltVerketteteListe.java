package ueb19;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Doppelt verkettete Liste, die ihre Werte als Objekte der Klasse Node speichert.
 *
 * @param <E> Oberklasse der zu speichernden Werte
 */
public class DoppeltVerketteteListe <E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Initialisierung der Liste.
     */
    public DoppeltVerketteteListe(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Gibt die aktuelle Anzahl an Elementen in der Liste zurueck.
     *
     * @return size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Ob Liste aktuell keine Elemente enthaelt.
     *
     * @return Liste leer (true) - Liste befuellt (false)
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Gibt zurueck ob Element in Liste enthalten.
     *
     * @param o Instanz die gesucht werden soll.
     * @return Ob Instanz enthalten
     */
    @Override
    public boolean contains(Object o) {

        for(E item: this){
            if(item.equals(o)){
                return true;
            }
        }

        return false;
    }

    /**
     * Einfacher Iterator.
     *
     * @return Iterator
     */
    @Override
    public Iterator<E> iterator() {

        return new DVLIterator();
    }

    @Override
    public Object[] toArray() {
        throw new java.lang.UnsupportedOperationException();
    }

    /**
     * Erstellt mit den Elementen der Liste ein Array.
     *
     * @param a Das Array in das die Elemente der List gespeichert werden, wenn es gross genug ist.
     *          Ansonsten wird eins mit dem selben Runtime Type und der passenden groesse erstellt.
     *
     * @return Array mit den Elementen der Liste
     * @param <T> Typ des Arrays
     *
     * @throws NullPointerException Wenn Array gleich null ist
     * @throws ArrayStoreException Wenn Fehler beim erstellen des Arrays auftritt
     */
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

    /**
     * Fuegt ein Element ans Ende der Liste an.
     *
     * @param e Element das angehangen werden soll.
     * @return Immer true, da Element immer angehangen wird und sich Liste somit aendert.
     *
     * @throws NullPointerException Wenn Element null ist
     */
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

    /**
     * Loescht erstes Erscheinen eines ELement aus der Liste.
     *
     * @param o Zu loeschendes Element
     * @return Element gefunden und geloescht (true) sonst (false)
     *
     * @throws NullPointerException Wenn Objekt null ist
     */
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

    /**
     * Fuegt alle Elemente einer uebergebenen Collection zur Liste hinzu.
     *
     * @param c Collection mit den hinzuzufuegenden Elementen
     * @return Wenn Elemente hinzugefuegt (true) sonst (false)
     *
     * @throws NullPointerException Wenn ein Element aus Collecction null ist
     */
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

    /**
     * Leert die Liste.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Gibt das Element an Stelle index zurueck.
     *
     * @param index Index des Elements
     * @return Gefundenes Element
     *
     * @throws IndexOutOfBoundsException Wenn Index <0 oder >=Anzahl der Elemente
     */
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

    /**
     * Aendert Element an Stelle index.
     *
     * @param index index des zu ersetzenden Elements
     * @param element Element das gespeichert werden soll
     * @return vorheriges Element an Stelle index
     *
     * @throws IndexOutOfBoundsException Wenn index <0 oder >=Anzahl der Elemente
     */
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

    /**
     * Fuegt Element an Stelle index neu ein.
     *
     * @param index index wo Element eingefuegt werden soll
     * @param element element das gespeichert werden soll
     *
     * @throws IndexOutOfBoundsException Wenn index <0 oder >Anzahl der Elemente
     * @throws NullPointerException Wenn element null ist
     */
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

    /**
     * Entfernt den Knoten an Stelle index
     *
     * @param index index vom zu loeschenden Element
     * @return Wert des geloeschten Knoten
     */
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
        else{
            head = next;
        }
        if(next != null){
            next.setPrevious(previous);
        }
        else{
            tail = previous;
        }

        size--;
        return currentNode.getValue();
    }

    /**
     * Sucht Element und gibt seinen Index zurueck.
     *
     * @param o Element das gesucht werden soll
     * @return Index des Elements
     */
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
