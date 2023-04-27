package ueb15;
public interface PersonIterator {
    /**
     * Gibt true zuerueck, wenn der Iterator weitere Elemente enthaelt.
     * Ansonsten false.
     * @return true, wenn der Iterator weitere Elemente enthaelt.
     */
    boolean hasNext();

    /**
     * Gibt das naechste Person-Objekt zurueck.
     * @return das naechste Person-Objekt.
     */
    Person next();

}
