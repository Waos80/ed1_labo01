package ed.lab;

import java.util.Random;

interface PartitionMethod {
    int partition(Integer[] arr, int start, int end);
}

public class PivotQuickSort {
    private static final Random rand = new Random();

    private static int highPivotPartition(Integer[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
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

    private static int lowPivotPartition(Integer[] arr, int low, int high) {
        int pivot = arr[low];
        int i = high + 1;

        for (int j = high; j > low; j--) {
            if (arr[j] >= pivot) {
                i--;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i - 1];
        arr[i - 1] = arr[low];
        arr[low] = temp;
        return i - 1;
    }

    private static int randomPivotPartition(Integer[] arr, int low, int high) {
        int pivotIdx = rand.nextInt(high - low) + low;
        int temp = arr[high];
        arr[high] = arr[pivotIdx];
        arr[pivotIdx] = temp;

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }


    private static void quickSort(Integer[] arr, int low, int high, PartitionMethod partitionMethod) {
        if (low < high) {
            int partition = partitionMethod.partition(arr, low, high);

            quickSort(arr, low, partition - 1, partitionMethod);
            quickSort(arr, partition + 1, high, partitionMethod);
        }
    }

    public static void highPivotSort(Integer[] array) {
        quickSort(array, 0, array.length - 1, PivotQuickSort::highPivotPartition);
    }

    public static void lowPivotSort(Integer[] array) {
        quickSort(array, 0, array.length - 1, PivotQuickSort::lowPivotPartition);
    }

    public static void randomPivotSort(Integer[] array) {
        quickSort(array, 0, array.length - 1, PivotQuickSort::randomPivotPartition);
    }
}
