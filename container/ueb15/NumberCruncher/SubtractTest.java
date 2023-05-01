package ueb15.NumberCruncher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class SubtractTest {

    @Test
    public void testCrunch1() {
        float[] arr = {1.0f, 2.0f, 3.0f, 4.0f};
        Subtract s = new Subtract();
        s.crunch(arr);
        Assertions.assertArrayEquals(new float[]{1.0f, -1.0f, -4.0f, -8.0f}, arr);
    }

    @Test
    public void testCrunch2() {
        float[] arr = {0.0f, 0.0f, 0.0f, 0.0f};
        Subtract s = new Subtract();
        s.crunch(arr);
        Assertions.assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f, 0.0f}, arr);
    }

    @Test
    public void testCrunch3() {
        float[] arr = {2.5f, 5.0f, 7.5f, 10.0f};
        Subtract s = new Subtract();
        s.crunch(arr);
        Assertions.assertArrayEquals(new float[]{2.5f, -2.5f, -10.0f, -20.0f}, arr);
    }

    @Test
    public void testCrunch4() {
        float[] arr = {1.0f, -1.0f, 1.0f, -1.0f};
        Subtract s = new Subtract();
        s.crunch(arr);
        Assertions.assertArrayEquals(new float[]{1.0f, 2.0f, 1.0f, 2.0f}, arr);
    }

    @Test
    public void testCrunch5() {
        float[] arr = {1.0f};
        Subtract s = new Subtract();
        s.crunch(arr);
        Assertions.assertArrayEquals(new float[]{1.0f}, arr);
    }

    @Test
    public void testCrunch6() {
        float[] arr = {0.1f, 0.4f, 0.3f, 0.4f};
        Subtract s = new Subtract();
        s.crunch(arr);
        float[] expected = {0.1f, -0.3f, -0.6f, -1.0f};
        Assertions.assertArrayEquals(expected, arr, 0.0001f);
    }
}


