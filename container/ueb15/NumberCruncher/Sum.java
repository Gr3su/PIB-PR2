package ueb15.NumberCruncher;

public class Sum implements CrunchOperation{

    @Override
    public void crunch(float [] values){
        for(int i = 1; i < values.length; i++){
            values[i] += values[i-1];
        }
    }
}
