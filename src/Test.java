import java.util.ArrayList;

public class Test {
    private ArrayList<Double> measurementsList;
    private String conclusion;

    public Test(Double[] pomiary,String conclusion){
        this.conclusion = conclusion;
        for (int i = 0; i < pomiary.length; i++) {
            measurementsList.add(pomiary[i]);
        }
    }


}
