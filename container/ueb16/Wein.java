import java.util.Objects;

public class Wein extends AlkoholischesGetraenk{

    private String weingut;

    public Wein(){
        super();
        this.weingut = null;
    }

    public Wein(String weingut){
        super();
        setWeingut(weingut);
    }

    public Wein(String weingut, float alkoholgehalt, String name){
        super(alkoholgehalt, name);
        setWeingut(weingut);
    }

    public String getWeingut() {
        return weingut;
    }

    public void setWeingut(String weingut) {
        GetraenkException.stringLeer(weingut);
        this.weingut = weingut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Wein wein = (Wein) o;
        return Objects.equals(weingut, wein.weingut);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Weingut = " + weingut + "\n";
    }
}
