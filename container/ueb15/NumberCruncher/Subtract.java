package ueb15.NumberCruncher;
/**
 * Top-Level Klasse fuer Methode Subtract
 *
 * @author Yannick Gross / Tim Mueller
 * @version 30.04.2023 / 15:00Uhr
 */

public class Subtract implements CrunchOperation{

    /**
     * Subtrahiert die Elemente des Arrays paarweise von links nach und speichert
     * den neuen Wert in dem jeweils rechten Datenfeld. D.h.: a[1] = a[0] - a[1]; a[2] = a[1] - a[2] usw
     *
     * @param values float Array
     */
    @Override
    public void crunch(float [] values){
        for(int i = 1; i < values.length; i++){
            values[i] = values[i-1] - values[i];
        }
    }
}
