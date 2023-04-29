package ueb15.NumberCruncher;

public class Swirl implements CrunchOperation{

    @Override
    public void crunch(float [] values){
        int range = values.length;

        for(float a: values){
            swap(values, (int)(Math.random() * range), (int)(Math.random() * range));
        }
    }

    private void swap(float [] values, int a, int b){
        float tmp = values[a];
        values[a] = values[b];
        values[b] = tmp;
    }
}
