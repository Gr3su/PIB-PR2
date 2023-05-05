package ueb16;
import java.util.Objects;

public class Bier extends AlkoholischesGetraenk {

    private String brauerei;

    public Bier(){
        super();
        this.brauerei = null;
    }

    public Bier(String brauerei){
        super();
        setBrauerei(brauerei);
    }

    public Bier(String brauerei, Float alkoholgehalt, String name){
        super(alkoholgehalt, name);
        setBrauerei(brauerei);
    }

    public String getBrauerei() {
        return brauerei;
    }

    public void setBrauerei(String brauerei) {
        GetraenkException.stringLeer(brauerei);
        this.brauerei = brauerei;
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
        Bier tmp = (Bier) o;
        return brauerei.equals(tmp.brauerei);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Brauerei = " + brauerei + "\n";
    }
}
