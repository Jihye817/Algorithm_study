import java.util.*;
import java.io.*;

public class QuickSort {
    public static int[] arr;
    public static void quickSort(int low, int high)
    {
        if (low >= high)
        {
            return;
        }
        if (high - low == 1)
        {
            if (arr[low] > arr[high])
            {
                swap(low, high);
            }
            return;
        }

        int pivotIdx = selectPivotIdx(low, high);
        int partitionPos = partition(low, high, pivotIdx);
        quickSort(low, partitionPos - 1);
        quickSort(partitionPos + 1, high);
    }

    // pivotIdx의 값 기준으로 arr[low]~arr[high] 구간을 나눔
    private static int partition(int low, int high, int pivotIdx)
    {
        // pivot을 맨 뒤 값과 바꿔줌
        int pivotVal = arr[pivotIdx];
        if (pivotIdx != high)
        {
            swap(high, pivotIdx);
        }

        // arr를 순회하면서 pivot 값보다 작은 원소는 앞으로 보냄
        int i = low - 1;
        for (int j = low; j < high; j++)
        {
            if (arr[j] < pivotVal)
            {
                i++;
                swap(i, j);
            }
        }

        // pivot 값을 중간의 값과 바꿔줌
        int pos = i + 1;
        swap(pos, high);

        return pos;
    }

    private static void swap(int idx1, int idx2)
    {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    // arr[low]~arr[high]를 나눌 때 쓸 피벗값 고르기
    private static int selectPivotIdx(int low, int high)
    {
        // 원소가 3개 이하면 맨 끝 값을 pivot으로 사용
        if (high - low <= 2)
            return high;
        // 아니면 맨 앞 / 중간 / 맨 끝값 중에 중간값을 pivot으로 사용
        int mid = (low + high) / 2;
        int[] candidates = new int[] {arr[low], arr[mid], arr[high]};
        int pivotIdx = low;
        if ((candidates[0] - candidates[1]) * (candidates[0] - candidates[2]) <= 0)
        {
            pivotIdx = low;
        }
        else if ((candidates[1] - candidates[0]) * (candidates[1] - candidates[2]) <= 0)
        {
            pivotIdx = mid;
        }
        else
        {
            pivotIdx = high;
        }

        return pivotIdx;
    }

    public static void main(String[] args) throws IOException
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
  
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(0, n - 1);

        for (int i = 0; i < n; i++)
        {
            System.out.printf("%d ", arr[i]);
        }
    }
}