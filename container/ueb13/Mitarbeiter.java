/**
 * Beschreiben Sie hier die Klasse Mitarbeiter.
 *
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Mitarbeiter extends Person{
    //Prompts
    private static final String     ERROR_EMAIL_LEER    = "E-Mail darf nicht leer sein.\n";

    //Attributes
    private String email;


    public Mitarbeiter(String vorname, String nachname, String email) {
        super(vorname, nachname);

        if(email.isBlank()){
            throw new IllegalArgumentException(ERROR_EMAIL_LEER);
        }
        setEmail(email);
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        if(email == null || email.isBlank()){
            throw new IllegalArgumentException(ERROR_EMAIL_LEER);
        }

        this.email = email;
    }

    public void reserviere(Raum raum, Uhrzeit beginn, Uhrzeit ende, String bemerkung){
        Reservierung reservierung = new Reservierung(beginn, ende, this, bemerkung);
        raum.addReservierung(reservierung);
    }

    @Override
    public String toString(){
        return super.toString() + " (" + email + ")";
    }

    @Override
    public boolean equals(Object obj){
        if(!super.equals(obj)){
            return false;
        }
        if(obj == this){
            return true;
        }

        if(obj instanceof Mitarbeiter){
            Mitarbeiter tmp = (Mitarbeiter)obj;
            if(tmp.getEmail().equals(this.email)){
                return false;
            }
            return true;
        }
        return false;
    }
}