package ueb16;

/**
 * Die Weisswein-Klasse repräsentiert ein Weisswein-Objekt, das von der Wein-Klasse erbt.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 04.05.2023 / 23:00Uhr
 */
public class Weisswein extends Wein {

    /**
     * Standard-Konstruktor, der ein Weisswein-Objekt ohne Namen, Alkoholgehalt und Weingut erstellt.
     */
    public Weisswein(){
        super();
    }

    /**
     * Konstruktor, der ein Weisswein-Objekt mit einem gegebenen Weingut, Alkoholgehalt und Name erstellt.
     * @param weingut das Weingut, das den Weisswein hergestellt hat
     * @param alkoholgehalt der Alkoholgehalt des Weissweins
     * @param name der Name des Weissweins
     * @throws GetraenkException falls der Alkoholgehalt negativ ist oder das Weingut leer ist
     */
    public Weisswein(String weingut, float alkoholgehalt, String name){
        super(weingut, alkoholgehalt, name);
    }

    /**
     * Diese Methode vergleicht das aktuelle Weisswein-Objekt mit einem anderen Objekt auf Gleichheit.
     * @param o das Objekt zum Vergleichen
     * @return true, wenn die Objekte gleich sind, false sonst
     */
    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }

    /**
     * Gibt eine String-Repräsentation des Weisswein-Objekts zurück.
     * @return eine String-Repräsentation des Weisswein-Objekts
     */
    @Override
    public String toString() {
        return super.toString() + "Wein = Weisswein";
    }
}

