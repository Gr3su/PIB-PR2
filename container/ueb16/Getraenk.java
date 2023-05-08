package ueb16;
import java.util.Objects;

/**
 * Die Getraenk-Klasse repräsentiert ein Getränk-Objekt mit einem Namen.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 04.05.2023 / 23:00Uhr
 */
public abstract class Getraenk {

    // Instanzvariable für den Namen des Getränks
    private String name;

    /**
     * Standard-Konstruktor, der ein Getraenk-Objekt ohne Namen erstellt.
     */
    public Getraenk(){
        this.name = null;
    };

    /**
     * Konstruktor, der ein Getraenk-Objekt mit einem gegebenen Namen erstellt.
     * @param name der Name des Getränks
     * @throws GetraenkException falls der Name leer ist
     */
    public Getraenk(String name){
        GetraenkException.stringLeer(name);
        this.name = name;
    };

    /**
     * Getter-Methode für den Namen des Getränks
     * @return der Name des Getränks
     */
    public String getName() {
        return name;
    }

    /**
     * Setter-Methode für den Namen des Getränks
     * @param name der zu setzende Name des Getränks
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Diese Methode vergleicht das aktuelle Getraenk-Objekt mit einem anderen Objekt auf Gleichheit.
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
        Getraenk tmp = (Getraenk) o;
        return name.equals(tmp.name);
    }

    /**
     * Gibt eine String-Repräsentation des Getraenk-Objekts zurück.
     * @return eine String-Repräsentation des Getraenks-Objekts
     */
    @Override
    public String toString() {
        return
                "Name = " + name +"\n";
    }
}
