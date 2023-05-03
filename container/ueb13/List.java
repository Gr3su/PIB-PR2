package ueb13;

public class List{
    //Prompts
    private static final String     ERROR_INDEX_FALSE   = "Uebergebener Index ist falsch.\n";

    private Reservierung [] list;
    private int anzahl;
    private static final int INIT_LENGTH = 5;

    /**
     * Konstruktor um ein Anfangs-Array zu erstellen, der Laenge 5.
     */
    public List(){
        this.list = new Reservierung[INIT_LENGTH];
        this.anzahl = 0;
    }

    /**
     * Fuegt eine Reservierung hinzu und ueberprueft dabei ob ein groesseres
     * Array benoetigt wird.
     *
     * @param tmp Reservierung die hinzugefuegt werden soll.
     */
    public void addReservierung(Reservierung tmp){
        checkLength();
        list[anzahl++] = tmp;
    }

    /**
     * Gibt Reservierung an Stelle index zurueck.
     *
     * @param index Index der Reservierung.
     * @return Reservierung an Stelle index.
     */
    public Reservierung getByIndex(int index){
        if(index < 0 || index >= anzahl){
            throw new ArrayIndexOutOfBoundsException(ERROR_INDEX_FALSE);
        }

        return list[index];
    }

    /**
     *
     * @return Anzahl der Reservierungen.
     */
    public int getAnzahl(){
        return anzahl;
    }

    /**
     * Vergroessert das Array wenn noetig.
     */
    public void checkLength(){
        if(anzahl == list.length - 1){
            Reservierung [] tmp = new Reservierung[list.length * 2];
            for(int i = 0; i < anzahl; i++){
                tmp[i] = list[i];
            }
            list = tmp;
        }
    }

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < getAnzahl(); i++){
            output.append(list[i]);
        }

        return output.toString();
    }

}