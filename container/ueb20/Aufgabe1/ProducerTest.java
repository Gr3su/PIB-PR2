package ueb20.Aufgabe1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProducerTest {
    private Producer producer;

    @BeforeEach
    void setUp() {
        producer = new Producer();
    }

    @Test
    void producer_produce_shouldReturnNumberWithinRange_0_1001() {
        int value = producer.produce();
        assertTrue(value >= 0 && value < 1001);
    }
}
