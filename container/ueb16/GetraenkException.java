package ueb16;

public class GetraenkException extends  RuntimeException {

    //Errors
    private static final String ERROR_KEIN_FLOAT = "Eingabe muss einer Float Zahl entsprechen ";
    private static final String ERROR_NEGATIV = "Eingabe muss 0 oder Positiv sein ";
    private static final String ERROR_STRING_LEER = "Eingabe muss eine Zeichenkette enthalten ";
    private static final String ERROR_KOMMA_PUNKT = "Statt einem Komma muss ein Punkt verwendet werden. ";

    public GetraenkException(){
        super();
    }

    public GetraenkException(String msg){
        super(msg);
    }
    public static void errorKeinFloat(String tmp) {
        if(tmp.matches("^-?[0-9]*,[0-9]*$")){
            throw new GetraenkException(ERROR_KOMMA_PUNKT);
        }

        if (!(tmp.matches("^-?[0-9]*\\.?[0-9]+$"))) {
            throw new GetraenkException(ERROR_KEIN_FLOAT +  tmp);
        }
    }
    public static void errorNegativ(Float tmp){
        if(tmp < 0){
            throw new GetraenkException(ERROR_NEGATIV  + tmp);
        }
    }

    public static void stringLeer(String tmp){
        if(tmp.equals("")||(tmp.equals(null))){
            throw new GetraenkException(ERROR_STRING_LEER + tmp);
        }
    }


}
