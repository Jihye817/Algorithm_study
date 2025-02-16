import java.util.*;
import java.io.*;

public class B14003
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int[] arr = new int[length];
        int[] sequence = new int[length];
        int[] indexOrder = new int[length];
        int len = 0;
        for (int i = 0; i < length; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i == 0 || sequence[len - 1] < arr[i])
            {
                indexOrder[i] = len;
                sequence[len] = arr[i];
                len++;
            }
            else
            {
                int idx = Arrays.binarySearch(sequence, 0, len, arr[i]);
                indexOrder[i] = idx >=0 ? idx : -(idx+1);
                sequence[indexOrder[i]] = arr[i];
            }
        }

        System.out.println(len);
        
        int lastIdx = len - 1;
        int[] answer = new int[len];
        for (int i = length - 1; i >= 0; i--)
        {
            int curIdx = indexOrder[i];
            if (curIdx == lastIdx)
            {
                answer[curIdx] = arr[i];
                lastIdx--;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++)
        {
            sb.append(answer[i] + " ");
        }
        System.out.println(sb.toString());
    }
}