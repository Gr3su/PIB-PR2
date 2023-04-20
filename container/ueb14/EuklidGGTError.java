public class EuklidGGTError extends RuntimeException{

    public EuklidGGTError(){
        super();
    }

    public EuklidGGTError(String msg){
        super(msg);
    }

    public static void checkIfInteger(String tmp){
        String ErrorMessage = "Uebergebenes Attribut ist keine Zahl.\n";
        String numberRegex = "[0-9]+";
        if(!tmp.matches(numberRegex)){
            throw new EuklidGGTError(ErrorMessage);
        }
    }
}
