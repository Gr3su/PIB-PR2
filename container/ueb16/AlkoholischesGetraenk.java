import java.util.Objects;

public abstract class AlkoholischesGetraenk extends Getraenk {

    private float alkoholgehalt;
    public AlkoholischesGetraenk(){
        super();
        this.alkoholgehalt = 0;
    }

    public AlkoholischesGetraenk(Float alkoholgehalt){
        super();
        setAlkoholgehalt(alkoholgehalt);
    }

    public AlkoholischesGetraenk(Float alkoholgehalt, String name){
        super(name);
        setAlkoholgehalt(alkoholgehalt);
    }

    public float getAlkoholgehalt() {
        return alkoholgehalt;
    }

    public void setAlkoholgehalt(float alkoholgehalt) {
        GetraenkException.errorKeinFloat(String.valueOf(alkoholgehalt));
        GetraenkException.errorNegativ(alkoholgehalt);
        this.alkoholgehalt = alkoholgehalt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AlkoholischesGetraenk that = (AlkoholischesGetraenk) o;
        return Float.compare(that.alkoholgehalt, alkoholgehalt) == 0;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Alkoholgehalt = " + alkoholgehalt + "\n";
    }

}
