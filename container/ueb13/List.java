public class List{
    //Prompts
    private static final String     ERROR_INDEX_FALSE   = "Uebergebener Index ist falsch.\n";

    private Reservierung [] list;
    private int anzahl;
    private static final int INIT_LENGTH = 5;

    public List(){
        this.list = new Reservierung[INIT_LENGTH];
        this.anzahl = 0;
    }

    public void addReservierung(Reservierung tmp){
        checkLength();
        list[anzahl++] = tmp;
    }

    public Reservierung getByIndex(int index){
        if(index < 0 || index > anzahl){
            throw new ArrayIndexOutOfBoundsException(ERROR_INDEX_FALSE);
        }

        return list[index];
    }

    public int getAnzahl(){
        return anzahl;
    }

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