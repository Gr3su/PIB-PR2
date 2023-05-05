import java.util.Objects;

public abstract class AlkoholfreiesGetraenk extends Getraenk {

    private String hersteller;

    public AlkoholfreiesGetraenk(){
        super();
        this.hersteller = null;
    }

    public AlkoholfreiesGetraenk(String hersteller){
        super();
        setHersteller(hersteller);
    }

    public AlkoholfreiesGetraenk(String hersteller, String name){
        super(name);
        setHersteller(hersteller);
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        GetraenkException.stringLeer(hersteller);
        this.hersteller = hersteller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AlkoholfreiesGetraenk that = (AlkoholfreiesGetraenk) o;
        return Objects.equals(hersteller, that.hersteller);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Hersteller = " + hersteller + "\n";
    }
}
