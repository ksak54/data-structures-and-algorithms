package mergeSort;

public class MergeSort {
    MergeSort() {

    }

    public MergeSort(int[] ar, int low) {
        MergeSort ob = new MergeSort();
        ob.printArray(ar, "Before Sorting");
        ob.merge_sort(ar, 0, ar.length - 1);
        ob.printArray(ar, "After Sorting");
    }

    void printArray(int[] ar, String status) {
        System.out.println("\n" + status + ":");
        for (int i : ar) {

            System.out.print(i + "  ");
        }
    }

    void merge_sort(int[] ar, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            merge_sort(ar, l, m);
            merge_sort(ar, m + 1, r);
            merge(ar, l, m, r);
        }
    }

    void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (i < n2) {
            arr[k] = R[i];
            i++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] intArray = new int[] { 25, 46, 18, 75, 36, 24, 15, 25, 54, 99 };
        MergeSort ob = new MergeSort();
        ob.printArray(intArray, "Before Sorting");
        ob.merge_sort(intArray, 0, intArray.length - 1);
        ob.printArray(intArray, "After Sorting");
    }
}