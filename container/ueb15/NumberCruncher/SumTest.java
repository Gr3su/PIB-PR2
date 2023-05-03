package ueb15.NumberCruncher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumTest {
    @Test
    public void testCrunch1() {
        float[] arr = {1.0f, 2.0f, 3.0f, 4.0f};
        Sum s = new Sum();
        s.crunch(arr);
        Assertions.assertArrayEquals(new float[]{1.0f, 3.0f, 6.0f, 10.0f}, arr);
    }

    @Test
    public void testCrunch2() {
        float[] arr = {0.0f, 0.0f, 0.0f, 0.0f};
        Sum s = new Sum();
        s.crunch(arr);
        Assertions.assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f, 0.0f}, arr);
    }

    @Test
    public void testCrunch3() {
        float[] arr = {2.5f, 5.0f, 7.5f, 10.0f};
        Sum s = new Sum();
        s.crunch(arr);
        Assertions.assertArrayEquals(new float[]{2.5f, 7.5f, 15.0f, 25.0f}, arr);
    }

    @Test
    public void testCrunch4() {
        float[] arr = {1.0f, -1.0f, 1.0f, -1.0f};
        Sum s = new Sum();
        s.crunch(arr);
        Assertions.assertArrayEquals(new float[]{1.0f, 0.0f, 1.0f, 0.0f}, arr);
    }

    @Test
    public void testCrunch5() {
        float[] arr = {1.0f};
        Sum s = new Sum();
        s.crunch(arr);
        Assertions.assertArrayEquals(new float[]{1.0f}, arr);
    }

    @Test
    public void testCrunch6() {
        float[] arr = {0.1f, 0.2f, 0.3f, 0.4f};
        Sum s = new Sum();
        s.crunch(arr);
        float[] expected = {0.1f, 0.3f, 0.6f, 1.0f};
        Assertions.assertArrayEquals(expected, arr, 0.0001f);
    }
}

