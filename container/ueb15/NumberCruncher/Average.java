package ueb15.NumberCruncher;
/**
 * Top-Level Klasse fuer Methode Average
 *
 * @author Yannick Gross / Tim Mueller
 * @version 30.04.2023 / 15:00Uhr
 */

public class Average implements CrunchOperation{

    /**
     * Bestimmt den Durchschnitt aller Werte im Array und speichert den
     * Durchschnittswert im Datenfeld mit dem größten Wert
     *
     * @param values float Array
     */
    @Override
    public void crunch(float [] values){
        if(values == null ||
            values.length == 0){
            return;
        }

        float biggest = 0.0F;
        float sum = 0.0F;
        int biggestIndex = -1;

        for(int i = 0; i < values.length; i++) {
            if (values[i] > biggest) {
                biggestIndex = i;
            }

            sum += values[i];
        }

        values[biggestIndex] = sum / values.length;
    }
}
