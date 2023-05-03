package ueb15.NumberCruncher;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DivideTest {

    @Test
    public void testCrunchWithEmptyArray() {
        float[] values = new float[]{};
        Divide divide = new Divide();
        divide.crunch(values);
        assertArrayEquals(values, new float[]{});
    }

    @Test
    public void testCrunchWithSingleValue() {
        float[] values = new float[]{1.0f};
        Divide divide = new Divide();
        divide.crunch(values);
        assertArrayEquals(new float[]{1.0f}, values);
    }

    @Test
    public void testCrunchWithTwoEqualValues() {
        float[] values = new float[]{2.5f, 2.5f};
        Divide divide = new Divide();
        divide.crunch(values);
        assertArrayEquals(new float[]{2.5f,1.0f}, values);
    }

    @Test
    public void testCrunchWithTwoDifferentValues() {
        float[] values = new float[]{1.5f, 2.5f};
        Divide divide = new Divide();
        divide.crunch(values);
        assertArrayEquals(new float[]{1.5f,1.66666f}, values,0.0001f);
    }

    @Test
    public void testCrunchWithThreeValues() {
        float[] values = new float[]{1.0f, 2.0f, 3.0f};
        Divide divide = new Divide();
        divide.crunch(values);
        assertArrayEquals(new float[]{1.0f,2.0f,3.0f}, values);
    }

    @Test
    public void testCrunchWithNegativeValues() {
        float[] values = new float[]{-2.0f, 4.0f, -6.0f};
        Divide divide = new Divide();
        divide.crunch(values);
        assertArrayEquals(new float[]{-2.0f,-0.6666666f,-6.0f}, values,0.00001f);
    }
}
