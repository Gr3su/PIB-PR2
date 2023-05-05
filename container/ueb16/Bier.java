package ueb16;

public class Bier extends AlkoholischesGetraenk{
    private int t;
    public void setT(int t){
        this.t = t;
    }
    public String toString(){
        return super.toString() + t;
    }
}
