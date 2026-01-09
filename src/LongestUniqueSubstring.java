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

public class LongestUniqueSubstring{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("LONGEST UNIQUE SUBSTRING");
        System.out.println("------------------------");

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int start = 0;
        int maxLength = 0;

        boolean[] visited = new boolean[256]; // ASCII characters

        for (int end = 0; end < input.length(); end++) {

            char currentChar = input.charAt(end);

            // If character already exists in window
            while (visited[currentChar]) {
                visited[input.charAt(start)] = false;
                start++;
            }

            visited[currentChar] = true;

            int currentLength = end - start + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        System.out.println("\nLength of the longest substring without repeating characters: "
                + maxLength);

        sc.close();
    }
}

