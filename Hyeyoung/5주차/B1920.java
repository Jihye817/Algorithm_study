import java.io.*;
import java.util.StringTokenizer;

public class B1920 {
    static int[] arr;

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

    public static boolean simpleSearch(int[] targetArr, int searchTarget)
    {
        for (int n : targetArr)
        {
            if (searchTarget == n)
                return true;
        }

        return false;
    }

    public static boolean binarySearch(int[] targetArr, int searchTarget)
    {
        return binarySearchInternal(targetArr, 0, targetArr.length - 1, searchTarget);
    }

    private static boolean binarySearchInternal(int[] targetArr, int startIdx, int endIdx, int searchTarget)
    {
        if (startIdx >= endIdx - 1)
        {
            return targetArr[startIdx] == searchTarget || targetArr[endIdx] == searchTarget;
        }
        int midIdx = (startIdx + endIdx) / 2;
        int midElm = targetArr[midIdx];
        if (midElm == searchTarget)
        {
            return true;
        }
        else if (midElm < searchTarget)
        {
            return binarySearchInternal(targetArr, midIdx + 1, endIdx, searchTarget);
        }
        return binarySearchInternal(targetArr, startIdx, midIdx - 1, searchTarget);
    }

    public static void main(String[] args) throws IOException
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
  
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
		}
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        // 단순 검색의 시간 복잡도: n개의 원소를 가진 arr를 m번 순회 => O(n*m)
        // 정렬한 다음 검색의 시간 복잡도: 정렬에 O(n *log2n), m번 이진 탐색에 O(m*log2n) => O((n+m)*log2n)
        double binarySearchBigO = (n + m) * (Math.log(n) / Math.log(2));
        double simpleSearchBigO = n * m;
        boolean doBinarySearch = simpleSearchBigO > binarySearchBigO;
        //System.out.println(doSimpleSearch ? "simpleSearch" : "binarySearch");

        // 정렬이 빠르면 머지 소트 돌리고 수 찾기 시작
        if (doBinarySearch)
        {
            mergeSort(arr, 0, n - 1);
        }
        
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++)
        {
            int key = Integer.parseInt(st.nextToken());
            boolean isFound = doBinarySearch ? simpleSearch(arr, key) : binarySearch(arr, key);
			sb.append(isFound ? "1" : "0").append('\n');
		}
        System.out.println(sb);
    }

    // 오답노트: input 양이 많으면 Scanner는 답이 없다
}
