package ueb16;

/**
 * Exception Klasse fuer Getreankeautomat.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 04.05.2023 / 23:00Uhr
 */
public class GetraenkeautomatException extends RuntimeException{
    //Prompts
    private static final String ERROR_KAPAZITAET_NEGATIV = "Die Kapazitaet muss groesser 0 sein.";
    private static final String ERROR_KAPAZITAET_ERREICHT = "Getraenkeautomat ist bereits voll.";
    private static final String ERROR_FLASCHE_NICHT_VOLL = "Die Flasche ist nicht gefuellt.";
    private static final String ERROR_AUTOMAT_LEER = "Der Automat besitzt keine Flaschen mehr.";
    private static final String ERROR_FLASCHE_NULL = "Flasche darf nicht null sein.";

    public GetraenkeautomatException(){
        super();
    }

    public GetraenkeautomatException(String msg){
        super(msg);
    }

    /**
     * Wirft Exception wenn kapazitaet kleiner 1 ist.
     * @param kapazitaet
     */
    public static void validateKapazitaet(int kapazitaet){
        if(kapazitaet < 1){
            throw new GetraenkeautomatException(ERROR_KAPAZITAET_NEGATIV);
        }
    }

    /**
     * Prueft ob Kapazitaet erreicht.
     *
     * @param size Anzahl der Elemente in Lager
     * @param capacity Max Anzahl der Elemente in Lager
     */
    public static void capacityReached(int size, int capacity){
        if(size == capacity){
            throw new GetraenkeautomatException(ERROR_KAPAZITAET_ERREICHT);
        }
    }

    /**
     * Prueft ob Lager leer.
     *
     * @param size Elemente Anzahl in Lager
     */
    public static void empty(int size){
        if(size == 0){
            throw new GetraenkeautomatException(ERROR_AUTOMAT_LEER);
        }
    }

    /**
     * Prueft ob Flasche voll.
     *
     * @param flasche
     */
    public static void flascheValidierung(Flasche flasche){
        if(! flasche.istVoll()){
            throw new GetraenkeautomatException(ERROR_FLASCHE_NICHT_VOLL);
        }
        if(flasche == null){
            throw new GetraenkeautomatException(ERROR_FLASCHE_NULL);
        }
    }
}
