package ueb14;
/**
 * Iterative Implementierung um auf Palindrom zu pruefen.
 *
 * @author Tim Mueller / Yannick Gross
 * @version 20.04.2023 / 15:00Uhr
 */
public class PalindromIterativ implements Palindrom{

    /**
     * Iterative Implementierung der istPalindrom Methode vom Interface Palindrom.
     *
     * @param wort Zu pruefendes Wort
     * @return Ob Palindrom
     */
    @Override
    public boolean istPalindrom(String wort){
        wort = wort.toLowerCase();
        wort = wort.strip();

        for(int i = 0; i < wort.length() / 2; i++){
            if(wort.charAt(i) != wort.charAt(wort.length() - 1 - i)){
                return false;
            }
        }
        return true;

    }
}
