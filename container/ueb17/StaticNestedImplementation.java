package ueb17;
import static ueb17.ApplyAndPrint.applyAndPrint;

public abstract class StaticNestedImplementation {
    private static final int MIN_TEST_VALUE = 1;
    private static final int MAX_TEST_VALUE = 10;

    private static class quad implements MyFunction{
        @Override
        public int apply(int x){
            return x * x;
        }
    }

    private static class fac implements MyFunction{
        @Override
        public int apply(int x){
            if (x == 0) {
                return 1;
            }
            return apply(x - 1) * x;
        }
    }

    private static class pot implements MyFunction{
        @Override
        public int apply(int x){
            int sum = 1;
            for(int i = 0; i < x + 1; i++){
                sum *= x;
            }
            return sum;

        }
    }

    private static class fib implements MyFunction{
        @Override
        public int apply(int x){
            if(x <= 2){
                return 1;
            }
            return apply(x - 1) + apply(x - 2);
        }
    }

    public static void main(String[] args) {
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, new quad());
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, new fac());
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, new pot());
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, new fib());
    }
}
