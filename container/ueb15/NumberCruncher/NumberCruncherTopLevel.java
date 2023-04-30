package ueb15.NumberCruncher;

public class NumberCruncherTopLevel extends NumberCruncher{

    /**
     * Ruft Konstruktor von NumberCruncher auf
     * @param values
     */
    public NumberCruncherTopLevel(float [] values){
        super(values);
    }

    @Override
    public void sum(){
        new Sum().crunch(values);
    }

    @Override
    public void swirl(){
        new Swirl().crunch(values);
    }

    @Override
    public void subtract(){
        new Subtract().crunch(values);
    }

    @Override
    public void divide(){
        new Divide().crunch(values);
    }

    @Override
    public void average(){
        new Average().crunch(values);
    }
}
