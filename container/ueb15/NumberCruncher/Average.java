package ueb15.NumberCruncher;

public class Average implements CrunchOperation{

    @Override
    public void crunch(float [] values){
        float biggest = 0.0F;
        float sum = 0.0F;
        int biggestIndex = -1;

        for(int i = 0; i < values.length; i++) {
            if (values[i] > biggest) {
                biggestIndex = i;
            }

            sum += values[i];
        }

        values[biggestIndex] = sum / values.length;
    }
}
