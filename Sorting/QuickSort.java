public class QuickSort {
    void quick_sort(int[] A, int p, int r) {
        if (p < r) // To avoid (0,0) element partition
        {
            int q = partition(A, p, r);
            quick_sort(A, p, q - 1);
            quick_sort(A, q + 1, r);
        }
    }

    private int partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i++;
                int key = A[j];
                A[j] = A[i];
                A[i] = key;
            }
        }
        int key = A[r];
        A[r] = A[i + 1];
        A[i + 1] = key;

        return (i + 1);
    }

    void printArray(int[] ar) {

        for (int i : ar) {
            System.out.print(i + "  ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        QuickSort ob = new QuickSort();
        int[] intArray = new int[] { 16, 4, 10, 14, 7, 9, 3, 2, 8, 1 };
        System.out.println("Array before sorting: ");
        ob.printArray(intArray);
        System.out.println("Array after sorting: ");
        ob.quick_sort(intArray, 0, intArray.length - 1);
        ob.printArray(intArray);

    }

}