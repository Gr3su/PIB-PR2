package ueb15.NumberCruncher;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AverageTest {

    @Test
    public void testCrunchWithEmptyArray() {
        float[] values = new float[]{};
        Average average = new Average();
        average.crunch(values);
        assertArrayEquals(values, new float[]{});
    }

    @Test
    public void testCrunchWithSingleValue() {
        float[] values = new float[]{1.0f};
        Average average = new Average();
        average.crunch(values);
        assertEquals(1.0f, values[0]);
    }

    @Test
    public void testCrunchWithTwoEqualValues() {
        float[] values = new float[]{2.5f, 2.5f};
        Average average = new Average();
        average.crunch(values);
        assertEquals(2.5f, values[1]);
    }

    @Test
    public void testCrunchWithTwoDifferentValues() {
        float[] values = new float[]{1.5f, 2.5f};
        Average average = new Average();
        average.crunch(values);
        assertEquals(2.0f, values[1]);
    }

    @Test
    public void testCrunchWithThreeValues() {
        float[] values = new float[]{1.0f, 2.0f, 3.0f};
        Average average = new Average();
        average.crunch(values);
        assertEquals(2.0f, values[2]);
    }

    @Test
    public void testCrunchWithNegativeValues() {
        float[] values = new float[]{-2.0f, 4.0f, -6.0f};
        Average average = new Average();
        average.crunch(values);
        assertEquals(-1.333333f, values[1], 0.0001);
    }
}

