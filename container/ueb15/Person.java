package ueb15;


/**
 * Klasse Person die ein Objekt mit Vor- und Nachnamen erstellt.
 *
 * @author Tim Mueller / Yannick Gross
 * @version 19.01.2023 / 11:00Uhr
 */
public final class Person{

    private String vorname;
    private String nachname;

    // private Person(){};

    /**
     * Erstellt eine Person mit Vor- und Nachnamen.
     *
     * @param vorname Vorname der Person.
     * @param nachname Nachname der Person.
     */
    public Person(String vorname, String nachname){
        if(vorname == null || vorname.isBlank()){
            throw new IllegalArgumentException(ErrorMessages.PERSON_VORNAME_LEER.getMessage());
        }
        if(nachname == null || nachname.isBlank()){
            throw new IllegalArgumentException(ErrorMessages.PERSON_NACHNAME_LEER.getMessage());
        }
        if(!vorname.matches("[a-zA-Z]+") || !nachname.matches("[a-zA-Z]+")){
            throw new IllegalArgumentException(ErrorMessages.NAMEN_KEINE_SONDERZEICHEN.getMessage());
        }
        this.vorname = vorname.strip();
        this.nachname = nachname.strip();
    }

    public String getVorname(){
        return vorname;
    }

    public String getNachname(){
        return nachname;
    }

    public void setVorname(String vorname){
        if(vorname == null || vorname.isBlank()){
            throw new IllegalArgumentException(ErrorMessages.PERSON_VORNAME_LEER.getMessage());
        }

        this.vorname = vorname.strip();
    }

    public void setNachname(String nachname){
        if(nachname == null || nachname.isBlank()){
            throw new IllegalArgumentException(ErrorMessages.PERSON_NACHNAME_LEER.getMessage());
        }

        this.nachname = nachname.strip();
    }

    @Override
    public String toString(){
        return nachname + ", " + vorname;
    }
}
