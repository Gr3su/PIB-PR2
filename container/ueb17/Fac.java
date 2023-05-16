package ueb17;
import static ueb17.ApplyAndPrint.applyAndPrint;

public class Fac implements MyFunction{

    @Override
    public int apply(int x){
        if (x == 0) {
            return 1;
        }
        return apply(x - 1) * x;
    }

    public static void main(String[] args) {
        applyAndPrint(1, 10, new Fac());
    }
}
