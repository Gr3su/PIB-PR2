public class Rotwein extends Wein {

    public Rotwein(){
        super();
    }

    public Rotwein(String weingut, float alkoholgehalt, String name){
        super(weingut, alkoholgehalt, name);
    }

    @Override
    public String toString() {
        return super.toString() + "Wein = Rotwein";
    }
}
