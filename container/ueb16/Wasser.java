package ueb16;

public class Wasser extends AlkoholfreiesGetraenk{

    private String quelle;

    public Wasser(){
        super();
    }

    public Wasser(String quelle){
        super();
        setQuelle(quelle);
    }

    public Wasser(String quelle, String hersteller, String name){
        super(hersteller, name);

        setQuelle(quelle);
    }

    public String getQuelle() {
        return quelle;
    }

    public void setQuelle(String quelle) {
        GetraenkException.stringLeer(quelle);
        this.quelle = quelle;
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
        Wasser tmp = (Wasser) o;
        return quelle.equals(tmp.quelle);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Quelle = " + quelle + "\n";
    }
}
