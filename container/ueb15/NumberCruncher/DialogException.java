package ueb15.NumberCruncher;
/**
 * Exception Klasse fuer Dialog.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 30.04.2023 / 15:00Uhr
 */

public class DialogException extends RuntimeException{
    //Errors
    private static final String     ERROR_KEINE_FLOAT = "Folgende uebergebene Zahl entspricht keiner Float-Zahl: ";
    private static final String     ERROR_KOMMA_PUNKT = "Statt einem Komma muss ein Punkt verwendet werden.";
    private static final String     ERROR_ARRAY_KURZ  = "Die Laenge des Arrays muss mindestens 1 sein.";

    public DialogException(){
        super();
    }

    public DialogException(String msg){
        super(msg);
    }

    /**
     * Prueft ob uebergebener String eine float Zahl ist.
     *
     * @param tmp zu pruefender String.
     */
    public static void stringIsFloat(String tmp){
        if(tmp.matches("^-?[0-9]*,[0-9]*$")){
            throw new DialogException(ERROR_KOMMA_PUNKT);
        }

        if(!(tmp.matches("^-?[0-9]*\\.?[0-9]+$"))){
            throw new DialogException(ERROR_KEINE_FLOAT + tmp);
        }
    }

    /**
     * Prueft ob uebergebene Array-Laenge groesser als 0 ist.
     *
     * @param a Arraylaenge
     */
    public static void arrayLaenge(int a){
        if(a < 1){
            throw new DialogException(ERROR_ARRAY_KURZ);
        }
    }
}
