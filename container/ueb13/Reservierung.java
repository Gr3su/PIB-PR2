/**
 * Klasse Reservierung.
 * 
 * @author Tim Mueller / Yannick Gross
 * @version 16.04.2023 / 20:00
 */
public class Reservierung {
    //Prompts
    private static final String     ERROR_BEMERKUNG_NULL    = "Bemerkung darf nicht null sein.\n";
    private static final String     ERROR_FEHLER_UHRZEIT    = "Fehlerhafte Uhrzeit uebergeben.\n";

    //Attributes
    private String bemerkung;
    private Uhrzeit beginn;
    private Uhrzeit ende;
    private Mitarbeiter mitarbeiter;
    
    /**
    * Konstruktor fuer die Klasse Reservierung mit allen Attributen.
    * 
    * @param beginn Uhrzeit des Anfangs der Reservierung.
    * @param ende Uhrzeit des Endes der Reservierung.
    * @param mitarbeiter Mitarbeiter auf welchen der Raum reserviert wird.
    * @param bemerkung anhaengende bemerkung der Reservierung.
     
    * @throws IllegalArgumentException wenn eine fehlerhafte Uhrzeit uebergeben wird.
    */
   public Reservierung(Uhrzeit beginn, Uhrzeit ende, Mitarbeiter mitarbeiter, String bemerkung){
        if(beginn == null){
            throw new IllegalArgumentException(ERROR_FEHLER_UHRZEIT);
        }
        if(ende == null){
            throw new IllegalArgumentException(ERROR_FEHLER_UHRZEIT);
        }

        this.beginn = beginn;
        this.ende   = ende;
        this.mitarbeiter = mitarbeiter;
        setBemerkung(bemerkung);
    }

    public Reservierung(Uhrzeit beginn, Uhrzeit ende){
        this(beginn, ende, null, "");
    }
     /**
    * Ueberschreibt die Bemerkung der Reservierung mit dem uebergebenen String.
    * 
    * @param bemerkung Neue Bemerkung der Reservierung.
    * 
    * @throws IllegalArgumentException Wenn Bemerkung Leer ist.
    */
    public void setBemerkung(String bemerkung){
        if(bemerkung == null){
            throw new IllegalArgumentException(ERROR_BEMERKUNG_NULL);
        }

        this.bemerkung = bemerkung;
    }
    
    /**
    * Ueberschreibt den Mitarbeiter auf welchen der Raum reserviert wurde mit einem neuen Mitarbeiter.
    * 
    * @param mitarbeiter Neuer Mitarbeiter der Reservierung.
    */
    public void setMitarbeiter(Mitarbeiter mitarbeiter){
        this.mitarbeiter = mitarbeiter;
    }
    /**
     * Gibt die volle Reservierung aufbereitet in einem Stringformat zurueck.
     * 
     * @return String mit Attributen.
     */
    @Override
    public String toString(){
        String mitarbeiterPrompt;
        String bemerkungPrompt = bemerkung;
        if(mitarbeiter == null){
            mitarbeiterPrompt = "niemandem";
        }
        else{
            mitarbeiterPrompt = mitarbeiter.toString();
        }
        if(bemerkung.isBlank()){
            bemerkungPrompt = "-nicht angegeben-";
        }

        return "gebucht von " + mitarbeiterPrompt + " von " + beginn + " bis " + ende + " für " + bemerkungPrompt;
    }

}