package ueb16;

public class Softdrink extends AlkoholfreiesGetraenk{

    private float zuckergehalt;

    public Softdrink(){
        super();
        this.zuckergehalt = 0;
    }

    public Softdrink(float zuckergehalt){
        super();
        setZuckergehalt(zuckergehalt);
    }

    public Softdrink(float zuckergehalt, String hersteller, String name){
        super(hersteller,name);
        setZuckergehalt(zuckergehalt);
    }

    public float getZuckergehalt() {
        return zuckergehalt;
    }

    public void setZuckergehalt(float zuckergehalt) {
        GetraenkException.errorKeinFloat(String.valueOf(zuckergehalt));
        GetraenkException.errorNegativ(zuckergehalt);
        this.zuckergehalt = zuckergehalt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        if (!super.equals(o)){
            return false;
        }
        Softdrink tmp = (Softdrink) o;
        return Float.compare(tmp.zuckergehalt, zuckergehalt) == 0;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Zuckergehalt = " + zuckergehalt + "\n";
    }
}
