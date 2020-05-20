public class HeapSort {
    void buildMaxHeap(int[] A) {
        int heap_size = A.length - 1;
        // for (int i = A.length / 2 - 1; i >= 0; i--) {

        // }
        maxHeapify(A, heap_size / 2, heap_size);
    }

    void maxHeapify(int[] A, int i, int heapsize) {
        int l = left(i);
        int r = right(i);
        int key = A[i];
        int largest;
        if (l <= heapsize && A[l] > A[i]) {
            largest = l;
        } else
            largest = i;

        if (r <= heapsize && A[r] > A[largest]) {
            largest = r;
        }
        if (largest != i) {
            A[i] = A[largest];
            A[largest] = key;
            maxHeapify(A, largest, heapsize);
        }
        if (i > 0 && largest == i) {
            maxHeapify(A, largest - 1, heapsize);
        }

    }

    void heap_sort(int[] A) {
        int heapsize = A.length - 1;
        buildMaxHeap(A);
        for (int i = A.length - 1; i > 0; i--) {

            int key = A[0];
            A[0] = A[i];
            A[i] = key;
            heapsize--;
            maxHeapify(A, heapsize / 2, heapsize);

        }
    }

    int left(int i) {
        return (2 * i + 1);
    }

    int right(int i) {
        return (2 * i + 2);
    }

    void printArray(int[] ar) {
        for (int i : ar) {
            System.out.print(i + "  ");

        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] intArray = new int[] { 12, 45, 66, 85, 17, 47, 68, 2 };
        HeapSort ob = new HeapSort();
        System.out.println("before HeapSort:");
        ob.printArray(intArray);
        System.out.println("\nAfter HeapSort:");
        ob.heap_sort(intArray);
        ob.printArray(intArray);

    }
}