/**
 * Exception Klasse um Fehler abzufangen die vom geschriebenen Code
 * geworfen werden.
 *
 * @author Tim Mueller / Yannick Gross
 * @version 17.04.23 / 18:00Uhr
 */
public class ExpectedException extends RuntimeException{

    public ExpectedException(String msg){
        super(msg);
    }
}
