import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Test> tests = new ArrayList<>();
    static int columnCount = 0;
    static boolean firstObject = true;
    public static void main(String[] args) {
        File inputFile = new File("mpp1/iris_training.txt");
        try {
            Scanner input = new Scanner(inputFile);
            while(input.hasNextLine()) {
                String entry = input.nextLine();
                try {
                    createTest(entry);
                } catch (WrongFormattedDataError e) {
                    throw new RuntimeException(e);
                }
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Test createTest(String entry) throws WrongFormattedDataError {
        entry = entry.replace(" ","");
        String[] data = entry.split("\t");
        String name = data[data.length-1];
        Double[] values = new Double[data.length-1];
        if(firstObject){
            columnCount = values.length;
            firstObject = false;
        }else{
            if(columnCount != values.length){
                throw new WrongFormattedDataError("Dane są źle sformatowane, popraw je!");
            }
        }

        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(data[i]);
        }

        Test test = new Test(values,name);
        return test;
    }
}
