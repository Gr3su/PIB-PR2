/**
 * Beschreiben Sie hier die Klasse Reservierung.
 *
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
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

    public Reservierung(Uhrzeit beginn, Uhrzeit ende){
        this(beginn, ende, null, "");
    }

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

    public void setBemerkung(String bemerkung){
        if(bemerkung == null){
            throw new IllegalArgumentException(ERROR_BEMERKUNG_NULL);
        }

        this.bemerkung = bemerkung;
    }
    public void setMitarbeiter(Mitarbeiter mitarbeiter){
        this.mitarbeiter = mitarbeiter;
    }

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