import java.util.Scanner;

public class QueueArray {
    int queue[];
    int front, rear, size;

    // Constructor
    QueueArray(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    // ENQUEUE operation
    void enqueue(int item) {
        if (rear == size - 1) {
            System.out.println("Queue Overflow! Cannot insert.");
        } else {
            if (front == -1)
                front = 0;
            queue[++rear] = item;
            System.out.println(item + " inserted into queue.");
        }
    }

    // DEQUEUE operation
    void dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue Underflow! Queue is empty.");
        } else {
            System.out.println(queue[front++] + " removed from queue.");
        }
    }

    // PEEK operation
    void peek() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Front element is: " + queue[front]);
        }
    }

    // DISPLAY operation
    void display() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Queue elements are:");
            for (int i = front; i <= rear; i++) {
                System.out.println(queue[i]);
            }
        }
    }
    
    // MAIN METHOD
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int size = sc.nextInt();

        QueueArray q = new QueueArray(size);

        int choice;
        do {
            System.out.println("\n--- QUEUE MENU ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert: ");
                    int item = sc.nextInt();
                    q.enqueue(item);
                    break;

                case 2:
                    q.dequeue();
                    break;

                case 3:
                    q.peek();
                    break;

                case 4:
                    q.display();
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
