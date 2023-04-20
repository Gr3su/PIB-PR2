public class EuklidGGT {

    public EuklidGGT(){
    }

    public int ggT(int a, int b){
        if(b == 0) {
            return a;
        }
        return ggT(b, a % b);
    }

    public static void main(String [] args){
        EuklidGGTError.checkIfInteger(args[0]);
        EuklidGGTError.checkIfInteger(args[1]);

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        System.out.println("Der ggT von " + a + " und " + b + "ist:");
        System.out.println(new EuklidGGT().ggT(a, b));
    }
}
