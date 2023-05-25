package ueb17;
import static ueb17.ApplyAndPrint.applyAndPrint;

/**
 * Implementierung der Berechnung der Potenz als Top-Level Klasse mit dem
 * Interface MyFunction.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 20.05.2023
 */
public class Potenz implements MyFunction{
    private static final String ERROR_NOT_NAT = "x muss eine natuerliche Zahl sein.";
    private static final int MIN_TEST_VALUE = 1;
    private static final int MAX_TEST_VALUE = 10;

    @Override
    public int apply(int x){
        if(x < 0){
            throw new IllegalArgumentException(ERROR_NOT_NAT);
        }
        int sum = x;
        for(int i = 0; i < x; i++){
            sum *= x;
        }
        return sum;
    }

    /**
     * Aufruf der applyAndPrint Methode mit der Top-Level Klasse.
     *
     * @param args Kein Nutzen
     */
    public static void main(String[] args) {
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, new Potenz());
    }
}
