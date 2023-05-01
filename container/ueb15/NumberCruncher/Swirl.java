package ueb15.NumberCruncher;

/**
 * Top-Level Klasse fuer Methode Swirl
 *
 * @author Yannick Gross / Tim Mueller
 * @version 30.04.2023 / 15:00Uhr
 */

public class Swirl implements CrunchOperation{

    /**
     * Führt n zufällige Vertauschungen der Datenfelder durch; n ist durch die Länge des
     * float-Arrays gegeben
     *
     * @param values float Array
     */
    @Override
    public void crunch(float [] values){
        int range = values.length;

        for(float a: values){
            swap(values, (int)(Math.random() * range), (int)(Math.random() * range));
        }
    }

    /**
     * Wechselt in dem float Array values die Werte an den Stellen a und b.
     *
     * @param values
     * @param a
     * @param b
     */
    private void swap(float [] values, int a, int b){
        float tmp = values[a];
        values[a] = values[b];
        values[b] = tmp;
    }
}
