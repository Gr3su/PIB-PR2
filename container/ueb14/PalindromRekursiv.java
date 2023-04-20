public class PalindromRekursiv implements Palindrom{

    @Override
    public boolean istPalindrom(String wort){
        if(wort.length() % 2 == 1){
            return false;
        }

        return checkPalindrom(wort.toLowerCase());
    }

    private boolean checkPalindrom(String wort){
        boolean equalLetter = wort.charAt(0) == wort.charAt(wort.length() - 1);

        if(wort.length() == 2 &&
                equalLetter){
            return true;
        }

        return equalLetter &&
                checkPalindrom(wort.substring(1,wort.length()-1));
    }
}
