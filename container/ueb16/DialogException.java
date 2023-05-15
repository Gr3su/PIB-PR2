package ueb16;

/**
 * Exception Klasse fuer Dialog.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 05.05.2023 / 13:00Uhr
 */
public class DialogException extends RuntimeException{
    //Attributes
    private static final int MAX_OPTION = 4;

    //Prompts
    private static final String ERROR_OPTIONSBEREICH       = "Die Option muss zwischen 0 und " + MAX_OPTION + "liegen.";
    private static final String ERROR_AUTOMATENAUSWAHL      = "Automat konnte nicht gefunden werden.";
    private static final String ERROR_GETRAENK_BEI_AUTOMAT  = "Die Getraenkeauswahl muss zwischen 0 und 8 liegen.";
    private static final String ERROR_GETRAENK_BEI_FLASCHE  = "Die Getraenkeauswahl muss zwischen 0 und 5 liegen.";

    public DialogException(){
        super();
    }
    public DialogException(String msg){
        super(msg);
    }

    public static void validateMenueOption(byte option){
        if(option < 0 ||
            option > MAX_OPTION){
            throw new DialogException(ERROR_OPTIONSBEREICH);
        }
    }

    public static void validateAutomatSelection(int size, int selection){
        if(selection < 0 ||
            selection >= size){
            throw new DialogException(ERROR_AUTOMATENAUSWAHL);
        }
    }

    public static void validateGetraenkBeiAutomat(int opt){
        if(opt < 0 ||
            opt > 8){
            throw new DialogException(ERROR_GETRAENK_BEI_AUTOMAT);
        }
    }

    public static void validateGetraenkBeiFlasche(int opt){
        if(opt < 0 ||
                opt > 5){
            throw new DialogException(ERROR_GETRAENK_BEI_FLASCHE);
        }
    }
}
