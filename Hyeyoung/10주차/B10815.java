/*
 * 문제
 * 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다. 
 * 두 숫자 카드에 같은 수가 적혀있는 경우는 없다.
 * 셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다
 * 
 * 출력
 * 첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 가지고 있으면 1을, 아니면 0을 공백으로 구분해 출력한다.
 */
import java.util.*;
import java.io.*;

public class B10815 {
    public static void main(String[] args) throws IOException
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

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        // m이 작아서 그냥 선형 검색이 빠르면 정렬 X
        // O((m+n)logn) vs O(mn)
        // boolean isSorted = false;
        // if ((m + n) * Math.log(n) <= m * n)
        // {
        Collections.sort(arr);
        //     isSorted = true;
        // }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
        {
            int target = Integer.parseInt(st.nextToken());
            boolean found = binarySearch(arr, target, 0, arr.size() - 1);
            sb.append(found ? "1 ": "0 ");
        }

        br.close();
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }

    private static boolean binarySearch(List<Integer> arr, int target, int startIdx, int endIdx)
    {
        int startVal = Integer.valueOf(arr.get(startIdx));
        int endVal = Integer.valueOf(arr.get(endIdx));
        if (target < Integer.valueOf(startVal) || target > endVal)
        {
            return false;
        }
        if (target == startVal || target == endVal)
        {
            return true;
        }
        int midIdx = (startIdx + endIdx) / 2;
        int midVal = Integer.valueOf(arr.get(midIdx));
        if (target == midVal)
        {
            return true;
        }
        if (target < midVal)
        {
            return binarySearch(arr, target, startIdx, midIdx - 1);
        }
        else
        {
            return binarySearch(arr, target, midIdx + 1, endIdx);
        }
    }
}
