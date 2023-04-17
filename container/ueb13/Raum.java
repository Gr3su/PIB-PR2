/**
 * Klasse Raum.
 * 
 * @author Tim Mueller / Yannick Gross
 * @version 16.04.2023 / 20:00
 */
public class Raum {
    //Prompts
    private static final String     ERROR_GEB_NEGATIV       = "Gebaeudenummer darf nicht negativ sein.\n";
    private static final String     ERROR_RAUM_NEGATIV     = "Raumnummer darf nicht negativ sein.\n";

    //Attributes
    private int geb;
    private int etage;
    private int raum;
    private List reservierungen;

    /**
    * Konstruktor fuer die Klasse Raun mit allen Attributen.
    * 
    * @param geb Gebaeude des Raumes.
    * @param etage Etage des Raumes.
    * @param raum Raum-Nummer des Raumes.
     
    * @throws IllegalArgumentException wenn der eingegebene Wert des Gebaeudes negativ ist.
    * @throws IllegalArgumentException wenn der eingegebene Wert des Raumes negativ ist.
    */
    public Raum(int geb, int etage, int raum){
        if(geb < 0){
            throw new ExpectedException(ERROR_GEB_NEGATIV);
        }
        if(raum < 0){
            throw new ExpectedException(ERROR_RAUM_NEGATIV);
        }

        this.geb   = geb;
        this.etage = etage;
        this.raum  = raum;
        this.reservierungen = new List();
    }

    /**
     * Gibt das Gebaeude des Raumes zurueck.
     *
     * @return Gebaeude des Raumes.
     */
    public int getGeb(){
        return geb;
    }

    /**
     * Gibt die Etage des Raumes zurueck.
     * 
     * @return Etage des Raumes.
     */
    public int getEtage(){
        return etage;
    }

    /**
     * Gibt die Raum-Nummer des Raumes zurueck.
     *
     * @return Raum-Nummer des Raumes.
     */
    public int getRaum(){
        return raum;
    }

    /**
     * Fuegt eine Reservierung zu einem Raum hinzu.
     *
     */
    public void addReservierung(Reservierung reservierung){
        reservierungen.addReservierung(reservierung);
    }

    /**
     * Gibt eine Reservierung zurueck.
     *
     * @return Reservierung nach einem eingegeben Index.
     */
    public Reservierung getReservierung(int index){
        return reservierungen.getByIndex(index);
    }
    
    /**
     * Gibt einen String mit allen Attributen des Raumes zurueck.
     * 
     * @return String mit Attributen.
     */
    @Override
    public String toString(){
        String buchung     = "Raum " + geb +"-" + etage + "." + raum + "\n";

        return buchung + reservierungen;
    }
    
    /**
     * Ueberprueft ob ein Objekt gleich dem aufrufenden Raum Objekt ist.
     *
     * @param obj Zu vergleichendes Objekt.
     * @return Boolean ob Objekte gleich.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if(! (obj instanceof Raum)){
            return false;
        }
        Raum tmp = (Raum) obj;
        return geb == tmp.getGeb() && etage == tmp.getEtage() && raum == tmp.getRaum();
    }
}