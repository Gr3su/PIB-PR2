package ueb20.Aufgabe1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class ConsumerTest {
    private Consumer consumer;

    @BeforeEach
    void setUp() {
        consumer = new Consumer();
    }

    @Test
    void consumer_is_checksum_with_12345_expected_15() {
        consumer.consume(12345);

        assertEquals(15, consumer.getQuersumme(12345));
    }

    @Test
    void consumer_is_checksum_with_123456_expected_21() {
        consumer.consume(123456);

        assertEquals(21, consumer.getQuersumme(123456));
    }
    @Test
    void consumer_numberOfOccurenzes_with_1_expected_1() {
        consumer.consume(12345);

        assertEquals(1, consumer.numberOfOccurences(15));
    }

    @Test
    void consumer_numberOfOccurenzes_with_2_values_similar_expected_2() {
        consumer.consume(12345);
        consumer.consume(12345);

        assertEquals(2, consumer.numberOfOccurences(15));
    }

    @Test
    void consumer_numberOfOccurenzes_with_0_expected_0() {

        assertEquals(0, consumer.numberOfOccurences(15));
    }

    @Test
    void consumer_numberOfDifferentResults_with_3_values_expected_3() {
        consumer.consume(12345);
        consumer.consume(67890);
        consumer.consume(11111);

        assertEquals(3, consumer.numberOfDifferentResults());
    }

    @Test
    void consumer_numberOfDifferentResults_with_4_values_2_similar_expected_3() {
        consumer.consume(12);
        consumer.consume(21);
        consumer.consume(123);
        consumer.consume(6789);


        assertEquals(3, consumer.numberOfDifferentResults());
    }

    @Test
    void consumer_numberOfDifferentResults_with_0_values_expected_0() {

        assertEquals(0, consumer.numberOfDifferentResults());
    }


    @Test
    void consumer_getCrossTotalsAscending_with_123_456_789_expected_6_15_24() {
        consumer.consume(123);
        consumer.consume(456);
        consumer.consume(789);

        TreeSet<Integer> expectedCrossTotals = new TreeSet<>();
        expectedCrossTotals.add(6);
        expectedCrossTotals.add(24);
        expectedCrossTotals.add(15);

        assertEquals(expectedCrossTotals, consumer.getCrossTotalsAscending());
    }

    @Test
    void consumer_getCrossTotalsAscending_with_123_456_789_111_942_expected_3_6_15_24() {
        consumer.consume(123);
        consumer.consume(456);
        consumer.consume(789);
        consumer.consume(111);
        consumer.consume(942);


        TreeSet<Integer> expectedCrossTotals = new TreeSet<>();
        expectedCrossTotals.add(6);
        expectedCrossTotals.add(24);
        expectedCrossTotals.add(15);
        expectedCrossTotals.add(3);

        assertEquals(expectedCrossTotals, consumer.getCrossTotalsAscending());
    }

    @Test
    void consumer_getCrosstotalsDescending_with_123_456_789_expected_24_15_6() {
        consumer.consume(123);
        consumer.consume(456);
        consumer.consume(789);

        TreeSet<Integer> expectedCrossTotals = new TreeSet<>(Collections.reverseOrder());
        expectedCrossTotals.add(15);
        expectedCrossTotals.add(24);
        expectedCrossTotals.add(6);

        assertEquals(expectedCrossTotals, consumer.getCrosstotalsDescending());
    }

    @Test
    void consumer_getCrosstotalsDescending_with_Minus_123_456_789_expected_24_15_6() {
        consumer.consume(-123);
        consumer.consume(-456);
        consumer.consume(-789);

        TreeSet<Integer> expectedCrossTotals = new TreeSet<>(Collections.reverseOrder());
        expectedCrossTotals.add(-15);
        expectedCrossTotals.add(-24);
        expectedCrossTotals.add(-6);

        assertEquals(expectedCrossTotals, consumer.getCrosstotalsDescending());
    }

    @Test
    void consumer_getTimestampsForResult_with_12345_expected_5_timestamps(){
        consumer.consume(12345);

        int comparison = 5;

        assertEquals(comparison, consumer.getTimestampsForResult(15).size());
    }

    @Test
    void consumer_getTimestampsForResult_with_1_expected_1_timestamp(){
        consumer.consume(1);

        int comparison = 1;

        assertEquals(comparison, consumer.getTimestampsForResult(1).size());
    }
}