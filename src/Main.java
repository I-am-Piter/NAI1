import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Test> tests = new ArrayList<>();
    static int columnCount = 0;
    boolean firstObject = true;
    public static void main(String[] args) {
        File inputFile = new File("mpp1/iris_training.txt");
        try {
            Scanner input = new Scanner(inputFile);
            String entry = input.nextLine();
            createTest(entry);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Test createTest(String entry){
        entry = entry.replace(" ","");
        String[] data = entry.split("\t");
        String name = data[data.length-1];
        Double[] values = new Double[data.length-1];
        columnCount = values.length;

        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(data[i]);
        }

        Test test = new Test(values,name);
        return test;
    }
}
