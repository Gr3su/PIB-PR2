package ueb17;

import static ueb17.ApplyAndPrint.applyAndPrint;

/**
 * Nutzen der applyAndPrint Methode mit den Praedikaten und den Conditionate Funktionen.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 20.05.2023
 */
public abstract class UsingApplyAndPrint {
    private static final int MIN_TEST_VALUE = 1;
    private static final int MAX_TEST_VALUE = 10;

    public static void main(String[] args) {
        //Implementierung von apply(int i) mit Quadratzahl
        ConditionateFunctions squareIfEven = (x) -> x * x;
        //Ueberpruefung ob Zahl gerade ist mithilfe von conditionateInput
        squareIfEven = squareIfEven.conditionateInput(PredicateImplementation.even());

        //Implementierung von apply(int i) mit Fakultaet von Top-Level Klasse Fakultaet
        ConditionateFunctions facIfFacOdd = (x) -> new Fakultaet().apply(x);
        //Ueberpruefung ob Fakultaet ungerade ist mithilfe von conditionateOutput
        //Eigentlich sinnlos, da ab 2! die Fakultaet immer gerade ist wegen dem Faktor 2.
        facIfFacOdd = facIfFacOdd.conditionateOutput(PredicateImplementation.odd());


        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, squareIfEven);
        applyAndPrint(MIN_TEST_VALUE, MAX_TEST_VALUE, facIfFacOdd);
        
    }
}
