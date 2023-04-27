package ueb14;
import java.io.File;

/**
 * Exception Klasse zur Dateiueberpruefung.
 *
 * @author Tim Mueller / Yannick Gross
 * @version 23.04.2023 / 16:34Uhr
 */
public class FileValidationException extends RuntimeException{
    //Prompts
    private static final String ERROR_PFAD_EXISTIERT_NICHT = "Uebergebener Dateipfad existiert nicht.\n";
    private static final String ERROR_DATEI_NICHT_LESBAR = "Uebergebene Datei nicht lesbar.\n";
    private static final String ERROR_PFAD_KEINE_DATEI = "Uebergebener Dateipfad keine Datei.\n";

    public FileValidationException(){
        super();
    }

    public FileValidationException(String msg){
        super(msg);
    }

    /**
     * Prueft ob Dateipfad existiert, lesbar ist und eine Datei ist.
     *
     * @param path Dateipfad
     * @return ob Dateipfad
     *
     * @throws FileValidationException Wenn nicht existent, nicht lesbar, keine Datei
     */
    public static File fileValidation(String path){
        File file = new File(path);

        if(!file.exists()) {
            throw new FileValidationException(ERROR_PFAD_EXISTIERT_NICHT);
        }
        if(!file.canRead()){
            throw new FileValidationException(ERROR_DATEI_NICHT_LESBAR);
        }
        if(!file.isFile()){
            throw new FileValidationException(ERROR_PFAD_KEINE_DATEI);
        }

        return file;
    }
}
