/**
 * Dialogklasse zum Testen der Uebung 13.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 12.04.2023 / 19:41Uhr
 */

import java.util.Scanner;

public final class Dialog {

    //Fehlermeldungen
    private static final String     ERROR_BYTE_NEEDED       = "Falscher Datentyp, bitte einen byte Wert eingeben.\n";
    private static final String     ERROR_INT_NEEDED        = "Falscher Datentyp, bitte einen int Wert eingeben.\n";
    private static final String     ERROR_OPTION_INVALID    = "Eingegebene Option wurde nicht gefunden.\n";
    private static final String     ERROR_MAX_MITARBEITER   = "Maximale Anzahl (20) an Mitarbeitern erreicht.\n";
    private static final String     ERROR_MAX_RAEUME        = "Maximale Anzahl (20) an Raeumen erreicht.\n";
    private static final String     ERROR_KEIN_MITARBEITER  = "Es wurde noch kein Mitarbeiter erstellt," +
            " bitte zuerst einen erstellen.\n";
    private static final String     ERROR_KEIN_RAUM         = "Es wurde noch kein Raum erstellt," +
            " bitte zuerst einen erstellen.\n";
    private static final String     ERROR_KEINE_RESERV      = "Es wurde noch keine Reservierung angelegt," +
            " bitte zuerst eine anlegen.\n";

    //Prompts
    private static final String     WELCOME_MESSAGE         = "Willkommen beim Test-Dialog fuer Uebung 13." +
            " Waehle aus dem Menue heraus:\n";

    private static final String     MAIN_MENUE              =   "#=# MAIN-Menue #=#\n" +
                                                                "1 - Uhrzeit Menue\n" +
                                                                "2 - Mitarbeiter Menue\n" +
                                                                "3 - Reservierung Menue\n" +
                                                                "4 - Raum Menue\n" +
                                                                "5 - Dialog beenden";
    private static final String     MITARBEITER_MENUE       =   "#=# MITARBEITER-Menue #=#\n" +
                                                                "1 - Mitarbeiter anlegen\n" +
                                                                "2 - Reservieren\n" +
                                                                "3 - toString()\n" +
                                                                "4 - Mitarbeiterliste\n" +
                                                                "5 - Main Menue";
    private static final String     RESERVIERUNG_MENUE      =   "#=# RESERVIERUNG-Menue #=#\n" +
                                                                "1 - Reservierung erstellen\n" +
                                                                "2 - Bemerkung aendern\n" +
                                                                "3 - Mitarbeiter aendern\n" +
                                                                "4 - Raum aendern\n" +
                                                                "5 - toString()\n" +
                                                                "6 - Reservierung beenden";
    private static final String     RAUM_MENUE              =   "#=# RAUM-Menue #=#\n" +
                                                                "1 - Raum erstellen\n" +
                                                                "2 - Reservierung hinzufuegen\n" +
                                                                "3 - toString()\n" +
                                                                "4 - getReservierung(index)\n" +
                                                                "5 - Main Menue";
    private static final String     EINGABE_STUNDEN         = "Bitte Stunden der Uhrzeit eingeben:\n";
    private static final String     EINGABE_MINUTEN         = "Bitte Minute der Uhrzeit eingeben:\n";
    private static final String     EINGABE_VORNAME         = "Bitte Vornamen eingeben:\n";
    private static final String     EINGABE_NACHNAME        = "Bitte Nachnamen eingeben:\n";
    private static final String     EINGABE_EMAIL           = "Bitte E-Mail eingeben:\n";
    private static final String     EINGABE_MITARBEITER     = "Bitte waehle einen Mitarbeiter aus:\n";
    private static final String     EINGABE_RAUM            = "Bitte waehle einen Raum aus:\n";
    private static final String     EINGABE_RESERV_BEGINN   = "Bitte gebe den Beginn der Reservierung an:\n";
    private static final String     EINGABE_RESERV_ENDE     = "Bitte gebe das Ende der Reservierung an:\n";
    private static final String     EINGABE_BEMERKUNG       = "Bitte gebe eine Bemerkung zur Reservierung an:\n";
    private static final String     EINGABE_GEBAEUDE        = "Bitte gebe die Gebaeude-Nummer ein:\n";
    private static final String     EINGABE_ETAGE           = "Bitte gebe die Etage ein:\n";
    private static final String     EINGABE_RAUMNUMMER      = "Bitte gebe die Raum-Nummer ein:\n";
    private static final String     EINGABE_BEGINN          = "Bitte gebe den Beginn der Reservierung ein:";
    private static final String     EINGABE_ENDE            = "Bitte gebe das Ende der Reservierung ein:";
    private static final String     EINGABE_INDEX           = "Bitte gebe deinen gewuenschten Index ein:\n";

