import java.util.Scanner;

public class FullDoublyLinkedList {

    // Node structure
    class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Scanner sc;

    public FullDoublyLinkedList() {
        head = null;
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        FullDoublyLinkedList list = new FullDoublyLinkedList();
        list.menu();
    }

    // ---------------- MENU ----------------
    public void menu() {
        int choice;
        do {
            System.out.println("\n---- DOUBLY LINKED LIST MENU ----");
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
            System.out.println("12. Display Forward");
            System.out.println("13. Display Reverse");
            System.out.println("14. Search Element");
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
                case 12: displayForward(); break;
                case 13: displayReverse(); break;
                case 14: search(); break;
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
        if (head != null)
            head.prev = newNode;

        newNode.next = head;
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
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        newNode.prev = temp;
    }

    public void insertAtPosition() {
        System.out.print("Enter position: ");
        int pos = sc.nextInt();

        System.out.print("Enter value: ");
        int val = sc.nextInt();

        if (pos == 1) {
            insertBeginning();
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(val);
        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null)
            temp.next.prev = newNode;

        temp.next = newNode;
    }

    public void insertAfterValue() {
        System.out.print("Enter existing value: ");
        int key = sc.nextInt();

        System.out.print("Enter new value: ");
        int val = sc.nextInt();

        Node temp = head;
        while (temp != null && temp.data != key)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Value not found");
            return;
        }

        Node newNode = new Node(val);
        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null)
            temp.next.prev = newNode;

        temp.next = newNode;
    }

    // ---------------- DELETE ----------------
    public void deleteBeginning() {
        if (head == null) {
            System.out.println("List empty");
            return;
        }

        head = head.next;
        if (head != null)
            head.prev = null;
    }

    public void deleteEnd() {
        if (head == null) {
            System.out.println("List empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.prev.next = null;
    }

    public void deleteAtPosition() {
        System.out.print("Enter position: ");
        int pos = sc.nextInt();

        if (pos < 1 || head == null) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            deleteBeginning();
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        if (temp.next != null)
            temp.next.prev = temp.prev;

        if (temp.prev != null)
            temp.prev.next = temp.next;
    }

    public void deleteByValue() {
        System.out.print("Enter value to delete: ");
        int key = sc.nextInt();

        Node temp = head;
        while (temp != null && temp.data != key)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Value not found");
            return;
        }

        if (temp.prev != null)
            temp.prev.next = temp.next;
        else
            head = temp.next;

        if (temp.next != null)
            temp.next.prev = temp.prev;
    }

    // ---------------- OTHER ----------------
    public void reverseList() {
        Node curr = head, temp = null;

        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        if (temp != null)
            head = temp.prev;
    }

    public void countNodes() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total nodes: " + count);
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("List empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayReverse() {
        if (head == null) {
            System.out.println("List empty");
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public void search() {
        System.out.print("Enter value to search: ");
        int key = sc.nextInt();

        Node temp = head;
        int pos = 1;

        while (temp != null) {
            if (temp.data == key) {
                System.out.println("Found at position " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }

        System.out.println("Not found");
    }
}
