public class PalindromIterativ implements Palindrom{

    @Override
    public boolean istPalindrom(String wort){
        wort = wort.toLowerCase();

        for(int i = 0; i < wort.length() / 2; i++){
            if(wort.charAt(i) != wort.charAt(wort.length() - 1 - i)){
                return false;
            }
        }
        return true;

    }
}
