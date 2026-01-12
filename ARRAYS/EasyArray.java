import java.util.*;

public class EasyArray {

    private int[] arr;
    private int size;
    private final int CAPACITY = 100;
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new EasyArray().menu();
    }

    // ================= MENU =================
    public void menu() {
        int choice;
        do {
            System.out.println("\n------ ARRAY DSA MENU ------");
            System.out.println("1. Create Array");
            System.out.println("2. Display Array");
            System.out.println("3. Largest Element in Array");
            System.out.println("4. Second Largest Element (without sorting)");
            System.out.println("5. Check if Array is Sorted");
            System.out.println("6. Remove Duplicates from Sorted Array");
            System.out.println("7. Left Rotate Array by One Place");
            System.out.println("8. Left Rotate Array by D Places");
            System.out.println("9. Move Zeros to End");
            System.out.println("10. Linear Search");
            System.out.println("11. Find Union of Two Sorted Arrays");
            System.out.println("12. Find Missing Number in Array");
            System.out.println("13. Maximum Consecutive Ones");
            System.out.println("14. Find Number Appearing Once (Others Twice)");
            System.out.println("15. Longest Subarray with Sum K (Positives)");
            System.out.println("16. Longest Subarray with Sum K (Positives + Negatives)");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            execute(choice);

        } while (choice != 0);
    }

    private void execute(int c) {
        if (arr == null && c != 1 && c != 0) {
            System.out.println("Create the array first.");
            return;
        }

        switch (c) {
            case 1 -> createArray();
            case 2 -> displayArray();
            case 3 -> largestElement();
            case 4 -> secondLargestElement();
            case 5 -> checkSorted();
            case 6 -> removeDuplicates();
            case 7 -> leftRotateOne();
            case 8 -> leftRotateD();
            case 9 -> moveZeros();
            case 10 -> linearSearch();
            case 11 -> findUnion();
            case 12 -> findMissingNumber();
            case 13 -> maxConsecutiveOnes();
            case 14 -> findSingleNumber();
            case 15 -> longestSubarrayPositive();
            case 16 -> longestSubarrayAll();
            case 0 -> System.out.println("Program Ended");
            default -> System.out.println("Invalid choice");
        }
    }

    // ================= BASIC =================

    private void createArray() {
        System.out.print("Enter size: ");
        size = sc.nextInt();
        arr = new int[CAPACITY];
        System.out.println("Enter elements:");
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();
    }

    private void displayArray() {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // ================= CHECKLIST PROBLEMS =================

    // 1. Largest element in array — O(n)
    private void largestElement() {
        int max = arr[0];
        for (int i = 1; i < size; i++)
            if (arr[i] > max) max = arr[i];
        System.out.println("Largest Element: " + max);
    }

    // 2. Second largest without sorting — O(n)
    private void secondLargestElement() {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }
        System.out.println("Second Largest Element: " + second);
    }

    // 3. Check if array sorted — O(n)
    private void checkSorted() {
        for (int i = 1; i < size; i++) {
            if (arr[i] < arr[i - 1]) {
                System.out.println("Array is NOT sorted");
                return;
            }
        }
        System.out.println("Array is sorted");
    }

    // 4. Remove duplicates from sorted array — O(n)
    private void removeDuplicates() {
        int j = 0;
        for (int i = 1; i < size; i++) {
            if (arr[i] != arr[j]) {
                arr[++j] = arr[i];
            }
        }
        size = j + 1;
        System.out.println("Duplicates removed");
    }

    // 5. Left rotate by one — O(n)
    private void leftRotateOne() {
        int temp = arr[0];
        for (int i = 1; i < size; i++)
            arr[i - 1] = arr[i];
        arr[size - 1] = temp;
        System.out.println("Array rotated by one");
    }

    // 6. Left rotate by D — O(n)
    private void leftRotateD() {
        System.out.print("Enter D: ");
        int d = sc.nextInt() % size;
        reverse(0, d - 1);
        reverse(d, size - 1);
        reverse(0, size - 1);
        System.out.println("Array rotated by " + d);
    }

    // 7. Move zeros to end — O(n)
    private void moveZeros() {
        int j = 0;
        for (int i = 0; i < size; i++)
            if (arr[i] != 0)
                arr[j++] = arr[i];
        while (j < size)
            arr[j++] = 0;
        System.out.println("Zeros moved to end");
    }

    // 8. Linear search — O(n)
    private void linearSearch() {
        System.out.print("Enter key: ");
        int key = sc.nextInt();
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                System.out.println("Found at index " + i);
                return;
            }
        }
        System.out.println("Not found");
    }

    // 9. Union of two sorted arrays — O(n + m)
    private void findUnion() {
        System.out.print("Enter size of second array: ");
        int n = sc.nextInt();
        int[] b = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) b[i] = sc.nextInt();

        int i = 0, j = 0;
        while (i < size && j < n) {
            if (arr[i] < b[j]) System.out.print(arr[i++] + " ");
            else if (b[j] < arr[i]) System.out.print(b[j++] + " ");
            else {
                System.out.print(arr[i] + " ");
                i++; j++;
            }
        }
        while (i < size) System.out.print(arr[i++] + " ");
        while (j < n) System.out.print(b[j++] + " ");
        System.out.println();
    }

    // 10. Missing number (1..N) — O(n)
    private void findMissingNumber() {
        int total = size * (size + 1) / 2;
        int sum = 0;
        for (int i = 0; i < size - 1; i++)
            sum += arr[i];
        System.out.println("Missing Number: " + (total - sum));
    }

    // 11. Maximum consecutive ones — O(n)
    private void maxConsecutiveOnes() {
        int max = 0, count = 0;
        for (int i = 0; i < size; i++) {
            count = (arr[i] == 1) ? count + 1 : 0;
            max = Math.max(max, count);
        }
        System.out.println("Max Consecutive Ones: " + max);
    }

    // 12. Single number (XOR) — O(n)
    private void findSingleNumber() {
        int xor = 0;
        for (int i = 0; i < size; i++)
            xor ^= arr[i];
        System.out.println("Single Number: " + xor);
    }

    // 13. Longest subarray sum K (positives) — O(n)
    private void longestSubarrayPositive() {
        System.out.print("Enter K: ");
        int k = sc.nextInt();

        int sum = 0, left = 0, maxLen = 0;
        for (int right = 0; right < size; right++) {
            sum += arr[right];
            while (sum > k)
                sum -= arr[left++];
            if (sum == k)
                maxLen = Math.max(maxLen, right - left + 1);
        }
        System.out.println("Longest Length: " + maxLen);
    }

    // 14. Longest subarray sum K (pos + neg) — O(n)
    private void longestSubarrayAll() {
        System.out.print("Enter K: ");
        int k = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (int i = 0; i < size; i++) {
            sum += arr[i];
            if (sum == k)
                maxLen = i + 1;

            if (!map.containsKey(sum))
                map.put(sum, i);

            if (map.containsKey(sum - k))
                maxLen = Math.max(maxLen, i - map.get(sum - k));
        }
        System.out.println("Longest Length: " + maxLen);
    }

    // ================= HELPER =================
    private void reverse(int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
