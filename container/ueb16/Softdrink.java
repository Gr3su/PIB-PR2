package ueb16;

/**
 * Die Softdrink-Klasse repräsentiert ein Softdrink-Objekt mit einem Namen, Hersteller und Zuckergehalt.
 * Diese Klasse erbt von der AlkoholfreiesGetraenk-Klasse.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 04.05.2023 / 23:00Uhr
 */
public class Softdrink extends AlkoholfreiesGetraenk{


    // Instanzvariable für den Zuckergehalt des Softdrinks
    private float zuckergehalt;

    /**
     * Standard-Konstruktor, der ein Softdrink-Objekt ohne Namen, Hersteller und Zuckergehalt erstellt.
     */
    public Softdrink(){
        super();
        this.zuckergehalt = 0;
    }

    /**
     * Konstruktor, der ein Softdrink-Objekt mit einem gegebenen Zuckergehalt, aber ohne Namen und Hersteller erstellt.
     * @param zuckergehalt der Zuckergehalt des Softdrinks
     * @throws GetraenkException falls der Zuckergehalt negativ oder kein Float ist
     */
    public Softdrink(float zuckergehalt){
        super();
        setZuckergehalt(zuckergehalt);
    }

    /**
     * Konstruktor, der ein Softdrink-Objekt mit einem gegebenen Zuckergehalt, Hersteller und Name erstellt.
     * @param zuckergehalt der Zuckergehalt des Softdrinks
     * @param hersteller der Hersteller des Softdrinks
     * @param name der Name des Softdrinks
     * @throws GetraenkException falls der Hersteller leer ist oder der Zuckergehalt negativ oder kein Float ist
     */
    public Softdrink(float zuckergehalt, String hersteller, String name){
        super(hersteller,name);
        setZuckergehalt(zuckergehalt);
    }

    /**
     * Getter-Methode für den Zuckergehalt des Softdrinks
     * @return der Zuckergehalt des Softdrinks
     */
    public float getZuckergehalt() {
        return zuckergehalt;
    }

    /**
     * Setter-Methode für den Zuckergehalt des Softdrinks
     * @param zuckergehalt der zu setzende Zuckergehalt des Softdrinks
     * @throws GetraenkException falls der Zuckergehalt negativ oder kein Float ist
     */
    public void setZuckergehalt(float zuckergehalt) {
        GetraenkException.errorKeinFloat(String.valueOf(zuckergehalt));
        GetraenkException.errorNegativ(zuckergehalt);
        this.zuckergehalt = zuckergehalt;
    }

    /**
     * Diese Methode vergleicht das aktuelle Softdrink-Objekt mit einem anderen Objekt auf Gleichheit.
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
        Softdrink tmp = (Softdrink) o;
        return Float.compare(tmp.zuckergehalt, zuckergehalt) == 0;
    }


    /**
     * Gibt eine String-Repräsentation des Softdrink-Objekts zurück.
     * @return eine String-Repräsentation des Softdrink-Objekts
     */
    @Override
    public String toString() {
        return super.toString() +
                "Zuckergehalt = " + zuckergehalt + "\n";
    }
}
