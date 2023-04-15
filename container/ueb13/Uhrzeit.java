/**
 * Beschreiben Sie hier die Klasse Uhrzeit.
 *
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Uhrzeit {
    //Prompts
    private static final String ERROR_STUNDE = "Stunden müssen im bereich von 0-23 geweahlt werden.\n";
    private static final String ERROR_MINUTE = "Minuten müssen im bereich von 0-59 geweahlt werden.\n";

    //Attributes
    private int stunde;
    private int minute;

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