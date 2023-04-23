/**
 * Rekursive Implementierung um auf Palindrom zu pruefen.
 *
 * @author Tim Mueller / Yannick Gross
 * @version 23.04.2023 / 21:31Uhr
 */
public class PalindromRekursiv implements Palindrom{

    /**
     * Fueht toLowerCase() und strip() auf uebergebenes Wort aus, ruft dann darauf recursiveCheck() aus.
     * Extra Methode damit die Vorbereitung des Strings nicht bei jedem rekursiven
     * Aufruf ausgefuehrt wird.
     *
     * @param wort Wort das auf Palindrom geprueft werden soll
     * @return true oder false ob Palindrom
     */
    @Override
    public boolean istPalindrom(String wort) {

        return recursiveCheck(wort.toLowerCase().strip());
    }

    /**
     * Rekursive Ueberpruefung ob Palindrom.
     *
     * @param wort Wort das auf Palindrom geprueft werden soll
     * @return true oder false ob Palindrom
     */
    private boolean recursiveCheck(String wort){
        if (wort.length() < 2) {
            return true;
        }

        return wort.charAt(0) == wort.charAt(wort.length() - 1) &&
                recursiveCheck(wort.substring(1, wort.length() - 1));
    }
}
