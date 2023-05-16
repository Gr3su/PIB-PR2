package ueb17;
import static ueb17.ApplyAndPrint.applyAndPrint;

public class Quad implements MyFunction{

    @Override
    public int apply(int x){
        return x * x;
    }

    public static void main(String[] args) {
        applyAndPrint(1, 10, new Quad());
    }
}
