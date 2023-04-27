package ueb13;
/**
 * Klasse Uhrzeit.
 * 
 * @author Tim Mueller / Yannick Gross
 * @version 16.04.2023 / 20:00
 */
public class Uhrzeit {
    //Prompts
    private static final String ERROR_STUNDE = "Stunden müssen im bereich von 0-23 geweahlt werden.\n";
    private static final String ERROR_MINUTE = "Minuten müssen im bereich von 0-59 geweahlt werden.\n";

    //Attributes
    private int stunde;
    private int minute;
    /**
    * Konstruktor fuer die Klasse Uhrzeit mit allen Attributen.
    * 
    * @param stunde Stunde der Uhrzeit.
    * @param minute Minute der uhrzeit.
     
    * @throws IllegalArgumentException stunde ist nicht im bereich von 0-23 geweahlt.
    * @throws IllegalArgumentException minute ist nicht im bereich von 0-59 geweahlt.
    */
    public Uhrzeit(int stunde, int minute){
        setStunde(stunde);
        setMinute(minute);
    }

    /**
     * Setzt Stunde und ueberprueft ob es zwischen 0 und 59 liegt.
     * @param minute Minuten der Uhrzeit.
     */
    public void setMinute(int minute){
        if (minute < 0 || minute > 59){
            throw new ExpectedException(ERROR_MINUTE);
        }

        this.minute = minute;
    }

    /**
     * Setzt Stunde und ueberprueft ob es zwischen 0 und 23 liegt.
     *
     * @param stunde Stunde der Uhrzeit.
     */
    public void setStunde(int stunde){
        if (stunde < 0 || stunde > 23){
            throw new ExpectedException(ERROR_STUNDE);
        }

        this.stunde = stunde;
    }
    /**
     * Gibt die Minute der Uhrzeit zurueck.
     *
     * @return Minute der Uhrzeit.
     */
    public int getMinute(){
        return minute;
    }
    /**
     * Gibt die Stunde der Uhrzeit zurueck.
     *
     * @return Stunde der Uhrzeit.
     */
    public int getStunde(){
        return stunde;
    }
    
     /**
     * Ueberprueft ob ein Objekt gleich dem aufrufenden Uhrzeit Objekt ist.
     *
     * @param obj Zu vergleichendes Objekt
     * @return Boolean ob Objekte gleich
     */
    @Override
    public boolean equals(Object obj){
        
        if(obj == null){
            return false;
        }
        
        if(obj == this){
            return true;
        }
        
        if(obj instanceof Uhrzeit){
            Uhrzeit tmp = (Uhrzeit)obj;
            if(tmp.getMinute() == (this.minute) &&
              (tmp.getStunde() == (this.stunde))){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Gibt einen Uhrzeit String mit allen Attributen der Uhrzeit zurueck.
     * 
     * @return String mit Attributen.
     */
    @Override
    public String toString(){

        String minuteString = String.valueOf(minute);
        String stundeString = String.valueOf(stunde);

        if(minute < 10){
            minuteString = "0" + minute;
        }
        if(stunde < 10){
            stundeString = "0" + stunde;
        }

        return stundeString + ":" + minuteString + " Uhr";
    }
    
}