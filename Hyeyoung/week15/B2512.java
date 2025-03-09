import java.util.*;
import java.io.*;

public class B2512 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] requestedBudgets = new int[n];
        int totalRequestedBudget = 0;
        int maxRequestedBudget = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
        {
            requestedBudgets[i] = Integer.parseInt(st.nextToken());
            totalRequestedBudget += requestedBudgets[i];
            maxRequestedBudget = Math.max(maxRequestedBudget, requestedBudgets[i]);
        }

        int totalBudget = Integer.parseInt(br.readLine());
        br.close();

        if (totalBudget >= totalRequestedBudget)
        {
            System.out.println(maxRequestedBudget);
            return;
        }
        
        Arrays.sort(requestedBudgets);

        int start = 0;
        int end = maxRequestedBudget;
        int result = 0;

        while (start <= end)
        {
            int mid = (start + end) / 2;
            int sum = 0;
            for (int i = 0; i < n; i++)
            {
                sum += requestedBudgets[i] > mid ? mid : requestedBudgets[i];
            }
            if (totalBudget >= sum)
            {
                result = mid;
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
