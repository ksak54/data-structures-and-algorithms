
public class HeapSort {
    public static void maxHeapify(int[] ar, int i, int heapsize) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int key = ar[i];
        int largest;
        if (l < heapsize - 1 && ar[l] > ar[i])
            largest = l;
        else
            largest = i;
        if (r < heapsize - 1 && ar[r] > ar[largest])
            largest = r;
        if (largest != i) {
            ar[i] = ar[largest];
            ar[largest] = key;
            maxHeapify(ar, largest, heapsize);
        }

    }

    public static void buildMaxHeap(int[] ar) {

        for (int i = (ar.length - 1) / 2; i >= 0; i--) {
            maxHeapify(ar, i, ar.length - 1);
        }
    }

    public static void heapSort(int[] ar) {
        buildMaxHeap(ar);
        int key;
        int heapsize = ar.length - 1;
        for (int i = ar.length - 1; i > 0; i--) {
            key = ar[i];
            ar[i] = ar[0];
            ar[0] = key;
            heapsize--;
            maxHeapify(ar, 0, heapsize);

        }
    }

    public static void printArray(int[] ar) {
        for (int i : ar) {
            System.out.print(i + "  ");

        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Hello World");

        int[] ar = { 16, 4, 10, 14, 7, 9, 3, 2, 8, 1 };
        buildMaxHeap(ar);
        printArray(ar);
        heapSort(ar);

        printArray(ar);
    }
}
