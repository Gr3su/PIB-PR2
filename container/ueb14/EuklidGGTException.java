/**
 * Exception Klasse fuer Euklid.java
 *
 * @author Tim Mueller / Yannick Gross
 * @version 20.04.2023 / 15:00Uhr
 */
public class EuklidGGTException extends RuntimeException{

    public EuklidGGTException(){
        super();
    }

    public EuklidGGTException(String msg){
        super(msg);
    }

    /**
     * Prueft ob uebergebener String eine positive Ganzzahl ist.
     *
     * @param tmp Zu pruefender String
     * @throws EuklidGGTException Wenn String keine positive Ganzzahl
     */
    public static void checkIfInteger(String tmp){
        String ErrorMessage = "Uebergebenes Attribut ist keine Zahl.\n";
        String numberRegex = "[0-9]+";
        if(!tmp.matches(numberRegex)){
            throw new EuklidGGTException(ErrorMessage);
        }
    }
}
