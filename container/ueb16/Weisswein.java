package ueb16;

public class Weisswein extends Wein {

    public Weisswein(){
        super();
    }

    public Weisswein(String weingut, float alkoholgehalt, String name){
        super(weingut, alkoholgehalt, name);
    }

    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }
    @Override
    public String toString() {
        return super.toString() + "Wein = Weisswein";
    }
}

