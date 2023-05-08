package ueb16;

/**
 * Die GetraenkException-Klasse erbt von der RuntimeException-Klasse und stellt eine Exception-Klasse für die Getränke-Klassen dar.
 * Diese Klasse ermöglicht es, Ausnahmen auszulösen, wenn die Eingabe ungültig ist.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 04.05.2023 / 23:00Uhr
 */
public class GetraenkException extends  RuntimeException {

    //Errors
    private static final String ERROR_KEIN_FLOAT = "Eingabe muss einer Float Zahl entsprechen ";
    private static final String ERROR_NEGATIV = "Eingabe muss 0 oder Positiv sein ";
    private static final String ERROR_STRING_LEER = "Eingabe muss eine Zeichenkette enthalten ";
    private static final String ERROR_KOMMA_PUNKT = "Statt einem Komma muss ein Punkt verwendet werden. ";

    /**
     * Standard-Konstruktor, der eine neue GetraenkException ohne Fehlermeldung erstellt.
     */
    public GetraenkException(){
        super();
    }

    /**
     * Konstruktor, der eine neue GetraenkException mit einer gegebenen Fehlermeldung erstellt.
     * @param msg die Fehlermeldung, die die Ausnahme auslöst
     */
    public GetraenkException(String msg){
        super(msg);
    }

    /**
     * Diese Methode prüft, ob die Eingabe einen float-Wert enthält.
     * Falls die Eingabe kein Float ist, wird eine GetraenkException mit einer entsprechenden Fehlermeldung ausgelöst.
     * @param tmp die Eingabe als String-Wert
     */
    public static void errorKeinFloat(String tmp) {
        if(tmp.matches("^-?[0-9]*,[0-9]*$")){
            throw new GetraenkException(ERROR_KOMMA_PUNKT);
        }

        if (!(tmp.matches("^-?[0-9]*\\.?[0-9]+$"))) {
            throw new GetraenkException(ERROR_KEIN_FLOAT +  tmp);
        }
    }

    /**
     * Diese Methode prüft, ob die Eingabe positiv oder 0 ist.
     * Falls die Eingabe negativ ist, wird eine GetraenkException mit einer entsprechenden Fehlermeldung ausgelöst.
     * @param tmp die Eingabe als float-Wert
     */
    public static void errorNegativ(Float tmp){
        if(tmp < 0){
            throw new GetraenkException(ERROR_NEGATIV  + tmp);
        }
    }

    /**
     * Diese Methode prüft, ob die Eingabe eine Zeichenkette enthält.
     * Falls die Eingabe leer ist, wird eine GetraenkException mit einer entsprechenden Fehlermeldung ausgelöst.
     * @param tmp die Eingabe als String-Wert
     */
    public static void stringLeer(String tmp){
        if(tmp.equals("")||(tmp.equals(null))){
            throw new GetraenkException(ERROR_STRING_LEER + tmp);
        }
    }


}
