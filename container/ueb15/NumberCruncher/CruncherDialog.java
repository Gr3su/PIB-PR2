package ueb15.NumberCruncher;

import java.util.Scanner;

public final class CruncherDialog {
    //Prompts
    private static final String     PROMPT_EINGABE_WERTE        = "Bitte gebe die gewuenschten Werte durch ein Leerzeichen" +
                                                                    " getrennt, nebeneinander ein:\n";
    private static final String     PROMPT_ARRAY_AUTO           = "Moechtest du das Array automatisch erstellen lassen?" +
                                                                    "(1: Ja / 2: Nein)\n";
    private static final String     PROMPT_ARRAY_LAENGE         = "Die Anzahl der zufaelligen Werte:\n";
    private static final String     PROMPT_OPTIONEN             = "#=# Option Auswahl #=#\n" +
                                                                    "1 - Operation uebergeben\n" +
                                                                    "2 - Array ausgeben\n" +
                                                                    "3 - Neues Array erstellen\n" +
                                                                    "4 - Dialog beenden\n";
    private static final String     PROMPT_EINGABE_OPERATIONEN  = "Bitte gebe die gewuenschten Operationen durch " +
                                                                    "ein Leerzeichen getrennt, nebeneinander ein.\n" +
                                                                    "Zur Auswahl stehen:\n" +
                                                                    "sum\n" +
                                                                    "swirl\n" +
                                                                    "divide\n" +
                                                                    "subtract\n" +
                                                                    "average\n";

    //Errors
    private static final String     ERROR_KEIN_FLOAT    = "Die Eingabe entsprach nicht einer Gleitkommazahl." +
                                                          " Bitte erneut eingeben:\n";
    private static final String     ERROR_KEIN_BYTE     = "Die Eingabe entsprach nicht einer Byte-Zahl." +
                                                          " Bitte erneut eingeben:\n";
    private static final String     ERROR_KEIN_INT      = "Die Eingabe entsprach nicht einer Int-Zahl." +
                                                          " Bitte erneut eingeben:\n";
    private static final String     ERROR_KEIN_ARRAY    = "Es wurde noch kein Array erstellt. Option wurde " +
                                                            "uberschrieben.\n";

    //Attributes
    private boolean killProgramm;
    private Scanner scanner;
    private float [] values;
    private NumberCruncher [] crunchers;

    private CruncherDialog(){
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        killProgramm = false;

        while(!killProgramm){
            try {
                byte option = readByte(PROMPT_OPTIONEN);

                if(values == null && option != 3){
                    option = 3;
                    System.err.println(ERROR_KEIN_ARRAY);
                }

                switch (option){
                    case 1:
                        operationenAblauf();
                        break;

                    case 2:
                        for(NumberCruncher cruncher: crunchers){
                            System.out.println(cruncher.getClass().getName());
                            System.out.println(cruncher + "\n");
                        }
                        break;

                    case 3:
                        arrayErstellen();
                        crunchers = new NumberCruncher[] { new NumberCruncherTopLevel(values),
                                                            new NumberCruncherAnonym(values)};
                        break;

                    case 4:
                        killProgramm = true;
                        break;

                }

            }
            catch(Exception e){
                System.err.println(e.getMessage());
            }
        }
    }

    private void operationenAblauf(){
        String eingabe = readString(PROMPT_EINGABE_OPERATIONEN);
        for(NumberCruncher cruncher: crunchers){
            cruncher.crunch(eingabe.split(" +"));
        }
    }

    private void arrayErstellen(){
        //Automatische Auffuellen
        byte automatic = readByte(PROMPT_ARRAY_AUTO);
        if(automatic == 1){
            int arrayLaenge = readInt(PROMPT_ARRAY_LAENGE);
            DialogException.arrayLaenge(arrayLaenge);

            values = new float[arrayLaenge];
            for(int i = 0; i < arrayLaenge; i++){
                int deziStellen = (int)(Math.random() * 10);
                values[i] = (float)(Math.random() * Math.pow(10.0, deziStellen));
            }

            return;
        }

        //Manuelles Auffuellen
        String eingabe = readString(PROMPT_EINGABE_WERTE);
        String [] eingabeGetrennt = eingabe.split(" +");
        values = new float[eingabeGetrennt.length];

        for(int i = 0; i < eingabeGetrennt.length; i++){
            DialogException.stringIsFloat(eingabeGetrennt[i].strip());

            values[i] = Float.parseFloat(eingabeGetrennt[i]);
        }
    }

    private String readString(String prompt){
        System.out.println(prompt);
        scanner.nextLine();
        return scanner.nextLine();
    }

    private float readFloat(String prompt){
        System.out.println(prompt);

        while(!scanner.hasNextFloat()){
            System.err.println(ERROR_KEIN_FLOAT);
            scanner.next();
        }

        return scanner.nextFloat();
    }

    private int readInt(String prompt){
        System.out.println(prompt);

        while(!scanner.hasNextInt()){
            System.err.println(ERROR_KEIN_INT);
            scanner.next();
        }

        return scanner.nextInt();
    }

    private byte readByte(String prompt){
        System.out.println(prompt);

        while(!scanner.hasNextByte()){
            System.err.println(ERROR_KEIN_BYTE);
            scanner.next();
        }

        return scanner.nextByte();
    }

    public static void main(String[] args) {
        new CruncherDialog().start();
    }
}
