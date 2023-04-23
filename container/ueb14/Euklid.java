public class Euklid {

    private Euklid(){
    }

    /**
     * Berechnet den groessten gemeinsamen Teiler.
     *
     * @param a Erste Zahl
     * @param b Zweite Zahl
     * @return Groesster gemeinsamer Teiler
     */
    public int ggT(int a, int b){
        if(b == 0) {
            return a;
        }
        return ggT(b, a % b);
    }

    /**
     * Prueft erste zwei Kommandozeilenparameter ob es Zahlen sind und startet dann ggT().
     *
     * @param args Kommandozeilenparameter
     */
    public static void main(String [] args){
        EuklidGGTException.checkIfInteger(args[0]);
        EuklidGGTException.checkIfInteger(args[1]);

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        System.out.println("Der ggT von " + a + " und " + b + " ist:");
        System.out.println(new Euklid().ggT(a, b));
    }
}
