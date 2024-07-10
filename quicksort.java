
import java.util.Random;



public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];  
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }



        public static void main(String[] args) {
            int[] nValues = {10, 100, 1000, 10000}; // Different values of n
            for (int n : nValues) {
                int[] arr = generateRandomArray(n);
                long startTime = System.nanoTime();
                QuickSort.quickSort(arr, 0, n - 1);
                long endTime = System.nanoTime();
                long elapsedTime = endTime - startTime;
                System.out.println("Time taken to sort " + n + " elements: " + elapsedTime + " ns");
            }
        }

        private static int[] generateRandomArray(int n) {
            int[] arr = new int[n];
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                arr[i] = random.nextInt(10000); // Adjust the range as needed
            }
            return arr;
        }

}


