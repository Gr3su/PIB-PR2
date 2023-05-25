package ueb17;
import org.junit.runner.manipulation.NoTestsRemainException;

import static ueb17.ApplyAndPrint.applyAndPrint;

/**
 * Implementierung der Funktionen Quadrieren, Fakultaet, Potenz und Fibonacci als
 * anonyme Klassen.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 20.05.2023
 */
public class AnonymousClassesImplementation {
    private static final String ERROR_NOT_NAT = "x muss eine natuerliche Zahl sein.";
    private static final int MIN_TEST_VALUE = 1;
    private static final int MAX_TEST_VALUE = 9;

    private final MyFunction quadrieren;
    private final MyFunction fakultaet;
    private final MyFunction potenz;
    private final MyFunction fibonacci;

    public AnonymousClassesImplementation(){
        quadrieren = new MyFunction() {
            @Override
            public int apply(int x) {
                if(x < 0){
                    throw new IllegalArgumentException(ERROR_NOT_NAT);
                }

                return x * x;
            }
        };

        fakultaet = new MyFunction() {
            @Override
            public int apply(int x) {
                if(x < 0){
                    throw new IllegalArgumentException(ERROR_NOT_NAT);
                }
                if (x == 0) {
                    return 1;
                }
                return apply(x - 1) * x;
            }
        };

        potenz = new MyFunction() {
            @Override
            public int apply(int x) {
                if(x < 0){
                    throw new IllegalArgumentException(ERROR_NOT_NAT);
                }
                int sum = x;
                for(int i = 0; i < x; i++){
                    sum *= x;
                }
                return sum;
            }
        };

        fibonacci = new MyFunction() {
            @Override
            public int apply(int x) {
                if(x < 0){
                    throw new IllegalArgumentException(ERROR_NOT_NAT);
                }
                if(x <= 2){
                    return 1;
                }
                return apply(x - 1) + apply(x - 2);
            }
        };
    }

    public MyFunction getQuadrieren() {
        return quadrieren;
    }

    public MyFunction getFakultaet() {
        return fakultaet;
    }

    public MyFunction getPotenz() {
        return potenz;
    }

    public MyFunction getFibonacci() {
        return fibonacci;
    }

    public static void main(String[] args) {
        AnonymousClassesImplementation anom = new AnonymousClassesImplementation();

        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, anom.quadrieren);
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, anom.fakultaet);
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, anom.potenz);
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, anom.fibonacci);
    }
}
