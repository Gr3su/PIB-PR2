package ueb16;

public class GetraenkeautomatException extends RuntimeException{
    //Prompts
    private static final String ERROR_KAPAZITAET_NEGATIV = "Die Kapazitaet muss groesser 0 sein.";
    private static final String ERROR_KAPAZITAET_ERREICHT = "Getraenkeautomat ist bereits voll.";
    private static final String ERROR_FLASCHE_NICHT_VOLL = "Die Flasche ist nicht gefuellt.";
    private static final String ERROR_AUTOMAT_LEER = "Der Automat besitzt keine Flaschen mehr.";

    public GetraenkeautomatException(){
        super();
    }

    public GetraenkeautomatException(String msg){
        super(msg);
    }

    public static void validateKapazitaet(int kapazitaet){
        if(kapazitaet < 1){
            throw new GetraenkeautomatException(ERROR_KAPAZITAET_NEGATIV);
        }
    }

    public static void capacityReached(int size, int capacity){
        if(size == capacity){
            throw new GetraenkeautomatException(ERROR_KAPAZITAET_ERREICHT);
        }
    }

    public static void empty(int size){
        if(size == 0){
            throw new GetraenkeautomatException(ERROR_AUTOMAT_LEER);
        }
    }

    public static void flascheVoll(Flasche flasche){
        if(! flasche.istVoll()){
            throw new GetraenkeautomatException(ERROR_FLASCHE_NICHT_VOLL);
        }
    }
}