    //Attributes
    private final Scanner scanner;
    private boolean killProgram;
    private Mitarbeiter [] mitarbeiterListe;
    private byte mitarbeiterAnzahl;
    private Raum [] raeume;
    private byte raumAnzahl;


    private Dialog(){
        this.scanner = new Scanner(System.in);
        this.killProgram = false;
        this.mitarbeiterListe = new Mitarbeiter[20];
        this.mitarbeiterAnzahl = 0;
        this.raeume = new Raum[20];
        this.raumAnzahl = 0;
    }

    /**
     * Kuemmert sich um das Hauptmenue und dem Abfangen von auftretenden Fehlern.
     */
    public void start(){
        int input;

        System.out.println(WELCOME_MESSAGE);

        while(!killProgram){
            try{
                input = readByte(MAIN_MENUE);

                switch(input){
                    case 1:
                        uhrzeitMenue();
                        break;

                    case 2:
                        mitarbeiterMenue();
                        break;

                    case 3:
                        reservierungMenue();
                        break;

                    case 4:
                        raumMenue();
                        break;

                    case 5:
                        killProgram = true;
                        break;

                    default:
                        throw new IllegalArgumentException(ERROR_OPTION_INVALID);
                }
            }
            catch(ExpectedException e){
                System.err.println("-Erwarteter Fehler-\n" + e.getMessage());
            }
            catch(Exception e){
                System.err.println("-Unerwarteter Fehler-\n" + e.getMessage());
            }
        }
    }

    /**
     * Managed die Möglichkeit eine Uhrzeit zu erstellen und fuehrt dann die toString() Methode auf das
     * Objekt aus.
     */
    public void uhrzeitMenue(){
        Uhrzeit uhrzeit = uhrzeitErstellen();
        System.out.println("toString()-Test: " + uhrzeit);
    }

    /**
     * Managed das Menue um die Klasse Mitarbeiter zu testen.
     */
    public void mitarbeiterMenue(){

        while(true){
            byte input = readByte(MITARBEITER_MENUE);

            switch(input){
                case 1:
                    if(mitarbeiterAnzahl == 20){
                        throw new ExpectedException(ERROR_MAX_MITARBEITER);
                    }

                    String vorname = readString(EINGABE_VORNAME);
                    String nachname = readString(EINGABE_NACHNAME);
                    String email = readString(EINGABE_EMAIL);

                    mitarbeiterListe[mitarbeiterAnzahl++] = new Mitarbeiter(vorname, nachname, email);
                    break;

                case 2:
                    Mitarbeiter tmpMitarb = mitarbeiterAuswahl();
                    Raum tmpRaum = raumAuswahl();
                    System.out.println(EINGABE_RESERV_BEGINN);
                    Uhrzeit tmpBeginn = uhrzeitErstellen();
                    System.out.println(EINGABE_RESERV_ENDE);
                    Uhrzeit tmpEnde = uhrzeitErstellen();
                    String bemerkung = readString(EINGABE_BEMERKUNG);

                    tmpMitarb.reserviere(tmpRaum, tmpBeginn, tmpEnde, bemerkung);
                    break;

                case 3:
                    System.out.println(mitarbeiterAuswahl().toString());
                    break;

                case 4:
                    System.out.println("Mitarbeiterliste:\n");
                    for(int i = 0; i < mitarbeiterAnzahl; i++){
                        System.out.println(i + " - " + mitarbeiterListe[i]);
                    }
                    break;

                case 5:
                    return;

                default:
                    throw new IllegalArgumentException(ERROR_OPTION_INVALID);

            }
        }
    }

    /**
     * Managed das Menue um die Klasse Reservierung zu testen und zu nutzen.
     *
     * @return erstelltes Reservierungs Objekt
     */
    public Reservierung reservierungMenue(){
        Reservierung reservierung = null;

        while(true){
            byte input = readByte(RESERVIERUNG_MENUE);

            switch(input){
                case 1:
                    System.out.println(EINGABE_BEGINN);
                    Uhrzeit beginn = uhrzeitErstellen();
                    System.out.println(EINGABE_ENDE);
                    Uhrzeit ende = uhrzeitErstellen();

                    reservierung = new Reservierung(beginn, ende);
                    break;

                case 2:
                    if(reservierung == null) {
                        System.err.println(ERROR_KEINE_RESERV);
                        break;
                    }
                    String bemerkung = readString(EINGABE_BEMERKUNG);
                    reservierung.setBemerkung(bemerkung);
                    break;

                case 3:
                    if(reservierung == null) {
                        System.err.println(ERROR_KEINE_RESERV);
                        break;
                    }
                    reservierung.setMitarbeiter(mitarbeiterAuswahl());
                    break;

                case 4:
                    if(reservierung == null) {
                        System.err.println(ERROR_KEINE_RESERV);
                        break;
                    }

                    reservierung.setRaum(raumAuswahl());
                    break;

                case 5:
                    if(reservierung == null) {
                        System.err.println(ERROR_KEINE_RESERV);
                        break;
                    }
                    System.out.println("toString()-Test:\n" + reservierung);
                    break;

                case 6:
                    return reservierung;

                default:
                    throw new IllegalArgumentException(ERROR_OPTION_INVALID);
            }
        }
    }

