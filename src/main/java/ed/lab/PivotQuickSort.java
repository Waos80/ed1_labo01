package ed.lab;

import java.util.Random;

interface PartitionMethod {
    int partition(String[] arr, int start, int end);
}

public class PivotQuickSort {
    private static final Random rand = new Random();

    private static int highPivotPartition(String[] arr, int low, int high) {
        int pivot = Integer.parseInt(arr[high]);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (Integer.parseInt(arr[j]) <= pivot) {
                i++;
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    private static int lowPivotPartition(String[] arr, int low, int high) {
        int pivot = Integer.parseInt(arr[low]);
        int i = high + 1;

        for (int j = high; j > low; j--) {
            if (Integer.parseInt(arr[j]) >= pivot) {
                i--;
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        String temp = arr[i - 1];
        arr[i - 1] = arr[low];
        arr[low] = temp;
        return i - 1;
    }

    private static int randomPivotPartition(String[] arr, int low, int high) {
        int pivotIdx = rand.nextInt(high - low) + low;
        String temp = arr[high];
        arr[high] = arr[pivotIdx];
        arr[pivotIdx] = temp;

        int pivot = Integer.parseInt(arr[high]);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (Integer.parseInt(arr[j]) <= pivot) {
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


    private static void quickSort(String[] arr, int low, int high, PartitionMethod partitionMethod) {
        if (low < high) {
            int partition = partitionMethod.partition(arr, low, high);

            quickSort(arr, low, partition - 1, partitionMethod);
            quickSort(arr, partition + 1, high, partitionMethod);
        }
    }

    public static void highPivotSort(String[] array) {
        quickSort(array, 0, array.length - 1, PivotQuickSort::highPivotPartition);
    }

    public static void lowPivotSort(String[] array) {
        quickSort(array, 0, array.length - 1, PivotQuickSort::lowPivotPartition);
    }

    public static void randomPivotSort(String[] array) {
        quickSort(array, 0, array.length - 1, PivotQuickSort::randomPivotPartition);
    }
}
