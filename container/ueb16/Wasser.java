package ueb16;

/**
 * Die Wasser-Klasse repräsentiert ein Wasser-Objekt mit einem Namen, Hersteller und Quelle.
 * Diese Klasse erbt von der AlkoholfreiesGetraenk-Klasse.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 04.05.2023 / 23:00Uhr
 */
public class Wasser extends AlkoholfreiesGetraenk{

    // Instanzvariable für die Quelle des Wassers
    private String quelle;

    /**
     * Standard-Konstruktor, der ein Wasser-Objekt ohne Name, Hersteller und Quelle erstellt.
     */
    public Wasser(){
        super();
    }

    /**
     * Konstruktor, der ein Wasser-Objekt mit einer gegebenen Quelle, aber ohne Name und Hersteller erstellt.
     * @param quelle die Quelle des Wassers
     * @throws GetraenkException falls die Quelle leer ist
     */
    public Wasser(String quelle){
        super();
        setQuelle(quelle);
    }

    /**
     * Konstruktor, der ein Wasser-Objekt mit einer gegebenen Quelle, Hersteller und Name erstellt.
     * @param quelle die Quelle des Wassers
     * @param hersteller der Hersteller des Wassers
     * @param name der Name des Wassers
     * @throws GetraenkException falls der Hersteller oder die Quelle leer sind
     */
    public Wasser(String quelle, String hersteller, String name){
        super(hersteller, name);

        setQuelle(quelle);
    }

    /**
     * Getter-Methode für die Quelle des Wassers
     * @return die Quelle des Wassers
     */
    public String getQuelle() {
        return quelle;
    }

    /**
     * Setter-Methode für die Quelle des Wassers
     * @param quelle die zu setzende Quelle des Wassers
     * @throws GetraenkException falls die Quelle leer ist
     */
    public void setQuelle(String quelle) {
        GetraenkException.stringLeer(quelle);
        this.quelle = quelle;
    }

    /**
     * Diese Methode vergleicht das aktuelle Wasser-Objekt mit einem anderen Objekt auf Gleichheit.
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
        Wasser tmp = (Wasser) o;
        return quelle.equals(tmp.quelle);
    }


    /**
     * Gibt eine String-Repräsentation des Wasser-Objekts zurück.
     * @return eine String-Repräsentation des Wasser-Objekts
     */
    @Override
    public String toString() {
        return super.toString() +
                "Quelle = " + quelle + "\n";
    }
}
