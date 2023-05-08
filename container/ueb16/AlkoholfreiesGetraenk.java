package ueb16;

/**
 * Die AlkoholfreiesGetraenk-Klasse repräsentiert ein alkoholfreies Getränk-Objekt mit einem Namen und einem Hersteller.
 * Diese Klasse erbt von der Getraenk-Klasse.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 04.05.2023 / 23:00Uhr
 */
public abstract class AlkoholfreiesGetraenk extends Getraenk {

    // Instanzvariable für den Hersteller des Getränks
    private String hersteller;

    /**
     * Standard-Konstruktor, der ein AlkoholfreiesGetraenk-Objekt ohne Name und ohne Hersteller erstellt.
     */
    public AlkoholfreiesGetraenk(){
        super();
        this.hersteller = null;
    }

    /**
     * Konstruktor, der ein AlkoholfreiesGetraenk-Objekt mit einem gegebenen Hersteller, aber ohne Name erstellt.
     * @param hersteller der Hersteller des Getränks
     * @throws GetraenkException falls der übergabe Parameter des Herstellers leer ist
     */
    public AlkoholfreiesGetraenk(String hersteller){
        super();
        setHersteller(hersteller);
    }

    /**
     * Konstruktor, der ein AlkoholfreiesGetraenk-Objekt mit einem gegebenen Hersteller und gegebenem Namen erstellt.
     * @param hersteller der Hersteller des Getränks
     * @param name der Name des Getränks
     * @throws GetraenkException falls der übergabe Parameter des Herstellers leer ist
     */
    public AlkoholfreiesGetraenk(String hersteller, String name){
        super(name);
        setHersteller(hersteller);
    }

    /**
     * Getter-Methode für den Hersteller des Getränks
     * @return der Hersteller des Getränks
     */
    public String getHersteller() {
        return hersteller;
    }

    /**
     * Setter-Methode für den Hersteller des Getränks
     * @param hersteller der zu setzende Hersteller des Getränks
     * @throws GetraenkException falls der übergabe Parameter des Herstellers leer ist
     */
    public void setHersteller(String hersteller) {
        GetraenkException.stringLeer(hersteller);
        this.hersteller = hersteller;
    }

    /**
     * Diese Methode vergleicht das aktuelle AlkoholfreiesGetraenk-Objekt mit einem anderen Objekt auf Gleichheit
     * @param o das Objekt zum Vergleichen
     * @return true, wenn die Objekte gleich sind, false sonst
     */
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
        AlkoholfreiesGetraenk tmp = (AlkoholfreiesGetraenk) o;
        return hersteller.equals(tmp.hersteller);
    }

    /**
     * Gibt eine String-Repräsentation des AlkoholfreiesGetraenk-Objekts zurück.
     * @return eine String-Repräsentation des AlkoholfreiesGetraenk-Objekts
     */
    @Override
    public String toString() {
        return super.toString() +
                "Hersteller = " + hersteller + "\n";
    }
}
