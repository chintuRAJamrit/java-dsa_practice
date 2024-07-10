
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MergeSortTimeAnalysis {
		public static void main(String[] args) {
		
		int[] nValues = {1000, 5000, 10000, 20000, 30000};
		
		Random random = new Random();
		
		for (int n : nValues) {
			int[] arr = new int[n];
			
			for (int i = 0; i < n; i++) {
			arr[i] = random.nextInt(100000);
			}
			
			long startTime = System.nanoTime();
			
			mergeSort(arr);
			
			long endTime = System.nanoTime();
			
			long timeTaken = (endTime - startTime) / 1000000;
			
			System.out.println("Time taken to sort " + n + " elements: " + timeTaken + " ms");
		}
		}

		public static void mergeSort(int[] arr) {
		if (arr.length <= 1) {
		return;
		}
		
		int mid = arr.length / 2;
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);
		
		mergeSort(left);
		mergeSort(right);
		
		merge(arr, left, right);
		}
		public static void merge(int[] arr, int[] left, int[] right) {
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
		if (left[i] < right[j]) {
		arr[k++] = left[i++];
		} else {
		arr[k++] = right[j++];
		}
		}
		while (i < left.length) {
		arr[k++] = left[i++];
		}
		while (j < right.length) {
		arr[k++] = right[j++];
		}
		}
	   }
