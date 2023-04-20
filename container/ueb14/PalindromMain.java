import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PalindromMain {
    private static final String ERROR_NO_ARGUMENT = "Kein Uebergabeparameter mit gegeben.\n";

    private StringBuilder ausgabe;

    public PalindromMain(){
        this.ausgabe = new StringBuilder();
    }

    public void addToAusgabe(String tmp, boolean bool){
        ausgabe.append(String.format("%s10 - %b", tmp, bool));
    }

    public StringBuilder getAusgabe(){
        return ausgabe;
    }

    private static File fileValidation(String path){
        File file = new File(path);

        if(!file.isFile()){

        }
        if(!file.exists()){

        }
        if(!file.canRead()){

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

        for(Palindrom method: methods){
            addToAusgabe(word, method.istPalindrom(word));
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
    }
}
