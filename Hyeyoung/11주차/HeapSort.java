import java.util.*;
import java.io.*;

public class HeapSort {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        heapSort(arr, n);
    
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
        {
            sb.append(arr[i] + " ");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }

    private static void heapSort(int[] arr, int n)
    {
        for (int i = n/2; i >= 1; i--)
        {
            heapify(arr, n, i);
        }

        for (int i = n; i > 1; i--)
        {
            swap(arr, i, 1);
            heapify(arr, i-1, 1);
        }
    }

    private static void heapify(int[] arr, int count, int idx)
    {
        int largest = idx;
        int leftChild = 2 * idx;
        int rightChild = 2 * idx + 1;

        if (leftChild <= count && arr[leftChild] > arr[largest])
        {
            largest = leftChild;
        }
        if (rightChild <= count && arr[rightChild] > arr[largest])
        {
            largest = rightChild;
        }

        if (largest != idx)
        {
            swap(arr, idx, largest);
            heapify(arr, count, largest);
        }
    }

    private static void swap(int[] arr, int idx1, int idx2)
    {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}