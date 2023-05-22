package ueb17;
import static ueb17.ApplyAndPrint.applyAndPrint;

/**
 * Implementierung der Funktionen Quadrieren, Fakultaet, Potenz und Fibonacci Folge
 * als Static nested classes.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 20.05.2023
 */
public abstract class StaticNestedImplementation {
    private static final int MIN_TEST_VALUE = 1;
    private static final int MAX_TEST_VALUE = 10;

    public static class Quadrieren implements MyFunction{
        @Override
        public int apply(int x){
            return x * x;
        }
    }

    public static class Fakultaet implements MyFunction{
        @Override
        public int apply(int x){
            if (x == 0) {
                return 1;
            }
            return apply(x - 1) * x;
        }
    }

    public static class Potenz implements MyFunction{
        @Override
        public int apply(int x){
            int sum = 1;
            for(int i = 0; i < x + 1; i++){
                sum *= x;
            }
            return sum;

        }
    }

    public static class Fibonacci implements MyFunction{
        @Override
        public int apply(int x){
            if(x <= 2){
                return 1;
            }
            return apply(x - 1) + apply(x - 2);
        }
    }

    /**
     * Aufruf der applyAndPrint Methode mit den nested classes.
     *
     * @param args Kein Nutzen
     */
    public static void main(String[] args) {
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, new Quadrieren());
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, new Fakultaet());
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, new Potenz());
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, new Fibonacci());
    }
}
