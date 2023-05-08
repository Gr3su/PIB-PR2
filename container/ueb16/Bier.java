package ueb16;

/**
 * Die Bier-Klasse repräsentiert ein Bier-Objekt mit einem Namen, dem Alkoholgehalt und der Brauerei, die das Bier hergestellt hat.
 * Diese Klasse erbt von der AlkoholischesGetraenk-Klasse.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 04.05.2023 / 23:00Uhr
 */
public class Bier extends AlkoholischesGetraenk {

    // Instanzvariable für die Brauerei, die das Bier hergestellt hat
    private String brauerei;

    /**
     * Standard-Konstruktor, der ein Bier-Objekt ohne Namen, Alkoholgehalt und Brauerei erstellt.
     */
    public Bier(){
        super();
        this.brauerei = null;
    }

    /**
     * Konstruktor, der ein Bier-Objekt mit einer gegebenen Brauerei, aber ohne Namen und Alkoholgehalt erstellt.
     * @param brauerei die Brauerei, die das Bier hergestellt hat
     * @throws GetraenkException falls die Brauerei leer ist
     */
    public Bier(String brauerei){
        super();
        setBrauerei(brauerei);
    }

    /**
     * Konstruktor, der ein Bier-Objekt mit einer gegebenen Brauerei, Alkoholgehalt und Name erstellt.
     * @param brauerei die Brauerei, die das Bier hergestellt hat
     * @param alkoholgehalt der Alkoholgehalt des Biers
     * @param name der Name des Biers
     * @throws GetraenkException falls der Alkoholgehalt negativ oder kein Float ist oder die Brauerei leer ist
     */
    public Bier(String brauerei, Float alkoholgehalt, String name){
        super(alkoholgehalt, name);
        setBrauerei(brauerei);
    }

    /**
     * Getter-Methode für die Brauerei, die das Bier hergestellt hat
     * @return die Brauerei, die das Bier hergestellt hat
     */
    public String getBrauerei() {
        return brauerei;
    }

    /**
     * Setter-Methode für die Brauerei, die das Bier hergestellt hat
     * @param brauerei die zu setzende Brauerei, die das Bier hergestellt hat
     * @throws GetraenkException falls die Brauerei leer ist
     */
    public void setBrauerei(String brauerei) {
        GetraenkException.stringLeer(brauerei);
        this.brauerei = brauerei;
    }

    /**
     * Diese Methode vergleicht das aktuelle Bier-Objekt mit einem anderen Objekt auf Gleichheit.
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
        Bier tmp = (Bier) o;
        return brauerei.equals(tmp.brauerei);
    }

    /**
     * Gibt eine String-Repräsentation des Bier-Objekts zurück.
     * @return eine String-Repräsentation des Bier-Objekts
     */
    @Override
    public String toString() {
        return super.toString() +
                "Brauerei = " + brauerei + "\n";
    }
}
