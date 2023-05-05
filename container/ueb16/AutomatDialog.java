package ueb16;

import ueb15.ErrorMessages;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Dialog fuer Getraenkeautomat.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 05.05.2023 / 13:00Uhr
 */
public class AutomatDialog {
    //Prompts
    private static final String AUSGABE_HAUPTMENUE          = "0 - Dialog beenden\n" +
                                                                "1 - Automat erstellen\n" +
                                                                "2 - Automaten ausgeben\n" +
                                                                "3 - Automat fuellen\n" +
                                                                "4 - Automat leeren\n";
    private static final String EINGABE_KAPAZITAET          = "Die Kapazitaet des Automaten:\n";
    private static final String EINGABE_AUTOMAT_GETRAENK    = "Bitte waehle aus folgender Beschraenkung an " +
                                                                "Getraenken aus:\n" +
                                                                "0 - Getraenke\n" +
                                                                "1 - Alkoholische Getraenke\n" +
                                                                "2 - Alkoholfreie Getraenke\n" +
                                                                "3 - Wasser\n" +
                                                                "4 - Softdrink\n" +
                                                                "5 - Bier\n" +
                                                                "6 - Wein\n" +
                                                                "7 - Rotwein\n" +
                                                                "8 - Weisswein";
    private static final String EINGABE_GETRANK_AUSWAHL     = "Bitte waehle ein folgendes Getraenk aus:\n" +
                                                                "0 - Wasser\n" +
                                                                "1 - Softdrink\n" +
                                                                "2 - Bier\n" +
                                                                "3 - Wein\n" +
                                                                "4 - Rotwein\n" +
                                                                "5 - Weisswein";
    private static final String EINGABE_AUTOMATEN_AUSWAHL = "Bitte einen Automaten auswaehlen:";

    //Errors
    private static final String ERROR_KEIN_BYTE     = "Eingegebene Zeichen sind kein byte.";
    private static final String ERROR_KEIN_FLOAT    = "Eingegebene Zeichen sind kein float.";
    private static final String ERROR_KEIN_INT      = "Eingegebene Zeichen sind kein int.";

    //Attributes
    private Scanner scanner;
    private ArrayList<Getraenkeautomat<?>> automaten;

    private AutomatDialog(){
        this.scanner = new Scanner(System.in);
        automaten = new ArrayList<>();
    }

    public void start(){
        byte option;

        while(true){
            option = -1;

            try{
                option = readByte(AUSGABE_HAUPTMENUE);
                DialogException.validateMenueOption(option);

                switch(option){
                    case 0:
                        return;

                    case 1:
                        automatErstellen();
                        break;

                    case 2:
                        System.out.println(automatenAuswahl());
                        break;

                    case 3:
                        automatFuellen();
                        break;

                    case 4:
                        System.out.println(automatenAuswahl().flascheAusgeben());
                        break;
                }
            }
            catch(GetraenkeautomatException e){
                System.err.println("Fehler in Getraenkeautomat:");
                System.err.println(e.getMessage());
            }
            catch(DialogException e){
                System.err.println("Fehler in Dialog:");
                System.err.println(e.getMessage());
            }
            catch(GetraenkeException e){
                System.err.println("Fehler in Getraenk-Erstellung:");
                System.err.println(e.getMessage());
            }
            catch(Exception e){
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void automatErstellen(){
        int kapazitaet = readInt(EINGABE_KAPAZITAET);
        byte getraenk = readByte(EINGABE_AUTOMAT_GETRAENK);

        switch (getraenk){
            case 0:
                automaten.add(new Getraenkeautomat<Getraenk>(kapazitaet));
                break;

            case 1:
                automaten.add(new Getraenkeautomat<AlkoholischesGetraenk>(kapazitaet));
                break;

            case 2:
                automaten.add(new Getraenkeautomat<AlkoholfreiesGetraenk>(kapazitaet));
                break;

            case 3:
                automaten.add(new Getraenkeautomat<Wasser>(kapazitaet));
                break;

            case 4:
                automaten.add(new Getraenkeautomat<Softdrink>(kapazitaet));
                break;

            case 5:
                automaten.add(new Getraenkeautomat<Bier>(kapazitaet));
                break;

            case 6:
                automaten.add(new Getraenkeautomat<Wein>(kapazitaet));
                break;

            case 7:
                automaten.add(new Getraenkeautomat<Rotwein>(kapazitaet));
                break;

            case 8:
                automaten.add(new Getraenkeautomat<Weisswein>(kapazitaet));
                break;


        }
    }

    public Getraenkeautomat automatenAuswahl(){
        for(int i = 0; i < automaten.size(); i++){
            System.out.println(i + " : " + automaten.get(i) + "\n");
        }

        int tmp = readInt(EINGABE_AUTOMATEN_AUSWAHL);
        DialogException.validateAutomatSelection(automaten.size(), tmp);

        return automaten.get(tmp);
    }

    private void automatFuellen(){
        Getraenkeautomat automat = automatenAuswahl();
        int getraenkeWahl = readInt(EINGABE_GETRANK_AUSWAHL);
        DialogException.validateGetraenkBeiFlasche(getraenkeWahl);

        String name = readString("Name des Getraenks:");

        if(getraenkeWahl < 2){
            String hersteller = readString("Name des Herstellers:");

            if(getraenkeWahl == 0){
                String quelle = readString("Wasserquelle:");
                automat.flascheEinlegen(new Flasche<Wasser>(new Wasser(quelle, hersteller, name)));
            }
            else{
                float zuckergehalt = readFloat("Zuckergehalt:");
                automat.flascheEinlegen(new Flasche<Softdrink>(new Softdrink(zuckergehalt, hersteller, name)));
            }
        }

        else{
            float alkoholGehalt = readFloat("Alkoholgehalt:");

            if(getraenkeWahl == 2){
                String brauerei = readString("Name der Brauerei:");
                automat.flascheEinlegen(new Flasche<Bier>(new Bier(brauerei, alkoholGehalt, name)));
            }
            else{
                String weingut = readString("Weingut:");

                if(getraenkeWahl == 3){
                    automat.flascheEinlegen(new Flasche<Wein>(weingut, alkoholGehalt, name));
                }
                else if (getraenkeWahl == 4) {
                    automat.flascheEinlegen(new Flasche<Rotwein>(weingut, alkoholGehalt, name));
                }
                else if (getraenkeWahl == 5) {
                    automat.flascheEinlegen(new Flasche<Weisswein>(weingut, alkoholGehalt, name));
                }
            }
        }
    }

    private int readInt(String prompt){
        System.out.println(prompt);

        while(!scanner.hasNextInt()){
            System.err.println(ERROR_KEIN_INT);
            scanner.nextLine();
        }

        int tmp = scanner.nextInt();
        scanner.nextLine();

        return tmp;
    }

    private byte readByte(String prompt){
        System.out.println(prompt);

        while(!scanner.hasNextByte()){
            System.err.println(ERROR_KEIN_BYTE);
            scanner.nextLine();
        }

        byte tmp = scanner.nextByte();
        scanner.nextLine();

        return tmp;
    }

    private float readFloat(String prompt){
        System.out.println(prompt);

        while(!scanner.hasNextFloat()){
            System.err.println(ERROR_KEIN_FLOAT);
            scanner.nextLine();
        }

        float tmp = scanner.nextFloat();
        scanner.nextLine();

        return tmp;
    }

    private String readString(String prompt){
        System.out.println(prompt);

        return scanner.nextLine();
    }

    public static void main(String[] args) {
        new AutomatDialog().start();
    }
}
