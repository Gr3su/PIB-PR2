package ueb17;
import static ueb17.ApplyAndPrint.applyAndPrint;

/**
 * Implementierung der Berechnung der Fibonacci Folge als Top-Level Klasse mit dem
 * Interface MyFunction.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 20.05.2023
 */
public class Fibonacci implements MyFunction{
    private static final String ERROR_NOT_NAT = "x muss eine natuerliche Zahl sein.";
    private static final int MIN_TEST_VALUE = 1;
    private static final int MAX_TEST_VALUE = 10;

    @Override
    public int apply(int x){
        if(x < 0){
            throw new IllegalArgumentException(ERROR_NOT_NAT);
        }
        if(x <= 2){
            return 1;
        }
        return apply(x - 1) + apply(x - 2);
    }

    /**
     * Aufruf der applyAndPrint Methode mit der Top-Level Klasse.
     *
     * @param args Kein Nutzen
     */
    public static void main(String[] args) {
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, new Fibonacci());
    }
}
