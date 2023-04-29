package ueb15.NumberCruncher;

public class NumberCruncherAnonym extends NumberCruncher{

    public NumberCruncherAnonym(float [] values){
        super(values);
    }

    public void sum(){
        CrunchOperation sum = new CrunchOperation() {
            @Override
            public void crunch(float[] values) {
                for(int i = 1; i < values.length; i++){
                    values[i] += values[i-1];
                }
            }
        };

        sum.crunch(values);
    }

    public void swirl(){
        CrunchOperation swirl = new CrunchOperation() {
            @Override
            public void crunch(float[] values) {
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
        };

        swirl.crunch(values);
    }

    public void subtract(){
        CrunchOperation subtract = new CrunchOperation() {
            @Override
            public void crunch(float[] values) {
                for(int i = 1; i < values.length; i++){
                    values[i] -= values[i-1];
                }
            }
        };

        subtract.crunch(values);
    }

    public void divide(){
        CrunchOperation divide = new CrunchOperation() {
            @Override
            public void crunch(float [] values){
                float [][] valuesCopy = new float[values.length][2];
                for(int i = 0; i < values.length; i++){
                    valuesCopy[i][0] = values[i];
                    valuesCopy[i][1] = i;
                }

                for(int i = 0; i < valuesCopy.length; i++){
                    for(int j = 0; j < valuesCopy.length - 1 - i; j++){
                        if(valuesCopy[j][0] > valuesCopy[j+1][0]){
                            swap(valuesCopy, j, j+1);
                        }
                    }
                }

                for(int i = 0; i < valuesCopy.length / 2; i++){
                    valuesCopy[valuesCopy.length - 1 - i][0] /= valuesCopy[i][0];
                }

                for(int i = 0; i < valuesCopy.length; i++){
                    values[(int)valuesCopy[i][1]] = valuesCopy[i][0];
                }
            }

            private void swap (float [][] values, int a, int b) {
                float[] tmp = values[a].clone();
                values[a] = values[b].clone();
                values[b] = tmp;
            }
        };
    }

    public void average(){
        CrunchOperation average = new CrunchOperation() {
            @Override
            public void crunch(float[] values) {
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
        };

        average.crunch(values);
    }
}
