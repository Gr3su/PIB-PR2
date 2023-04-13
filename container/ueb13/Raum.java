
/**
 * Beschreiben Sie hier die Klasse Raum.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Raum
{
    private int geb;
    private int etage;
    private int raum;
    private List reservierungen;
    public Raum(int geb, int etage, int raum){
        
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
    
    public String toString(){
        String buchung     = "Raum" + geb +"-" + etage + "." + raum + "/n";
        StringBuilder raum = new StringBuilder(buchung);
        for(int i = 0; i < reservierungen.getAnzahl(); i++){
            raum.append(reservierungen.getByIndex(i));    
            }
        return raum.toString();
    }
}
