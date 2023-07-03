package ueb21.Aufgabe6;

/**
 * Fehlermeldungen fuer alle Klassen.
 *
 * @author  Tim Mueller / Yannick Gross
 * @version 27.01.2023 / 11:00Uhr
 */
public enum ErrorMessages{
    KEINE_JAVA_DATEI("#ERR#\n%1$s\nUebergebene Datei keine Java Datei.\n#ERR#"),
    DATEI_EXISTIERT_NICHT("#ERR#\n%1$s\nUebergebene Datei existiert nicht.\n#ERR#"),
    DATEI_NICHT_LESBAR("#ERR#\n%1$s\nUebergebene Datei ist nicht lesbar\n#ERR#"),
    PFAD_KEINE_DATEI("#ERR\n%1$s\nUebergebener Pfad ist keine Datei.\n#ERR#"),
    UNERWARTETER_FEHLER("#ERR#\nEin unerwarteter Fehler ist aufgetreten.\n#ERR#");

    private String message;

    private ErrorMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
