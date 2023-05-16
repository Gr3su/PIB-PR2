package ueb17;
import static ueb17.ApplyAndPrint.applyAndPrint;

public class AnonymousClassesImplementation {
    public static void main(String[] args) {
        MyFunction quad = new MyFunction() {
            @Override
            public int apply(int x) {
                return x * x;
            }
        };

        MyFunction fac = new MyFunction() {
            @Override
            public int apply(int x) {
                if (x == 0) {
                    return 1;
                }
                return apply(x - 1) * x;
            }
        };

        MyFunction pot = new MyFunction() {
            @Override
            public int apply(int x) {
                int sum = 1;
                for(int i = 0; i < x + 1; i++){
                    sum *= x;
                }
                return sum;
            }
        };

        MyFunction fib = new MyFunction() {
            @Override
            public int apply(int x) {
                if(x <= 2){
                    return 1;
                }
                return apply(x - 1) + apply(x - 2);
            }
        };

        applyAndPrint(1, 10, quad);
        applyAndPrint(1, 10, fac);
        applyAndPrint(1, 9, pot);
        applyAndPrint(1, 10, fib);
    }
}
