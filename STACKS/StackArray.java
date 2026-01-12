import java.util.Scanner;

public class StackArray {
    int stack[];
    int top;
    int size;

    // Constructor
    StackArray(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    // PUSH operation
    void push(int item) {
        if (top == size - 1) {
            System.out.println("Stack Overflow! Cannot push.");
        } else {
            stack[++top] = item;
            System.out.println(item + " pushed into stack.");
        }
    }

    // POP operation
    void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! Stack is empty.");
        } else {
            System.out.println(stack[top--] + " popped from stack.");
        }
    }

    // PEEK operation
    void peek() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Top element is: " + stack[top]);
        }
    }

    // DISPLAY operation
    void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack elements are:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter stack size: ");
        int size = sc.nextInt();

        StackArray stack = new StackArray(size);

        int choice;
        do {
            System.out.println("\n--- STACK MENU ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int item = sc.nextInt();
                    stack.push(item);
                    break;

                case 2:
                    stack.pop();
                    break;

                case 3:
                    stack.peek();
                    break;

                case 4:
                    stack.display();
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
