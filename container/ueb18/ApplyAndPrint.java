package ueb18;

/**
 * Klasse die nur fuer die Methode ApplyAndPrint dient.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 20.05.2023
 */
public class ApplyAndPrint {
    //Error-Messages
    private static final String ERROR_INDEX_NEGATIV = "Die Indexe a und b duerfen nicht negativ sein.";

    /**
     * Itteriert ueber einen Zahlenbereich und ruft mit diesen Zahlen
     * die apply Funktion auf.
     *
     * @param a Start der Iteration
     * @param b Ende der Iteration
     * @param func Lambda Ausdruck von MyFunction
     */
    public static void applyAndPrint(int a, int b, MyFunction func){
        if(a < 1 || b < 1){
            throw new IllegalArgumentException(ERROR_INDEX_NEGATIV);
        }

        for(int i = a; i <= b; i++){
            System.out.println(func.apply(i));
        }
    }
}
