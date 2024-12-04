import java.util.*;

public class MergeSort {
    public static void mergeSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high)
    {
        int arrIdx = 0;
        int i = low; int j = mid + 1;
        int[] sortedArr = new int[high - low + 1];
        while (arrIdx < high - low + 1)
        {
            if (i <= mid && (j > high || arr[i] < arr[j]))
            {
                sortedArr[arrIdx] = arr[i];
                i++;
                arrIdx++;
            }
            else
            {
                sortedArr[arrIdx] = arr[j];
                j++;
                arrIdx++;
            }
        }

        for (int idx = low; idx <= high; idx++)
        {
            arr[idx] = sortedArr[idx - low];
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = scanner.nextInt();
        }

        mergeSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++)
        {
            System.out.printf("%d ", arr[i]);
        }

        scanner.close();
    }
}