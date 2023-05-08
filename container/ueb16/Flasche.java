package ueb16;

/**
 * Flaschen Klasse als Container fuer Getraenk-Objekte.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 04.05.2023 / 23:00Uhr
 *
 * @param <T> Getreank und Sub-Typen
 */

public class Flasche <T extends Getraenk>{
    //Prompts
    private static final String ERROR_INHALT_NULL   = "Der Inhalt darf nicht null sein.";

    //Attributes
    private T inhalt;
    private boolean istVoll;

    public Flasche(T inhalt){
        fuellen(inhalt);
    }

    /**
     * Setzt inhalt auf uebergebenes Getreank fest und setzt istVoll auf ture.
     *
     * @param inhalt
     */
    public void fuellen(T inhalt){
        if(inhalt == null){
            throw new IllegalArgumentException(ERROR_INHALT_NULL);
        }

        this.inhalt = inhalt;
        istVoll = true;
    }

    /**
     * Setzt inhalt auf null und setzt istVoll auf false.
     */
    public void leeren(){
        this.inhalt = null;
        istVoll = false;
    }

    public Getraenk getInhalt(){
        return inhalt;
    }

    public boolean istVoll(){
        return istVoll;
    }

    /**
     *
     * @return toString() des Getraenks
     */
    @Override
    public String toString(){
        return inhalt.toString();
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(obj == this){
            return true;
        }
        if(obj instanceof Flasche){
            Flasche tmp = (Flasche) obj;
            if(! this.inhalt.equals(tmp)){
                return false;
            }
            if(tmp.istVoll() == this.istVoll){
                return true;
            }
        }

        return false;

    }

}
