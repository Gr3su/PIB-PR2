package ueb17;
import static ueb17.ApplyAndPrint.applyAndPrint;

public class Pot implements MyFunction{
    private static final int MIN_TEST_VALUE = 1;
    private static final int MAX_TEST_VALUE = 10;

    @Override
    public int apply(int x){
        int sum = 1;
        for(int i = 0; i < x + 1; i++){
            sum *= x;
        }
        return sum;
    }

    public static void main(String[] args) {
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, new Pot());
    }
}
