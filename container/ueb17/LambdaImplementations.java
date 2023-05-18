package ueb17;
import static ueb17.ApplyAndPrint.applyAndPrint;

public abstract class LambdaImplementations {
    private static final int MIN_TEST_VALUE = 1;
    private static final int MAX_TEST_VALUE = 10;

    public static void main(String[] args) {
        MyFunction quad = (x) -> x * x;
        MyFunction fac = (x) -> {
            int sum = 1;
            for(int i = 1; i <= x; i++){
                sum *= i;
            }
            return sum;
        };
        MyFunction pot = (x) -> {
            int sum = 1;
            for(int i = 0; i < x + 1; i++){
                sum *= x;
            }
            return sum;
        };
        MyFunction fib = (x) -> {
          int previous = 1;
          int next = 0;
          for(int i = 0; i < x; i++){
              int memory = next;
              next += previous;
              previous = memory;
          }
          return next;
        };

        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, quad);
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, fac);
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, pot);
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, fib);
    }
}
