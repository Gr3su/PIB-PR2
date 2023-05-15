package ueb16;

/**
 * Die Rotwein-Klasse repräsentiert ein Rotwein-Objekt, das von der Wein-Klasse erbt.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 04.05.2023 / 23:00Uhr
 */
public class Rotwein extends Wein {

    /**
     * Standard-Konstruktor, der ein Rotwein-Objekt ohne Namen, Alkoholgehalt und Weingut erstellt.
     */
    public Rotwein(){
        super();
    }

    /**
     * Konstruktor, der ein Rotwein-Objekt mit einem gegebenen Weingut, Alkoholgehalt und Name erstellt.
     * @param weingut das Weingut, das den Rotwein hergestellt hat
     * @param alkoholgehalt der Alkoholgehalt des Rotweins
     * @param name der Name des Rotweins
     * @throws GetraenkException falls der Alkoholgehalt negativ ist oder das Weingut leer ist
     */
    public Rotwein(String weingut, float alkoholgehalt, String name){
        super(weingut, alkoholgehalt, name);
    }

    /**
     * Diese Methode vergleicht das aktuelle Rotwein-Objekt mit einem anderen Objekt auf Gleichheit.
     * @param o das Objekt zum Vergleichen
     * @return true, wenn die Objekte gleich sind, false sonst
     */
    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }

    /**
     * Gibt eine String-Repräsentation des Rotwein-Objekts zurück.
     * @return eine String-Repräsentation des Rotwein-Objekts
     */
    @Override
    public String toString() {
        return super.toString() + "Wein = Rotwein";
    }
}
