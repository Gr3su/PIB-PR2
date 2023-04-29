package ueb15.NumberCruncher;

/**
 * Abstrakte Klasse fuer NumberChruncher's.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 27.04.2023 / 20:30Uhr
 */
public abstract class NumberCruncher {
    protected float [] values;

    public NumberCruncher(float [] values){
        this.values = values;
    }

    public void crunch(String [] operations){};

    public float[] getNumbers(){
        return values;
    }

}
