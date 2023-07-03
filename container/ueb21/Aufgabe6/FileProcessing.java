package ueb21.Aufgabe6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileProcessing {

    public List<String> readTextFile(String file, String prefix, int minLength, int limit){

        try(BufferedReader reader = new BufferedReader(new FileReader(fileValidation(file)))){
            return reader.lines()
                    .flatMap((line)->Stream.of(line.split(" +")))
                    .filter(word -> word.startsWith(prefix) && word.length() >= minLength)
                    .distinct()
                    .limit(limit)
                    .sorted()
                    .collect(Collectors.toList());
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }

        return null;
    }

    public Map<Integer, String> readTextFileB(String file, String prefix, int minLength, int limit) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileValidation(file)))){
            return reader.lines()
                    .flatMap((line) -> Stream.of(line.split(" +")))
                    .filter(word -> word.startsWith(prefix) && word.length() >= minLength)
                    .distinct()
                    .limit(limit)
                    .sorted()
                    .collect(Collectors.toMap(word -> word.length(), word -> word, (word1, word2) -> word1 + ", " + word2));
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }

        return null;
    }

    private File fileValidation(String path){
        File file = new File(path);

        if(!file.isFile()){
            throw new InvalidFileException( String.format(ErrorMessages.PFAD_KEINE_DATEI.getMessage(),
                    path));
        }
        if( !path.endsWith(".txt")){
            throw new InvalidFileException( String.format(ErrorMessages.KEINE_JAVA_DATEI.getMessage(),
                    path));
        }
        if(!file.exists()){
            throw new InvalidFileException( String.format(ErrorMessages.DATEI_EXISTIERT_NICHT.getMessage(),
                    path));
        }
        if(!file.canRead()){
            throw new FileNotReadableException( String.format(ErrorMessages.DATEI_NICHT_LESBAR.getMessage(),
                    path));
        }

        return file;
    }

    public static void main(String[] args) {
        System.out.println("Teil (a):");
        List<String> list = new FileProcessing().readTextFile("rfc791.txt", "th", 3, 20);
        list.stream().forEach(word -> System.out.println(word));
        System.out.println("Teil (b):");
        Map<Integer, String> map = new FileProcessing().readTextFileB("rfc791.txt", "th", 3, 20);
        map.keySet().stream().forEach(len -> System.out.println(len + ": " + map.get(len)));
    }
}