    /**
     * Managed das Menue um die Klasse Raum zu testen.
     */
    public void raumMenue(){

        while(true){
            byte input = readByte(RAUM_MENUE);

            switch(input){
                case 1:
                    if(raumAnzahl == 20){
                        throw new ExpectedException(ERROR_MAX_RAEUME);
                    }

                    int geb = readInt(EINGABE_GEBAEUDE);
                    int etage = readInt(EINGABE_ETAGE);
                    int raum = readInt(EINGABE_RAUMNUMMER);

                    raeume[raumAnzahl++] = new Raum(geb, etage, raum);
                    break;

                case 2:
                    Raum tmpRaum = raumAuswahl();
                    tmpRaum.addReservierung(reservierungMenue());
                    break;

                case 3:
                    System.out.println(raumAuswahl());
                    break;

                case 4:
                    Raum indexRaum = raumAuswahl();
                    int index = readInt(EINGABE_INDEX);
                    System.out.println(indexRaum.getReservierung(index));
                    break;

                case 5:
                    return;

                default:
                    throw new IllegalArgumentException(ERROR_OPTION_INVALID);
            }
        }
    }

    /**
     * Nimmt Eingaben vom User um eine Uhrzeit zu erstellen.
     *
     * @return Uhrzeit Objekt
     */
    private Uhrzeit uhrzeitErstellen(){
        byte stunden = readByte(EINGABE_STUNDEN);
        byte minuten = readByte(EINGABE_MINUTEN);

        return new Uhrzeit(stunden, minuten);
    }

    /**
     * Printed eine Liste der Mitarbeiter und laesst den User einen davon auswaehlen.
     *
     * @return ausgewaehlter User
     */
    private Mitarbeiter mitarbeiterAuswahl(){
        if(mitarbeiterAnzahl == 0){
            throw new ExpectedException(ERROR_KEIN_MITARBEITER);
        }

        for(int i = 0; i < mitarbeiterAnzahl; i++){
            System.out.println(i + " - " + mitarbeiterListe[i].toString());
        }
        byte input = readByte(EINGABE_MITARBEITER);

        if(input < 0 || input >= mitarbeiterAnzahl){
            throw new ExpectedException(ERROR_OPTION_INVALID);
        }

        return mitarbeiterListe[input];
    }

    /**
     * Printed eine Liste der Raeume und laesst den User einen davon auswaehlen.
     *
     * @return ausgewaehlter Raum
     */
    private Raum raumAuswahl(){
        if(raumAnzahl == 0){
            throw new ExpectedException(ERROR_KEIN_RAUM);
        }

        for(int i = 0; i < raumAnzahl; i++){
            System.out.println(i + " - " + raeume[i].toString());
        }
        byte input = readByte(EINGABE_RAUM);

        if(input < 0 || input >= raumAnzahl){
            throw new ExpectedException(ERROR_OPTION_INVALID);
        }

        return raeume[input];
    }

    /**
     * Liesst einen String ein und gibt ihn zurueck.
     *
     * @param prompt String der auf's Terminal gedruckt wird.
     * @return eingelesener String
     */
    private String readString(String prompt){
        System.out.println(prompt);
        return scanner.next();
    }

    /**
     * Liesst einen byte ein und gibt ihn zurueck.
     *
     * @param prompt String der auf's Terminal gedruckt wird.
     * @return eingelesener byte
     */
    private byte readByte(String prompt){
        System.out.println(prompt);

        while(!scanner.hasNextByte()){
            System.out.println(ERROR_BYTE_NEEDED);
            scanner.next();
        }
        byte tmp = scanner.nextByte();
        scanner.nextLine();
        return tmp;
    }

    /**
     * Liesst einen int ein und gibt ihn zurueck.
     *
     * @param prompt String der auf's Terminal gedruckt wird.
     * @return eingelesener int
     */
    private int readInt(String prompt){
        System.out.println(prompt);

        while(!scanner.hasNextInt()){
            System.out.println(ERROR_INT_NEEDED);
            scanner.next();
        }
        int tmp = scanner.nextInt();
        scanner.nextLine();
        return tmp;
    }

    public static void main(String [] args){
        new Dialog().start();
    }
}