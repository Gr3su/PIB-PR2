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
    private static final String AUSGABE_HAUPTMENUE = "";

    //Attributes
    private Scanner scanner;
    private ArrayList<Getraenkeautomat<?>> automaten;

    private AutomatDialog(){
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        while(true){
            try{
                System.out.println(AUSGABE_HAUPTMENUE);
            }
            catch(GetraenkeautomatException e){
                System.err.println("Fehler in Getraenkeautomat:");
                e.printStackTrace();
            }
            catch(DialogException e){
                System.err.println("Fehler in Dialog:");
                e.printStackTrace();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    private int leseInt(String prompt){
        System.out.println(prompt);

        while(!scanner.hasNextInt()){
            System.err.println(ErrorMessages.KEIN_BYTE.getMessage());
            scanner.nextLine();
        }

        int tmp = scanner.nextInt();
        scanner.nextLine();

        return tmp;
    }

    private byte leseByte(String prompt){
        System.out.println(prompt);

        while(!scanner.hasNextByte()){
            System.err.println(ErrorMessages.KEIN_BYTE.getMessage());
            scanner.nextLine();
        }

        byte tmp = scanner.nextByte();
        scanner.nextLine();

        return tmp;
    }

    private String leseString(String prompt){
        System.out.println(prompt);

        return scanner.nextLine();
    }

    public static void main(String[] args) {
        new AutomatDialog().start();
    }
}
