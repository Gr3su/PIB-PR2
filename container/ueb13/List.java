public class List{
    private Reservierung [] list;
    private int anzahl;
    private static final int INIT_LENGTH;

    public List(){
        this.list = new Reservierung[INIT_LENGTH];
        this.anzahl = 0;
    }

    public add(Reservierung tmp){
        checkLength();
        list[anzahl++] = tmp;
    }

    public getByIndex(int index){
        if(index < 0 || index > anzahl){
            throw new ArrayIndexOutOfBounds();
        }

        return list[index];
    }

    public int getAnzahl(){
        return anzahl;
    }

    public checkLength(){
        if(anzahl == list.length - 1){
            Reservierung [] tmp = new Reservierung[list.length * 2];
            for(int i = 0; i < anzahl; i++){
                tmp[i] = list[i];
            }
            list = tmp;
        }
    }

}