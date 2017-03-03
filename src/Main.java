
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by user on 18.02.2017.
 */
public class Main {
    public static final String INPUT_FILE = "INPUT.TXT";
    public static final String OUTPUT_FILE = "OUTPUT.TXT";
    static List evenArr = new ArrayList();
    static List oddArr = new ArrayList();
    static String remark;


    public static void main(String[] args) {
        try {
            parseFileAndCalculate();
            writeFile();
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода/выводв! ");
            System.out.println("Подробная отладочная информация: ");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Произошла неизвестная ошибка! ");
            System.out.println("Подробная отладочная информация: ");
            e.printStackTrace();
        }

    }

    private static void parseFileAndCalculate() throws IOException {

        Scanner scanner = new Scanner(Paths.get(INPUT_FILE));
        String line = scanner.nextLine();


        String line2 = scanner.nextLine();
        String[] days = line2.split(" ");
        int numArr[] = new int[days.length];
        for (int i = 0; i < days.length; i++) {
            numArr[i] = Integer.parseInt(days[i]);
        }
        for (int i = 0; i < numArr.length; i++) {
            if (numArr[i] % 2 == 0) {
                evenArr.add(numArr[i]);
                System.out.println(" Четные " + numArr[i]);
            } else {
                oddArr.add(numArr[i]);
                System.out.println(" НеЧетные " + numArr[i]);
            }
        }
        scanner.close();
        if (evenArr.size() >= oddArr.size())
            remark = "YES";
        else
            remark = "NO";

    }


    private static void writeFile() throws IOException {
        try {
            FileWriter fw = new FileWriter(OUTPUT_FILE);
            Writer output = new BufferedWriter(fw);
            int evenSz = evenArr.size();
            int oddSz = oddArr.size();

            for (int i = 0; i < oddSz; i++) {
                output.append(oddArr.get(i).toString() + " ");
            }
            output.append("\n");
            for (int i = 0; i < evenSz; i++) {
                output.append(evenArr.get(i).toString() + " ");

            }
            output.append("\n");
            output.append(remark);
            output.flush();
            output.close();
            fw.close();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}



