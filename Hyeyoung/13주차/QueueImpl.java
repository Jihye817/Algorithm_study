import java.util.*;
import java.io.*;

public class QueueImpl 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd)
            {
                case "push":
                {
                    int a = Integer.parseInt(st.nextToken());
                    queue.add(a);
                    break;
                }
                case "pop":
                {
                    int last = queue.poll();
                    System.out.println(last);
                    break;
                }
                case "size":
                {
                    System.out.println(queue.size());
                    break;
                }
                case "empty":
                {
                    System.out.println(queue.isEmpty() ? "1": "0");
                    break;
                }
                case "front":
                {
                    System.out.println(queue.peek());
                    break;
                }
            }
        }
    }
}
