import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    int columnCount = 0;
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
        String name;
        Double[] tab;
        entry = entry.replace(" ","");
        int count = 0;

        String[] data = entry.split("\t");
        for (String t:data) {
            System.out.println(t);
        }
        return null;
    }
}
