import java.util.*;
import java.io.*;

public class StackImpl {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int stackSize = 0;
        for (int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd)
            {
                case "push":
                {
                    int a = Integer.parseInt(st.nextToken());
                    arr[stackSize] = a;
                    stackSize++;
                    break;
                }
                case "pop":
                {
                    stackSize--;
                    int last = arr[stackSize];
                    System.out.println(last);
                    break;
                }
                case "size":
                {
                    System.out.println(stackSize);
                    break;
                }
                case "empty":
                {
                    System.out.println(stackSize == 0 ? "1": "0");
                    break;
                }
                case "top":
                {
                    System.out.println(arr[stackSize - 1]);
                    break;
                }
            }
        }
    }
}