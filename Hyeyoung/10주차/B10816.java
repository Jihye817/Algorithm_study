/*
 * 문제
 * 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
 * 셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
 * 
 * 출력
 * 첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.
 */
import java.util.*;
import java.io.*;

public class B10816 {
    public static void main(String[] args) throws IOException
    {
        // 입력받으면서 각 숫자 카드 몇 개였는지 세기
        solutionHashMap();

        // 이분 탐색으로 풀기
        // solutionBinarySearch();
    }

    private static void solutionBinarySearch() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
        {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
        {
            int target = Integer.parseInt(st.nextToken());
            int result = binarySearchForCount(arr, target, n);
            sb.append(result + " ");
        }

        br.close();
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }

    private static int binarySearchForCount(List<Integer> arr, int target, int totalLength)
    {
        return getUpperIdx(arr, target, totalLength) - getLowerIdx(arr, target, totalLength);
    }
    
    private static int getLowerIdx(List<Integer> arr, int target, int totalLength)
    {
        int start = 0;
        int end = totalLength;
        while (start < end)
        {
            int mid = (start + end) / 2;
            if (Integer.valueOf(arr.get(mid)) < target)
            {
                start = mid + 1;
            }
            else
            {
                end = mid;
            }
        }
        return start;
    }
    
    private static int getUpperIdx(List<Integer> arr, int target, int totalLength)
    {
        int start = 0;
        int end = totalLength;
        while (start < end)
        {
            int mid = (start + end) / 2;
            if (Integer.valueOf(arr.get(mid)) > target)
            {
                end = mid;
            }
            else
            {
                start = mid + 1;
            }
        }
        return start;
    }

    private static void solutionHashMap() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        final int minCardNum = -10000000;
        final int maxCardNum = 10000000;
        int[] arr = new int[maxCardNum - minCardNum + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
        {
            int card = Integer.parseInt(st.nextToken());
            arr[card - minCardNum]++;
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
        {
            int target = Integer.parseInt(st.nextToken());
            sb.append(arr[target - minCardNum] + " ");
        }

        br.close();
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }
}
