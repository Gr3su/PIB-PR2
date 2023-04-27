package ueb13;
/**
 * Klasse Person.
 * 
 * @author Tim Mueller / Yannick Gross
 * @version 16.04.2023 / 20:00
 */
public abstract class Person {
    //Prompts
    private static final String     ERROR_VORNAME_LEER  = "Vorname darf nicht leer sein.\n";
    private static final String     ERROR_NACHNAME_LEER = "Nachname darf nicht leer sein.\n";

    //Attributes
    private String vorname;
    private String nachname;

    /**
     * Personen-Konstruktor um ein Personen Objekt zu erstellen.
     *
     * @param vorname Vorname.
     * @param nachname Nachname.
     */
    public Person(String vorname, String nachname) {
        if(vorname == null || vorname.isBlank()){
            throw new ExpectedException(ERROR_VORNAME_LEER);
        }
        if(nachname == null || nachname.isBlank()){
            throw new ExpectedException(ERROR_NACHNAME_LEER);
        }

        this.vorname = vorname.strip();
        this.nachname = nachname.strip();
    }

    /**
     * Gibt den Vornamen der Person zurueck.
     *
     * @return Vorname der Person.
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * Gibt den Nachnamen der Person zurueck.
     *
     * @return Nachname der Person.
     */
    public String getNachname() {
        return nachname;
    }

    /**
     * Bereitet die Attribute einer Person in folgendem Format auf: Vorname Nachname.
     * @return String mit vollem Namen.
     */
    @Override
    public String toString() {
        return vorname + " " + nachname;
    }

    /**
     * Ueberprueft ob ein Objekt gleich dem aufrufenden Personen Objekt ist.
     *
     * @param obj Zu vergleichendes Objekt.
     * @return Boolean ob Objekte gleich.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if(! (obj instanceof Person)){
            return false;
        }
        Person person = (Person) obj;
        return person.getVorname().equals(this.vorname) && person.getNachname().equals(this.nachname);
    }

}