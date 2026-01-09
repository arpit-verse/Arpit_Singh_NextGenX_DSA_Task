package src;
import java.util.Scanner;

/*
   =========================================================
   NextGenX AI Club – Core Team Recruitment Task
   Domain: Data Structures & Algorithms (DSA)
   Name: Arpit Singh
   Email:arpit.singh.cs28@iilm.edu
   Course: B.Tech Computer Science and Engineering
   Year: 2nd Year
   Roll No: 2410030287
   Language Used: Java
   =========================================================
*/

public class FrequencyCounter {

    // Selection Sort
    static void sortArray(String[] arr, int n) {
        String temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("FREQUENCY COUNTER PROGRAM (STRING BASED)");
        System.out.println("---------------------------------------");

        int n = 0;

        // Robust input for total number of elements
        while (true) {
            System.out.print("Enter total number of elements: ");
            String inputN = sc.nextLine();

            if (!inputN.matches("\\d+")) {
                System.out.println("Invalid input! Please enter a positive number.");
                continue;
            }

            n = Integer.parseInt(inputN);

            if (n <= 0) {
                System.out.println("Number of elements must be greater than zero.");
                continue;
            }

            break;
        }

        String[] arr = new String[n];

        System.out.println("\nEnter the elements (string / number / special character):");
        for (int i = 0; i < n; i++) {

            while (true) {
                System.out.print("Enter " + (i + 1) + " element: ");
                String element = sc.nextLine();

                if (element.length() == 0) {
                    System.out.println("Empty input is not allowed.");
                    continue;
                }

                arr[i] = element;
                break;
            }
        }

        // Sorting the array
        sortArray(arr, n);

        System.out.println("\nFrequency of elements:");
        System.out.println("--------------------------");

        int count = 1;

        for (int i = 0; i < n; i++) {
            if (i < n - 1 && arr[i].equals(arr[i + 1])) {
                count++;
            } else {
                System.out.println(
                        "Element \"" + arr[i] + "\" comes " + count + " time(s)"
                );
                count = 1;
            }
        }

        sc.close();
    }
}
