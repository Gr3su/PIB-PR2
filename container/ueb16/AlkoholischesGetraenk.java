package ueb16;



/**
 * Die AlkoholischesGetraenk-Klasse repräsentiert ein alkoholisches Getränk-Objekt mit einem Namen und einem Alkoholgehalt.
 * Diese Klasse erbt von der Getraenk-Klasse.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 04.05.2023 / 23:00Uhr
 */
public abstract class AlkoholischesGetraenk extends Getraenk {

    // Instanzvariable für den Alkoholgehalt des Getränks
    private float alkoholgehalt;

    /**
     * Standard-Konstruktor, der ein AlkoholischesGetraenk-Objekt ohne Name und ohne Alkoholgehalt erstellt.
     */
    public AlkoholischesGetraenk(){
        super();
        this.alkoholgehalt = 0;
    }

    /**
     * Konstruktor, der ein AlkoholischesGetraenk-Objekt mit einem gegebenen Alkoholgehalt, aber ohne Name erstellt.
     * @param alkoholgehalt der Alkoholgehalt des Getränks
     * @throws GetraenkException falls der Alkoholgehalt negativ oder kein Float ist
     */
    public AlkoholischesGetraenk(float alkoholgehalt){
        super();
        setAlkoholgehalt(alkoholgehalt);
    }

    /**
     * Konstruktor, der ein AlkoholischesGetraenk-Objekt mit einem gegebenen Alkoholgehalt und gegebenem Namen erstellt.
     * @param alkoholgehalt der Alkoholgehalt des Getränks
     * @param name der Name des Getränks
     * @throws GetraenkException falls der Alkoholgehalt negativ oder kein Float ist
     */
    public AlkoholischesGetraenk(float alkoholgehalt, String name){
        super(name);
        setAlkoholgehalt(alkoholgehalt);
    }

    /**
     * Getter-Methode für den Alkoholgehalt des Getränks
     * @return der Alkoholgehalt des Getränks
     */
    public float getAlkoholgehalt() {
        return alkoholgehalt;
    }


    /**
     * Setter-Methode für den Alkoholgehalt des Getränks
     * @param alkoholgehalt der zu setzende Alkoholgehalt des Getränks
     * @throws GetraenkException falls der Alkoholgehalt negativ oder kein Float ist
     */
    public void setAlkoholgehalt(float alkoholgehalt) {
        GetraenkException.errorKeinFloat(String.valueOf(alkoholgehalt));
        GetraenkException.errorNegativ(alkoholgehalt);
        this.alkoholgehalt = alkoholgehalt;
    }

    /**
     * Diese Methode vergleicht das aktuelle AlkoholischesGetraenk-Objekt mit einem anderen Objekt auf Gleichheit.
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
        AlkoholischesGetraenk tmp = (AlkoholischesGetraenk) o;
        return Float.compare(tmp.alkoholgehalt, alkoholgehalt) == 0;
    }

    /**
     * Gibt eine String-Repräsentation des AlkoholischesGetraenk-Objekts zurück.
     * @return eine String-Repräsentation des AlkoholischesGetraenk-Objekts
     */
    @Override
    public String toString() {
        return super.toString() +
                "Alkoholgehalt = " + alkoholgehalt + "\n";
    }

}
