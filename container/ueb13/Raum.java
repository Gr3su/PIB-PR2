/**
 * Beschreiben Sie hier die Klasse Raum.
 *
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
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


    public Raum(int geb, int etage, int raum){
        if(geb < 0){
            throw new IllegalArgumentException(ERROR_GEB_NEGATIV);
        }
        if(raum < 0){
            throw new IllegalArgumentException(ERROR_RAUM_NEGATIV);
        }

        this.geb   = geb;
        this.etage = etage;
        this.raum  = raum;
        this.reservierungen = new List();
    }

    public int getGeb(){
        return geb;
    }

    public int getEtage(){
        return etage;
    }

    public int getRaum(){
        return raum;
    }

    public void addReservierung(Reservierung reservierung){
        reservierungen.addReservierung(reservierung);
    }

    public Reservierung getReservierung(int index){
        return reservierungen.getByIndex(index);
    }

    @Override
    public String toString(){
        String buchung     = "Raum" + geb +"-" + etage + "." + raum + "\n";

        return buchung + reservierungen;
    }

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