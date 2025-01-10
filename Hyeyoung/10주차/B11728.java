/*
 * 문제
 * 정렬되어있는 두 배열 A와 B가 주어진다. 두 배열을 합친 다음 정렬해서 출력하는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에 배열 A의 크기 N, 배열 B의 크기 M이 주어진다. (1 ≤ N, M ≤ 1,000,000)
 * 둘째 줄에는 배열 A의 내용이, 셋째 줄에는 배열 B의 내용이 주어진다. 배열에 들어있는 수는 절댓값이 109보다 작거나 같은 정수이다.
 * 
 * 출력
 * 첫째 줄에 두 배열을 합친 후 정렬한 결과를 출력한다.
 */
import java.util.*;
import java.io.*;

public class B11728 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
        {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
        {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        
        StringBuilder sb = new StringBuilder();
        merge(arr1, n, arr2, m, sb);
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }

    private static void merge(int[] sortedArr1, int n, int[] sortedArr2, int m, StringBuilder sb)
    {
        int finalIdx = 0;
        int idx1 = 0;
        int idx2 = 0;
        while (finalIdx < n + m)
        {
            if (idx2 < m && (idx1 >= n || sortedArr1[idx1] > sortedArr2[idx2]))
            {
                sb.append(sortedArr2[idx2] + " ");
                idx2++;
            }
            else
            {
                sb.append(sortedArr1[idx1] + " ");
                idx1++;
            }
            finalIdx++;
        }
    }
}
