package ueb16;

import java.util.Scanner;

/**
 * Dialog fuer Getraenkeautomat.
 *
 * @author Yannick Gross / Tim Mueller
 * @version 05.05.2023 / 13:00Uhr
 */
public class AutomatDialog <T extends Getraenk>{
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
    private static boolean killProgram = false;
    private static byte typeWahl;
    private Getraenkeautomat<T> automat;
    //private ArrayList<Getraenkeautomat> automaten;


    private AutomatDialog(){
        this.scanner = new Scanner(System.in);
        typeWahl = -1;
    }

    private AutomatDialog(Getraenkeautomat<T> automat){
        this.automat = automat;
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        byte option;

        while(!killProgram){
            option = -1;

            try{
                option = readByte(AUSGABE_HAUPTMENUE);
                DialogException.validateMenueOption(option);
                if(automat == null &&
                    option != 1){
                    option = 1;
                }

                switch(option){
                    case 0:
                        killProgram = true;
                        break;

                    case 1:
                        automatErstellen();
                        break;

                    case 2:
                        System.out.println(automat);
                        break;

                    case 3:
                        automatFuellen();
                        break;

                    case 4:
                        if(automat != null)
                            System.out.println(automat.flascheAusgeben());
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
            catch(GetraenkException e){
                System.err.println("Fehler in Getraenk-Erstellung:");
                System.err.println(e.getMessage());
            }
            catch(Exception e){
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void automatErstellen() {

        int kapazitaet = readInt(EINGABE_KAPAZITAET);
        byte getraenk = readByte(EINGABE_AUTOMAT_GETRAENK);
        this.typeWahl = getraenk;

        if (getraenk == 0){
            Getraenkeautomat<Getraenk> tmp = new Getraenkeautomat<>(kapazitaet);
            new AutomatDialog<Getraenk>(tmp).start();
            killProgram = true;
        }
        else if(getraenk == 1) {
            Getraenkeautomat<AlkoholischesGetraenk> tmp = new Getraenkeautomat<>(kapazitaet);
            new AutomatDialog<AlkoholischesGetraenk>(tmp).start();
            killProgram = true;
        }
        else if(getraenk == 2) {
            Getraenkeautomat<AlkoholfreiesGetraenk> tmp = new Getraenkeautomat<>(kapazitaet);
            new AutomatDialog<AlkoholfreiesGetraenk>(tmp).start();
            killProgram = true;
        }
        else if(getraenk == 3) {
            Getraenkeautomat<Wasser> tmp = new Getraenkeautomat<>(kapazitaet);
            new AutomatDialog<Wasser>(tmp).start();
            killProgram = true;
        }
        else if(getraenk == 4) {
            Getraenkeautomat<Softdrink> tmp = new Getraenkeautomat<>(kapazitaet);
            new AutomatDialog<Softdrink>(tmp).start();
            killProgram = true;
        }
        else if(getraenk == 5) {
            Getraenkeautomat<Bier> tmp = new Getraenkeautomat<>(kapazitaet);
            new AutomatDialog<Bier>(tmp).start();
            killProgram = true;
        }
        else if(getraenk == 6) {
            Getraenkeautomat<Wein> tmp = new Getraenkeautomat<>(kapazitaet);
            new AutomatDialog<Wein>(tmp).start();
            killProgram = true;
        }
        else if(getraenk == 7) {
            Getraenkeautomat<Rotwein> tmp = new Getraenkeautomat<>(kapazitaet);
            new AutomatDialog<Rotwein>(tmp).start();
            killProgram = true;
        }
        else if(getraenk == 8) {
            Getraenkeautomat<Weisswein> tmp = new Getraenkeautomat<>(kapazitaet);
            new AutomatDialog<Weisswein>(tmp).start();
            killProgram = true;
        }
    }

    @SuppressWarnings("unchecked cast")
    private void automatFuellen(){

        int getraenkeWahl = readInt(EINGABE_GETRANK_AUSWAHL);
        DialogException.validateGetraenkBeiFlasche(getraenkeWahl);

        String name = readString("Name des Getraenks:");

        if(getraenkeWahl < 2 && typeWahl < 2){
            String hersteller = readString("Name des Herstellers:");

            if(getraenkeWahl == 0 && typeWahl == 0){
                String quelle = readString("Wasserquelle:");
                automat.flascheEinlegen((Flasche<? extends T>) new Flasche<Wasser>(new Wasser(quelle, hersteller, name)));
            }
            else if(typeWahl == 1){
                float zuckergehalt = readFloat("Zuckergehalt:");
                automat.flascheEinlegen((Flasche<? extends T>) new Flasche<Softdrink>(new Softdrink(zuckergehalt, hersteller, name)));
            }
        }

        else if(getraenkeWahl > 1 && typeWahl > 1){
            float alkoholGehalt = readFloat("Alkoholgehalt:");

            if(getraenkeWahl == 2 && typeWahl == 2){
                String brauerei = readString("Name der Brauerei:");
                automat.flascheEinlegen((Flasche<? extends T>) new Flasche<>(new Bier(brauerei, alkoholGehalt, name)));
            }
            else{
                String weingut = readString("Weingut:");

                if(getraenkeWahl == 3 && typeWahl >= 3){
                    automat.flascheEinlegen((Flasche<? extends T>) new Flasche<>(new Wein(weingut, alkoholGehalt, name)));
                }
                else if (getraenkeWahl == 4 && typeWahl >= 3) {
                    automat.flascheEinlegen((Flasche<? extends T>) new Flasche<>(new Rotwein(weingut, alkoholGehalt, name)));
                }
                else if (getraenkeWahl == 5 && typeWahl >= 3) {
                    automat.flascheEinlegen((Flasche<? extends T>) new Flasche<>(new Weisswein(weingut, alkoholGehalt, name)));
                }
            }
        }
    }
/*
    public Getraenkeautomat automatenAuswahl(){
        for(int i = 0; i < automaten.size(); i++){
            System.out.println(i + " : " + automaten.get(i) + "\n");
        }

        int tmp = readInt(EINGABE_AUTOMATEN_AUSWAHL);
        DialogException.validateAutomatSelection(automaten.size(), tmp);

        return automaten.get(tmp);
    }
*/
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
