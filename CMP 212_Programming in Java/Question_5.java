import java.util.Scanner;
import java.text.DecimalFormat;
/*
This is the Fifth question which is to Write a Java application that allows the user to enter
up to 20 integer grades into an array. Stop the loop by typing in ‐1.
Your main method should call an Average method that returns the average of the grades.
Use the DecimalFormat class to format the average to 2 decimal places
 */
public class Question_5 {

        public static void main(String[] args)
        {
            int[] grades = new int[20];
            int count = 0;
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter up to 20 integer grades (-1 to stop):");
            int input = scanner.nextInt();

            while (input != -1 && count < 20)
            {
                grades[count] = input;
                count++;
                input = scanner.nextInt();
            }

            double average = calculateAverage(grades, count);
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            String formattedAverage = decimalFormat.format(average);

            System.out.println("Average grade: " + formattedAverage);
        }

        public static double calculateAverage(int[] grades, int count) {
            if (count == 0) {
                return 0.0;
            }

            int sum = 0;
            for (int i = 0; i < count; i++) {
                sum += grades[i];
            }

            return (double) sum / count;
        }
    }



