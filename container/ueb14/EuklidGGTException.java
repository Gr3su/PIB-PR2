public class EuklidGGTException extends RuntimeException{

    public EuklidGGTException(){
        super();
    }

    public EuklidGGTException(String msg){
        super(msg);
    }

    public static void checkIfInteger(String tmp){
        String ErrorMessage = "Uebergebenes Attribut ist keine Zahl.\n";
        String numberRegex = "[0-9]+";
        if(!tmp.matches(numberRegex)){
            throw new EuklidGGTException(ErrorMessage);
        }
    }
}
