public class InsertionSort {
    void printArray(int[] ar, String status) {
        System.out.println("\n" + status + ":");
        for (int i : ar) {

            System.out.print(i + "  ");
        }

    }

    void insertion_sort(int[] ar) {
        for (int j = 2; j < ar.length; j++) {
            int key = ar[j];
            int i = j - 1;
            while (i >= 0 && key < ar[i]) {
                ar[i + 1] = ar[i];
                i--;
                ar[i + 1] = key;
            }

        }

    }

    public static void main(String[] args) {
        int[] intArray = new int[] { 25, 46, 18, 75, 36, 24, 15, 25, 54, 99 };
        InsertionSort ob = new InsertionSort();
        ob.printArray(intArray, "Before Sorting");
        ob.insertion_sort(intArray);
        ob.printArray(intArray, "After Sorting");
    }
}