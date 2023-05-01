package ueb15.NumberCruncher;

/**
 * Abstrakte Klasse fuer NumberChruncher's.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 27.04.2023 / 20:30Uhr
 */
public abstract class NumberCruncher {
    //Prompts
    private static final String     ERROR_OPTION_UNBEKANNT = "Folgende Operation ist nicht bekannt: ";

    //Attributes
    protected float [] values;

    /**
     * Konstruktoer zur Initialisierung des float Arrays
     *
     * @param values
     */
    public NumberCruncher(float [] values){
        this.values = values;
    }

    /**
     * Fuehrt nach und nach die uebergebenen Operationen durch.
     *
     * @param operations String Array mit den auszufuehrenden Operationen.
     */
    public void crunch(String [] operations){
        for(String oper: operations){

            try {

                switch (oper.strip().toLowerCase()) {
                    case "sum":
                        sum();
                        break;

                    case "swirl":
                        swirl();
                        break;

                    case "divide":
                        divide();
                        break;

                    case "subtract":
                        subtract();
                        break;

                    case "average":
                        average();
                        break;

                    default:
                        throw new IllegalArgumentException(ERROR_OPTION_UNBEKANNT + oper);
                }
            }
            catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    };

    /**
     *
     * @return dem Konstruktor uebergebenes float-Array
     */
    public float[] getNumbers(){
        return values;
    }

    public abstract void sum();
    public abstract void swirl();
    public abstract void divide();
    public abstract void subtract();
    public abstract void average();

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();

        for(float v: values){
            output.append(v + "\n");
        }

        return output.toString();
    }

}
