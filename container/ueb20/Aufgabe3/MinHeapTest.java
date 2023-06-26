package ueb20.Aufgabe3;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MinHeapTest {
    @Test
    public void testPeekWithEmptyHeap() {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class, 10);
        assertNull(heap.peek());
    }

    @Test
    public void testPeekWithNonEmptyHeap() {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class, 10);
        heap.offer(5);
        heap.offer(10);
        heap.offer(3);
        assertEquals(3, heap.peek());
    }

    @Test
    public void testPeekDoesNotRemoveElement() {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class, 10);
        heap.offer(5);
        heap.offer(10);
        heap.offer(3);
        heap.peek();
        assertEquals(3, heap.peek());
    }

    @Test
    public void testPollWithEmptyHeap() {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class, 10);
        assertNull(heap.poll());
    }

    @Test
    public void testPollWithNonEmptyHeap() {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class, 10);
        heap.offer(5);
        heap.offer(10);
        heap.offer(3);
        assertEquals(3, heap.poll());
        assertEquals(2, heap.size()); // Assuming size() method is implemented
    }

    @Test
    public void testPollRemovesElement() {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class, 10);
        heap.offer(5);
        heap.offer(10);
        heap.offer(3);
        heap.poll();
        assertEquals(5, heap.peek());
    }

    @Test
    public void testOfferIncreasesHeapSize() {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class, 10);
        heap.offer(5);
        heap.offer(10);
        heap.offer(3);
        assertEquals(3, heap.size()); // Assuming size() method is implemented
    }

    @Test
    public void testOfferAddsElementToHeap() {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class, 10);
        heap.offer(5);
        heap.offer(10);
        heap.offer(3);
        assertEquals(3, heap.peek());
    }

    @Test
    public void testOfferWithFullHeap() {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class, 3);
        heap.offer(5);
        heap.offer(10);
        heap.offer(3);
        assertFalse(heap.offer(7));
    }
}
