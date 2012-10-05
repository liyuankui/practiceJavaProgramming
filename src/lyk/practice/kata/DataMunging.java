package lyk.practice.kata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/5/12
 * Time: 4:20 PM
 * The DataMunging class is intended to fulfil some duties.
 */
public class DataMunging {
    public static void weather() {
        try {
            // bufferedreader to read line
            BufferedReader weatherdata = new BufferedReader(new FileReader("weather.dat"));
            float span = 0;
            String day = "";

            String line;
            //use emptyline to control the empty lines
            int emptyline = 3;
            while (emptyline > 0 && (line = weatherdata.readLine()) != null) {
                System.out.println(emptyline + "-" + line);
                if (line.equals("")) emptyline--;
            }

            while ((line = weatherdata.readLine()) != null) {
                System.out.print(line);

                //using \\s+ to filter out the many whitespaces
                //The \\s is equivalent to [ \\t\\n\\x0B\\f\\r]
                String[] numbers = line.split("\\s+");
                if (numbers.length < 3) break;
                System.out.println(numbers[0]);
                System.out.println(numbers[1]);
                // filter out the non digit chars
                System.out.println(numbers[2].replaceAll("[^\\d]", ""));
                System.out.println(numbers[3].replaceAll("[^\\d]", ""));
                // don't filter out the . filters
                //may be I should've just filter the *
                float tmp = Float.parseFloat(numbers[2].replaceAll("[^\\d\\.]", "")) - Float.parseFloat(numbers[3].replaceAll("[^\\d]", ""));
                //should've used float or double
                if (span < tmp) {
                    span = tmp;
                    day = numbers[1];
                }
            }
            System.out.println("day " + day + " with " + span);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        weather();
    }

}
