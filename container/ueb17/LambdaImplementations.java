package ueb17;
import static ueb17.ApplyAndPrint.applyAndPrint;

/**
 * Implementierung der Funktionen Quadrieren, Fakultaet, Potenz und Fibonacci Folge
 * als Lambda Ausdruecke.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 20.05.2023
 */
public class LambdaImplementations {
    private static final String ERROR_NOT_NAT = "x muss eine natuerliche Zahl sein.";
    private static final int MIN_TEST_VALUE = 1;
    private static final int MAX_TEST_VALUE = 9;
    private final MyFunction quadrieren;
    private final MyFunction fakultaet;
    private final MyFunction potenz;
    private final MyFunction fibonacci;

    public LambdaImplementations(){
        quadrieren = (x) ->{
            if(x < 0){
                throw new IllegalArgumentException(ERROR_NOT_NAT);
            }
            return x * x;};
        fakultaet = (x) -> {
            if(x < 0){
                throw new IllegalArgumentException(ERROR_NOT_NAT);
            }
            int sum = 1;
            for(int i = 1; i <= x; i++){
                sum *= i;
            }
            return sum;
        };
        potenz = (x) -> {
            if(x < 0){
                throw new IllegalArgumentException(ERROR_NOT_NAT);
            }
            int sum = x;
            for(int i = 0; i < x; i++){
                sum *= x;
            }
            return sum;
        };
        fibonacci = (x) -> {
            if(x < 0){
                throw new IllegalArgumentException(ERROR_NOT_NAT);
            }
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

    /**
     * Aufruf der applyAndPrint Methode mit den einzelnen Lambda Ausdruecken.
     *
     * @param args Nicht genutzt.
     */
    public static void main(String[] args) {
        LambdaImplementations lam = new LambdaImplementations();

        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, lam.quadrieren);
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, lam.fakultaet);
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, lam.potenz);
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, lam.fibonacci);
    }
}
