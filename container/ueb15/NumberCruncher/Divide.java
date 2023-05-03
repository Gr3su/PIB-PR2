package ueb15.NumberCruncher;
/**
 * Top-Level Klasse fuer Methode Divide
 *
 * @author Yannick Gross / Tim Mueller
 * @version 30.04.2023 / 15:00Uhr
 */

public class Divide implements CrunchOperation{

    /**
     * Teilt die n/2 größten Werte im Array durch die n/2 Kleinsten und speichert den
     * neuen Wert im Datenfeld des jeweils größeren Wertes. D.h. der größte Wert wird durch
     * den Kleinsten geteilt. Der Zweitgrößte durch den Zweitkleinsten usw
     *
     * @param values float Array
     */
    @Override
    public void crunch(float [] values){
        float [][] valuesCopy = new float[values.length][2];
        for(int i = 0; i < values.length; i++){
            valuesCopy[i][0] = values[i];
            valuesCopy[i][1] = i;
        }

        for(int i = 0; i < valuesCopy.length; i++){
            for(int j = 0; j < valuesCopy.length - 1 - i; j++){
                if(valuesCopy[j][0] > valuesCopy[j+1][0]){
                    swap(valuesCopy, j, j+1);
                }
            }
        }

        for(int i = 0; i < valuesCopy.length / 2; i++){
            valuesCopy[valuesCopy.length - 1 - i][0] /= valuesCopy[i][0];
        }

        for(int i = 0; i < valuesCopy.length; i++){
            values[(int)valuesCopy[i][1]] = valuesCopy[i][0];
        }
    }

    private void swap (float [][] values, int a, int b) {
        float[] tmp = values[a].clone();
        values[a] = values[b].clone();
        values[b] = tmp;
    }
}
