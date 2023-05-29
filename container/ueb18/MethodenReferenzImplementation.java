package ueb18;

/**
 * Implementiert die Aufgabe 2 zur uebung von Methoden-Referenzen.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 29.05.2023
 */
public abstract class MethodenReferenzImplementation {
    public static void main(String[] args) {
        final String ERROR = "Intervallgrenzen muessen natuerliche Zahlen sein.";
        final String regexFigures = "[0-9]+";

        if(!args[0].matches(regexFigures) ||
            !args[1].matches(regexFigures)){
            System.err.println(ERROR);
            return;
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        ApplyAndPrint.applyAndPrint(a,b,new Fakultaet()::apply);

        //Nicht wie in Aufgabe gefordert, da apply() keine statische Methode
        //ApplyAndPrint.applyAndPrint(1,5, StaticNestedImplementation.Fakultaet::apply);
        ApplyAndPrint.applyAndPrint(a, b, new StaticNestedImplementation.Fakultaet());
    }
}
