import java.util.Scanner;

public class MenuBasedArrayDSA {

    private int[] arr;      // physical array
    private int size;       // logical size
    private Scanner sc;

    public MenuBasedArrayDSA() {
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        MenuBasedArrayDSA obj = new MenuBasedArrayDSA();
        obj.menu();
    }

    // ---------------- MENU ----------------
    public void menu() {
        int choice;

        do {
            System.out.println("\n----- ARRAY OPERATIONS MENU -----");
            System.out.println("1. Create Array");
            System.out.println("2. Display Array");
            System.out.println("3. Insert Element");
            System.out.println("4. Delete Element");
            System.out.println("5. Search Element");
            System.out.println("6. Update Element");
            System.out.println("7. Find Max and Min");
            System.out.println("8. Reverse Array");
            System.out.println("9. Sort Array");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1: createArray(); break;
                case 2: displayArray(); break;
                case 3: insertElement(); break;
                case 4: deleteElement(); break;
                case 5: searchElement(); break;
                case 6: updateElement(); break;
                case 7: findMaxMin(); break;
                case 8: reverseArray(); break;
                case 9: sortArray(); break;
                case 0: System.out.println("Exiting program..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    // ---------------- CREATE ----------------
    public void createArray() {
        System.out.print("Enter number of elements: ");
        size = sc.nextInt();

        arr = new int[100];   // fixed capacity
        System.out.println("Enter elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
    }

    // ---------------- DISPLAY ----------------
    public void displayArray() {
        if (arr == null) {
            System.out.println("Array not created!");
            return;
        }

        System.out.print("Array Elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // ---------------- INSERT (IN-PLACE) ----------------
    public void insertElement() {
        if (arr == null) {
            System.out.println("Array not created!");
            return;
        }

        if (size == arr.length) {
            System.out.println("Array is full!");
            return;
        }

        System.out.print("Enter index: ");
        int index = sc.nextInt();

        System.out.print("Enter value: ");
        int value = sc.nextInt();

        if (index < 0 || index > size) {
            System.out.println("Invalid index!");
            return;
        }

        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }

        arr[index] = value;
        size++;

        System.out.println("Element inserted successfully.");
    }

    // ---------------- DELETE (IN-PLACE) ----------------
    public void deleteElement() {
        if (arr == null) {
            System.out.println("Array not created!");
            return;
        }

        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }

        System.out.print("Enter index to delete: ");
        int index = sc.nextInt();

        if (index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        size--;
        System.out.println("Element deleted successfully.");
    }

    // ---------------- SEARCH ----------------
    public void searchElement() {
        if (arr == null) {
            System.out.println("Array not created!");
            return;
        }

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at index: " + i);
                return;
            }
        }

        System.out.println("Element not found.");
    }

    // ---------------- UPDATE ----------------
    public void updateElement() {
        if (arr == null) {
            System.out.println("Array not created!");
            return;
        }

        System.out.print("Enter index to update: ");
        int index = sc.nextInt();

        if (index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return;
        }

        System.out.print("Enter new value: ");
        arr[index] = sc.nextInt();

        System.out.println("Element updated successfully.");
    }

    // ---------------- MAX & MIN ----------------
    public void findMaxMin() {
        if (arr == null) {
            System.out.println("Array not created!");
            return;
        }

        int max = arr[0], min = arr[0];

        for (int i = 1; i < size; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }

        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }

    // ---------------- REVERSE ----------------
    public void reverseArray() {
        if (arr == null) {
            System.out.println("Array not created!");
            return;
        }

        int i = 0, j = size - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        System.out.println("Array reversed.");
    }

    // ---------------- SORT ----------------
    public void sortArray() {
        if (arr == null) {
            System.out.println("Array not created!");
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("Array sorted in ascending order.");
    }
}
