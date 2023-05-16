package ueb17;
import static ueb17.ApplyAndPrint.applyAndPrint;

public class Fib implements MyFunction{

    @Override
    public int apply(int x){
        if(x <= 2){
            return 1;
        }
        return apply(x - 1) + apply(x - 2);
    }

    public static void main(String[] args) {
        applyAndPrint(1, 10, new Fib());
    }
}
