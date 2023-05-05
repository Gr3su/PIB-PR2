package ueb16;
import java.util.Objects;

public abstract class Getraenk {

    private String name;

    public Getraenk(){
        this.name = null;
    };

    public Getraenk(String name){
        GetraenkException.stringLeer(name);
        this.name = name;
    };

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Getraenk tmp = (Getraenk) o;
        return name.equals(tmp.name);
    }

    @Override
    public String toString() {
        return
                "Name = '" + name +"\n";
    }
}
