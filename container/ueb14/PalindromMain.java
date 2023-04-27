package ueb14;
import java.io.*;
/**
 * Klasse um Palindrom Methoden mit Aufrufparametern oder gefuellter Datei zu testen.
 *
 * @author Tim Mueller / Yannick Gross
 * @version 23.04.2023 / 18:00Uhr
 */
public class PalindromMain {
    //Error-Messages
    private static final String ERROR_NO_ARGUMENT = "Kein Uebergabeparameter mit gegeben.\n";

    //Prompts
    private static final String FILE_RESULTS_NAME = "testResults.csv";
    private static final String MESSUNG_HEADER = "Laenge, Rekursiv, Iterativ\n";

    //Attributes
    private StringBuilder userAusgabe;
    private StringBuilder messungAusgabe;

    /**
     * Konstruktor um Ausgabevariablen zu initialisieren.
     */
    public PalindromMain(){
        this.userAusgabe = new StringBuilder();
        this.messungAusgabe = new StringBuilder(MESSUNG_HEADER);
    }

    /**
     * Terminal Ausgabe-String.
     *
     * @param method Palindrom Methode
     * @param word Word das geprueft wurde
     * @param bool true oder false ob Palindrom
     */
    public void addToAusgabe(String method, String word, boolean bool){
        userAusgabe.append(String.format("%20s - %10s - %b\n", method, word, bool));
    }

    /**
     *
     * @return userAusgabe
     */
    public StringBuilder getUserAusgabe(){
        return userAusgabe;
    }

    /**
     * Geht Datei zeilenweise durch und uebergibt jedes Wort einzeln an checkForPalindrom() weiter.
     *
     * @param file Datei die gelesen wird
     */
    private void goThroughFile(File file){
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            String [] words;

            while((line = reader.readLine()) != null){
                words = line.split(" +");
                for(String word: words){
                    if(word != null){
                        checkForPalindrom(word);
                    }
                }
            }
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Geht jede Methode durch und misst dabei die Zeit wie lang sie gebraucht hat.
     * Wenn neue Methode implementiert muss sie in Array methods hinzugefuegt werden.
     *
     * @param word Zu ueberpruefendes Wort
     */
    private void checkForPalindrom(String word){
        Palindrom [] methods = { new PalindromRekursiv(),
                                new PalindromIterativ()};
        boolean palindrom;
        long begin;
        long end;
        messungAusgabe.append(word.length());

        for(Palindrom method: methods){

            begin = System.nanoTime();
            palindrom = method.istPalindrom(word);
            end = System.nanoTime();
            
            addToAusgabe(method.getClass().getName(), word, palindrom);
            long p = end - begin;
            messungAusgabe.append(", " + p);
        }
        messungAusgabe.append("\n");
    }

    /**
     * Schreibt Datei namens (Varible)FILE_RESULTS_NAME mit den Woerterlaengen und die
     * Dauer der Ausfuehrung der einzelnen Methoden.
     */
    private void writeFile(){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_RESULTS_NAME))){
            String tmp = messungAusgabe.toString();
            writer.write(tmp);
        }
        catch(Exception e){
            System.err.println("FileWriter:\n" + e.getMessage());
        }
    }

    public static void main(String [] args){
        if(args.length == 0){
            throw new IllegalArgumentException(ERROR_NO_ARGUMENT);
        }

        PalindromMain output = new PalindromMain();
        File file;
        try{
            file = FileValidationException.fileValidation(args[0]);
            output.goThroughFile(file);
        }
        catch(Exception e){
            output.checkForPalindrom(args[0]);
        }

        System.out.println(output.getUserAusgabe());
        output.writeFile();
    }
}
