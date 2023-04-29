package ueb15.NumberCruncher;

public class NumberCruncherTopLevel extends NumberCruncher{

    /**
     * Ruft Konstruktor von NumberCruncher auf
     * @param values
     */
    public NumberCruncherTopLevel(float [] values){
        super(values);
    }

    public void sum(){
        new Sum().crunch(values);
    }

    public void swirl(){
        new Swirl().crunch(values);
    }

    public void subtract(){
        new Subtract().crunch(values);
    }

    public void divide(){
        new Divide().crunch(values);
    }

    public void average(){
        new Average().crunch(values);
    }
}
