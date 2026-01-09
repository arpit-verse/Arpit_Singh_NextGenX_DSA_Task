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

public class CustomStack {

    String[] stack;
    int top;
    int size;

    // Constructor
    CustomStack(int size) {
        this.size = size;
        stack = new String[size];
        top = -1;
    }

    // Push operation
    void push(String value) {
        if (top == size - 1) {
            System.out.println("Stack Overflow! Cannot push \"" + value + "\"");
            return;
        }
        top++;
        stack[top] = value;
        System.out.println("Pushed element: " + value);
    }

    // Pop operation
    void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! No element to pop");
            return;
        }
        String poppedElement = stack[top];
        top--;
        System.out.println("Popped element: " + poppedElement);
    }

    // Peek operation
    void peek() {
        if (top == -1) {
            System.out.println("Stack is empty. No top element");
            return;
        }
        System.out.println("Top element is: " + stack[top]);
    }

    // IsEmpty operation
    void isEmpty() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack is not empty");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("CUSTOM STACK IMPLEMENTATION (STRING BASED)");
        System.out.println("-----------------------------------------");

        int size = 0;

        // Robust input for stack size
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

            break;
        }

        CustomStack stack = new CustomStack(size);
        int choice = -1;

        do {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. IsEmpty");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            String inputChoice = sc.nextLine();

            if (!inputChoice.matches("[1-5]")) {
                System.out.println("Invalid choice! Please enter a number between 1 and 5.");
                continue;
            }

            choice = Integer.parseInt(inputChoice);

            switch (choice) {

                case 1:
                    System.out.print("Enter element to push (string / number / special char): ");
                    String value = sc.nextLine();

                    if (value.length() == 0) {
                        System.out.println("Empty input is not allowed.");
                    } else {
                        stack.push(value);
                    }
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
                    System.out.println("Exiting program...");
                    break;
            }

        } while(choice != 5);

        sc.close();
    }
}
