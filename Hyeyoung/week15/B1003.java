import java.util.*;
import java.io.*;

public class B1003
{
    private static int MAX_K = 40;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] fibonacci_zeroCall = new int[MAX_K + 1];
        int[] fibonacci_oneCall = new int[MAX_K + 1];
        for (int i = 0; i <= MAX_K; i++)
        {
            fibonacci_zeroCall[i] = -1;
            fibonacci_oneCall[i] = -1;
        }
        fibonacci_zeroCall[0] = 1;
        fibonacci_oneCall[0] = 0;
        fibonacci_zeroCall[1] = 0;
        fibonacci_oneCall[1] = 1;
        for (int i = 0; i < n; i++)
        {
            int k = Integer.parseInt(br.readLine());
            getFibonacciCalls(fibonacci_zeroCall, fibonacci_oneCall, k);
            System.out.println(fibonacci_zeroCall[k] + " " + fibonacci_oneCall[k]);
        }
        br.close();
    }

    public static void getFibonacciCalls(int[] fibonacci_zeroCall, int[] fibonacci_oneCall, int i)
    {
        if (fibonacci_zeroCall[i] != -1)
        {
            return;
        }
        getFibonacciCalls(fibonacci_zeroCall, fibonacci_oneCall, i - 1);
        fibonacci_zeroCall[i] = fibonacci_zeroCall[i - 1] + fibonacci_zeroCall[i - 2];
        fibonacci_oneCall[i] = fibonacci_oneCall[i - 1] + fibonacci_oneCall[i - 2];
        return;
    }
}
