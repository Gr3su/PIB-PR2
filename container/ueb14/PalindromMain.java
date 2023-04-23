import java.io.*;

public class PalindromMain {
    //Error-Messages
    private static final String ERROR_NO_ARGUMENT = "Kein Uebergabeparameter mit gegeben.\n";

    //Prompts
    private static final String FILE_RESULTS_NAME = "testResults.csv";
    private static final String MESSUNG_HEADER = "Laenge, Rekursiv, Iterativ\n";

    //Attributes
    private StringBuilder userAusgabe;
    private StringBuilder messungAusgabe;

    public PalindromMain(){
        this.userAusgabe = new StringBuilder();
        this.messungAusgabe = new StringBuilder(MESSUNG_HEADER);
    }

    public void addToAusgabe(String method, String word, boolean bool){
        userAusgabe.append(String.format("%20s - %10s - %b\n", method, word, bool));
    }

    public StringBuilder getAusgabe(){
        return userAusgabe;
    }

    private static File fileValidation(String path){
        File file = new File(path);

        if(!file.isFile()){
            throw new IllegalArgumentException();
        }
        if(!file.exists()){
            throw new IllegalArgumentException();
        }
        if(!file.canRead()){
            throw new IllegalArgumentException();
        }

        return file;
    }

    private void goThroughFile(File file){
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            String [] words;

            while((line = reader.readLine()) != null){
                words = line.split(" ");
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

    private void checkForPalindrom(String word){
        Palindrom [] methods = { new PalindromRekursiv(),
                                new PalindromIterativ()};
        long begin;
        long end;
        messungAusgabe.append(word.length());

        for(Palindrom method: methods){

            begin = System.nanoTime();
            addToAusgabe(method.getClass().getName(), word, method.istPalindrom(word));
            end = System.nanoTime();

            messungAusgabe.append(", " + String.valueOf(end - begin));
        }
        messungAusgabe.append("\n");
    }

    private void writeFile(){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_RESULTS_NAME))){
            String tmp = messungAusgabe.toString();
            writer.write(tmp, 0, tmp.length());
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
            file = fileValidation(args[0]);
            output.goThroughFile(file);
        }
        catch(Exception e){
            output.checkForPalindrom(args[0]);
        }

        System.out.println(output.getAusgabe());
        output.writeFile();
    }
}
