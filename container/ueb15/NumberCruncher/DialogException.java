package ueb15.NumberCruncher;

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

    public static void stringIsFloat(String tmp){
        if(tmp.matches("^-?[0-9]*,[0-9]*$")){
            throw new DialogException(ERROR_KOMMA_PUNKT);
        }

        if(!(tmp.matches("^-?[0-9]*\\.?[0-9]+$"))){
            throw new DialogException(ERROR_KEINE_FLOAT + tmp);
        }
    }

    public static void arrayLaenge(int a){
        if(a < 1){
            throw new DialogException(ERROR_ARRAY_KURZ);
        }
    }
}
