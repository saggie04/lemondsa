import java.util.Scanner;

public class FullCircularLinkedList {

    // Node structure
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Scanner sc;

    public FullCircularLinkedList() {
        head = null;
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        FullCircularLinkedList list = new FullCircularLinkedList();
        list.menu();
    }

    // ---------------- MENU ----------------
    public void menu() {
        int choice;
        do {
            System.out.println("\n---- CIRCULAR LINKED LIST MENU ----");
            System.out.println("1. Create List");
            System.out.println("2. Insert at Beginning");
            System.out.println("3. Insert at End");
            System.out.println("4. Insert at Position");
            System.out.println("5. Insert After Value");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete at Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Reverse List");
            System.out.println("11. Count Nodes");
            System.out.println("12. Display List");
            System.out.println("13. Search Element");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1: createList(); break;
                case 2: insertBeginning(); break;
                case 3: insertEnd(); break;
                case 4: insertAtPosition(); break;
                case 5: insertAfterValue(); break;
                case 6: deleteBeginning(); break;
                case 7: deleteEnd(); break;
                case 8: deleteAtPosition(); break;
                case 9: deleteByValue(); break;
                case 10: reverseList(); break;
                case 11: countNodes(); break;
                case 12: display(); break;
                case 13: search(); break;
                case 0: System.out.println("Exit"); break;
                default: System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }

    // ---------------- CREATE ----------------
    public void createList() {
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        head = null;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value: ");
            int val = sc.nextInt();
            insertEnd(val);
        }
    }

    // ---------------- INSERT ----------------
    public void insertBeginning() {
        System.out.print("Enter value: ");
        int val = sc.nextInt();

        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head)
            temp = temp.next;

        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    public void insertEnd() {
        System.out.print("Enter value: ");
        int val = sc.nextInt();
        insertEnd(val);
    }

    private void insertEnd(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head)
            temp = temp.next;

        temp.next = newNode;
        newNode.next = head;
    }

    public void insertAtPosition() {
        System.out.print("Enter position: ");
        int pos = sc.nextInt();

        System.out.print("Enter value: ");
        int val = sc.nextInt();

        if (pos == 1) {
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
                newNode.next = head;
                return;
            }

            Node temp = head;
            while (temp.next != head)
                temp = temp.next;

            newNode.next = head;
            temp.next = newNode;
            head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;

        if (temp.next == head && pos != 2) {
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(val);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void insertAfterValue() {
        System.out.print("Enter existing value: ");
        int key = sc.nextInt();

        System.out.print("Enter new value: ");
        int val = sc.nextInt();

        if (head == null) {
            System.out.println("List empty");
            return;
        }

        Node temp = head;
        do {
            if (temp.data == key) {
                Node newNode = new Node(val);
                newNode.next = temp.next;
                temp.next = newNode;
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("Value not found");
    }

    // ---------------- DELETE ----------------
    public void deleteBeginning() {
        if (head == null) {
            System.out.println("List empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next != head)
            temp = temp.next;

        temp.next = head.next;
        head = head.next;
    }

    public void deleteEnd() {
        if (head == null) {
            System.out.println("List empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != head)
            temp = temp.next;

        temp.next = head;
    }

    public void deleteAtPosition() {
        System.out.print("Enter position: ");
        int pos = sc.nextInt();

        if (head == null || pos < 1) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            deleteBeginning();
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;

        if (temp.next == head) {
            System.out.println("Invalid position");
            return;
        }

        temp.next = temp.next.next;
    }

    public void deleteByValue() {
        System.out.print("Enter value to delete: ");
        int key = sc.nextInt();

        if (head == null) {
            System.out.println("List empty");
            return;
        }

        if (head.data == key) {
            deleteBeginning();
            return;
        }

        Node temp = head;
        while (temp.next != head && temp.next.data != key)
            temp = temp.next;

        if (temp.next == head) {
            System.out.println("Value not found");
            return;
        }

        temp.next = temp.next.next;
    }

    // ---------------- OTHER ----------------
    public void reverseList() {
        if (head == null || head.next == head)
            return;

        Node prev = null, curr = head, next;
        Node last = head;

        while (last.next != head)
            last = last.next;

        do {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } while (curr != head);

        head.next = prev;
        head = prev;
    }

    public void countNodes() {
        if (head == null) {
            System.out.println("Total nodes: 0");
            return;
        }

        int count = 0;
        Node temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total nodes: " + count);
    }

    public void display() {
        if (head == null) {
            System.out.println("List empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }

    public void search() {
        System.out.print("Enter value to search: ");
        int key = sc.nextInt();

        if (head == null) {
            System.out.println("List empty");
            return;
        }

        Node temp = head;
        int pos = 1;

        do {
            if (temp.data == key) {
                System.out.println("Found at position " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        } while (temp != head);

        System.out.println("Not found");
    }
}
