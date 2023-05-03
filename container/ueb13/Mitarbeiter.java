package ueb13;

/**
 * Klasse Mitarbeiter.
 * Erbt von Person
 * 
 * @author Tim Mueller / Yannick Gross
 * @version 16.04.2023 / 20:00
 */
public class Mitarbeiter extends Person{
    //Prompts
    private static final String     ERROR_EMAIL_LEER    = "E-Mail darf nicht leer sein.\n";

    //Attributes
    private String email;


    /**
    * Konstruktor fuer die Klasse Mitarbeiter mit allen Attributen.
    * 
    * @param vorname Vorname des Mitarbeiters.
    * @param nachname Nachname des Mitarbeiters.
    * @param email Email des Mitarbeiters.
     
    * @throws IllegalArgumentException wenn Email leer ist.
    */
    public Mitarbeiter(String vorname, String nachname, String email) {
        super(vorname, nachname);
        setEmail(email);
    }
    /**
     * Gibt die Email des Mitarbeiters zurueck.
     *
     * @return Email des Mitarbeiters.
     */
    public String getEmail(){
        return email;
    }
    
    /**
    * Ueberschreibt die Email des Mitarbeiters mit dem uebergebenen String.
    * 
    * @param email neue Email des Mitarbeiters.
    * 
    * @throws IllegalArgumentException Wenn email leer ist.
    */
    public void setEmail(String email){
        if(email == null || email.isBlank()){
            throw new ExpectedException(ERROR_EMAIL_LEER);
        }

        this.email = email;
    }

     /**
    * Reserviert einen Termin fuer einen ausgeweahlten Raum.
    * reservierung wird dem ausgeweahlten Raum hinzugefuegt.
    */
    public void reserviere(Raum raum, Uhrzeit beginn, Uhrzeit ende, String bemerkung){
        Reservierung reservierung = new Reservierung(beginn, ende, this, bemerkung, raum);
        raum.addReservierung(reservierung);
    }
    /**
     * Gibt einen String mit allen Attributen des Mitarbeiters zurueck.
     * 
     * @return String mit Attributen.
     */
    @Override
    public String toString(){
        return super.toString() + " (" + email + ")";
    }
    
    /**
     * Ueberprueft ob ein Objekt gleich dem aufrufenden Mitarbeiter Objekt ist.
     *
     * @param obj Zu vergleichendes Objekt
     * @return Boolean ob Objekte gleich
     */
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