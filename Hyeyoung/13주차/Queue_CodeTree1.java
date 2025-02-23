import java.util.*;
import java.io.*;

public class Queue_CodeTree1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++)
        {
            queue.add(i);
        }

        while (queue.isEmpty() == false)
        {
            for (int i = 1; i < k; i++)
            {
                queue.add(queue.poll());
            }
            int eliminated = queue.poll();
            System.out.print(eliminated + " ");
        }
    }
}
