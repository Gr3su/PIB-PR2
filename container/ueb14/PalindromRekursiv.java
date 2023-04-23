/**
 *
 */
public class PalindromRekursiv implements Palindrom{

    @Override
    public boolean istPalindrom(String wort) {

        return recursivCheck(wort.toLowerCase().strip());
    }

    private boolean recursivCheck(String wort){
        if (wort.length() < 2) {
            return true;
        }

        return wort.charAt(0) == wort.charAt(wort.length() - 1) &&
                recursivCheck(wort.substring(1, wort.length() - 1));
    }
}
