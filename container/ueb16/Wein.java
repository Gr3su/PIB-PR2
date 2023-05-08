package ueb16;

/**
 * Die Wein-Klasse repräsentiert ein Wein-Objekt mit einem Namen, dem Alkoholgehalt und dem Weingut, das den Wein hergestellt hat.
 * Diese Klasse erbt von der AlkoholischesGetraenk-Klasse.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 04.05.2023 / 23:00Uhr
 */
public class Wein extends AlkoholischesGetraenk{


    // Instanzvariable für das Weingut, das den Wein hergestellt hat
    private String weingut;

    /**
     * Standard-Konstruktor, der ein Wein-Objekt ohne Namen, Alkoholgehalt und Weingut erstellt.
     */
    public Wein(){
        super();
        this.weingut = null;
    }


    /**
     * Konstruktor, der ein Wein-Objekt mit einem gegebenen Weingut, aber ohne Namen und Alkoholgehalt erstellt.
     * @param weingut das Weingut, das den Wein hergestellt hat
     * @throws GetraenkException falls das Weingut leer ist
     */
    public Wein(String weingut){
        super();
        setWeingut(weingut);
    }

    /**
     * Konstruktor, der ein Wein-Objekt mit einem gegebenen Weingut, Alkoholgehalt und Name erstellt.
     * @param weingut das Weingut, das den Wein hergestellt hat
     * @param alkoholgehalt der Alkoholgehalt des Weins
     * @param name der Name des Weins
     * @throws GetraenkException falls der Alkoholgehalt negativ ist oder das Weingut leer ist
     */
    public Wein(String weingut, float alkoholgehalt, String name){
        super(alkoholgehalt, name);
        setWeingut(weingut);
    }

    /**
     * Getter-Methode für das Weingut, das den Wein hergestellt hat
     * @return das Weingut, das den Wein hergestellt hat
     */
    public String getWeingut() {
        return weingut;
    }

    /**
     * Setter-Methode für das Weingut, das den Wein hergestellt hat
     * @param weingut das zu setzende Weingut, das den Wein hergestellt hat
     * @throws GetraenkException falls das Weingut leer ist
     */
    public void setWeingut(String weingut) {
        GetraenkException.stringLeer(weingut);
        this.weingut = weingut;
    }

    /**
     * Diese Methode vergleicht das aktuelle Wein-Objekt mit einem anderen Objekt auf Gleichheit.
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
        Wein tmp = (Wein) o;
        return weingut.equals(tmp.weingut);
    }

    /**
     * Gibt eine String-Repräsentation des Wein-Objekts zurück.
     * @return eine String-Repräsentation des Wein-Objekts
     */
    @Override
    public String toString() {
        return super.toString() +
                "Weingut = " + weingut + "\n";
    }
}
