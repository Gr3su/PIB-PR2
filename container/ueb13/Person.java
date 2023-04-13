
/**
 * Beschreiben Sie hier die Klasse Person.
 *
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Person
{
    private String vorname;
    private String nachname;


    public Person(String vorname, String nachame){
        this.vorname  = vorname;
        this.nachname = nachname;
    }

    public String getVorname(){
        return vorname;
    }

    public String getNachname(){
        return nachname;
    }

    @Override
    public String toString(){
        return vorname + "," + nachname;
    }
}