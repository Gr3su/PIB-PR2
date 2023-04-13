/**
 * Beschreiben Sie hier die Klasse Mitarbeiter.
 *
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Mitarbeiter extends Person

{
    private String email;
    private String vorname;
    private String nachname;


    public Mitarbeiter(String vorname, String nachname, String email){
        super(vorname, nachname);

        this.vorname  = vorname.strip();
        this.nachname = nachname.strip();
        this.email    = email.strip();


    }
    public String getVorname(){
        return vorname;
    }
    public String getNachname(){
        return nachname;
    }
    public String getEmail(){
        return email;
    }

    public void reserviere(Raum raum, Uhrzeit beginn, Uhrzeit ende, String bemerkung){
        Reservierung reservierung = new Reservierung(beginn, ende, this, bemerkung);
        raum.addReservierung(reservierung);
    }

    @Override
    public String toString(){
        return vorname + " " + nachname + " (" + email + ")";
    }
}