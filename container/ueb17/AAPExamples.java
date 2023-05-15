package ueb17;

public abstract class AAPExamples {
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
            int sum = 0;
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
    }
}
