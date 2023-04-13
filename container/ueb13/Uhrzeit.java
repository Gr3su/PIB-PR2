
/**
 * Beschreiben Sie hier die Klasse Uhrzeit.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Uhrzeit
{
    private int stunde;
    private int minute;
    private final String ERROR_STUNDE = "Stunden müssen im bereich von 0-23 geweahlt werden";
    private final String ERROR_MINUTE = "Minuten müssen im bereich von 0-59 geweahlt werden";
    
    public Uhrzeit(int stunde, int minute){
        if (stunde < 0 || stunde > 23){
            throw new IllegalArgumentException(ERROR_STUNDE);
        }
        if (minute < 0 || minute > 59){
            throw new IllegalArgumentException(ERROR_MINUTE);
        }
        
        this.stunde = stunde;
        this.minute = minute;
        
    }
    
    public int getMinute(){
        return minute;
    }
    
    public int getStunde(){
        return stunde;
    }
    
    public String toString(){
        
    String minuteString;
    String stundeString;
    
    if(minute < 10){
        minuteString = "0" + minute;
    }
    else{
        minuteString = "" + minute;    
    }
    if(stunde < 10){
        stundeString = "0" + stunde;
    }
    else{
        stundeString = "" + stunde;
        
    }
    
    return stundeString + ":" + minuteString + " Uhr";
    }
}


