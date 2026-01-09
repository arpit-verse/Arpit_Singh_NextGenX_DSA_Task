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

public class Arpit_Singh_NextGenX_DSA_Task {

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int choice = -1;

    do {
        System.out.println("=========================================");
        System.out.println(" NEXTGENX AI CLUB - DSA CORE TASK ");
        System.out.println("=========================================\n");

        System.out.println("Select the problem you want to run:");
        System.out.println("1. Frequency Counter");
        System.out.println("2. Custom Stack Implementation");
        System.out.println("3. Longest Unique Substring");
        System.out.println("4. Exit");

        System.out.print("\nEnter your choice: ");
        String inputChoice = sc.nextLine();

        // Validate input (only 1–4 allowed)
        if (!inputChoice.matches("[1-4]")) {
            System.out.println("\nInvalid choice! Please enter a number between 1 and 4.\n");
            continue;
        }

        choice = Integer.parseInt(inputChoice);

        switch (choice) {

            case 1:
                MyFrequencyCounter.run(sc);
                break;

            case 2:
                MyCustomStack.run(sc);
                break;

            case 3:
                MyLongestUniqueSubstring.run(sc);
                break;

            case 4:
                System.out.println("\nExiting program. Thank you!");
                break;
        }

        if (choice != 4) {
            System.out.println("\nPress Enter to return to main menu...");
            sc.nextLine();
        }

    } while (choice != 4);

    sc.close();
}}



/* =========================================================
   PROBLEM 1: FREQUENCY COUNTER
   ========================================================= */
class MyFrequencyCounter {

    //Selection Sort
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

    static void run(Scanner sc) {

        System.out.println("\nFREQUENCY COUNTER");
        System.out.println("--------------------------");

        int n = 0;

        // Safe input for total number of elements
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

        System.out.println("\nEnter the elements (number / string / special character):");
        for (int i = 0; i < n; i++) {

            while (true) {
                System.out.print("Enter " + (i + 1) + " element: ");
                String elementInput = sc.nextLine();

                if (elementInput.length() == 0) {
                    System.out.println("Empty input is not allowed.");
                    continue;
                }

                arr[i] = elementInput;
                break;
            }
        }

        // Sort array
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
    }
}


/* =========================================================
   PROBLEM 2: CUSTOM STACK IMPLEMENTATION
   ========================================================= */
class MyCustomStack {

    String[] stack;
    int top;
    int size = 0;
    

    // Constructor
    MyCustomStack(int size) {
        this.size = size;
        stack = new String[size];
        top = -1;
    }

    void push(String value) {
    if (top == size - 1) {
        System.out.println("Stack Overflow! Cannot push " + value);
        return;
    }
    top++;
    stack[top] = value;
    System.out.println("Pushed element: " + value);
}


   void pop() {
    if (top == -1) {
        System.out.println("Stack Underflow! No element to pop");
        return;
    }
    String popped = stack[top];
    top--;
    System.out.println("Popped element: " + popped);
}


    void peek() {
    if (top == -1) {
        System.out.println("Stack is empty. No top element.");
        return;
    }
    System.out.println("Top element is: " + stack[top]);
}


    void isEmpty() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack is not empty");
        }
    }

    static void run(Scanner sc) {
        

        System.out.println("\nCUSTOM STACK IMPLEMENTATION");
        System.out.println("--------------------------");
        
      
        int size = 0;
         while (true) {
          System.out.print("Enter size of stack: ");
          String inputSize = sc.nextLine();

        if (!inputSize.matches("\\d+")) {
            System.out.println("Invalid input! Stack size must be a positive number.");
            continue;
          }

        size = Integer.parseInt(inputSize);

        if (size <= 0) {
        System.out.println("Stack size must be greater than zero.");
        continue;
         }

        break; // valid size entered
        }

        MyCustomStack stack = new MyCustomStack(size);

        int choice = -1; 

        do {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. IsEmpty");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            String inputChoice;
            inputChoice = sc.nextLine();

        if (!inputChoice.matches("[1-5]")) {
             System.out.println("Invalid choice! Please enter a number between 1 and 5.");
              continue;
            }

            choice = Integer.parseInt(inputChoice);


            switch (choice) {

                case 1:
                    
                    System.out.print("Enter element to push: ");
                    String value = sc.nextLine();
                    stack.push(value);
                    break;

                case 2:
                    stack.pop();
                    break;

                case 3:
                    stack.peek();
                    break;

                case 4:
                    stack.isEmpty();
                    break;

                case 5:
                    System.out.println("Exiting stack program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }
}

/* =========================================================
   PROBLEM 3: LONGEST UNIQUE SUBSTRING
   ========================================================= */
class MyLongestUniqueSubstring {

    static void run(Scanner sc) {

        System.out.println("\nLONGEST UNIQUE SUBSTRING");
        System.out.println("--------------------------");

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        boolean[] visited = new boolean[256]; // ASCII
        int start = 0;
        int maxLength = 0;

        for (int end = 0; end < input.length(); end++) {

            char currentChar = input.charAt(end);

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

        System.out.println(
                "\nLength of the longest substring without repeating characters: "
                        + maxLength
        );
    }
}
