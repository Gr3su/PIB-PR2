package ueb17;
import static ueb17.ApplyAndPrint.applyAndPrint;

public abstract class StaticNestedImplementation {

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
        applyAndPrint(1, 10, new quad());
        applyAndPrint(1, 10, new fac());
        applyAndPrint(1, 9, new pot());
        applyAndPrint(1, 10, new fib());
    }
}
