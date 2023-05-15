package ueb17;

public abstract class ApplyAndPrint {
    public static void applyAndPrint(int a, int b, MyFunction func){
        for(int i = a+1; i < b; i++){
            System.out.println(func.apply(i));
        }
    }
}
