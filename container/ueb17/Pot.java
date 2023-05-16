package ueb17;
import static ueb17.ApplyAndPrint.applyAndPrint;

public class Pot implements MyFunction{

    @Override
    public int apply(int x){
        int sum = 1;
        for(int i = 0; i < x + 1; i++){
            sum *= x;
        }
        return sum;
    }

    public static void main(String[] args) {
        applyAndPrint(1, 9, new Pot());
    }
}
