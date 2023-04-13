/**
 * Beschreiben Sie hier die Klasse Reservierung.
 *
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Reservierung
{
    private String bemerkung;
    private Uhrzeit beginn;
    private Uhrzeit ende;
    private Mitarbeiter mitarbeiter;

    public Reservierung(Uhrzeit beginn, Uhrzeit ende){
        this(beginn, ende, null, "");
    }

    public Reservierung(Uhrzeit beginn, Uhrzeit ende, Mitarbeiter mitarbeiter, String bemerkung){
        this.beginn = beginn;
        this.ende   = ende;
        this.mitarbeiter = mitarbeiter;
        this.bemerkung = bemerkung;
    }

    public void setBemerkung(String eingabe){
        bemerkung = eingabe;
    }
    public void setMitarbeiter(Mitarbeiter eingabe){
        mitarbeiter = eingabe;
    }


    public String toString(){
        return "gebucht von " + mitarbeiter + " von " + beginn + " bis " + ende + " für " + bemerkung;
    }

}