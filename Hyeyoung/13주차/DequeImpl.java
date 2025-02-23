import java.util.*;
import java.io.*;

public class DequeImpl 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd)
            {
                case "push_front":
                {
                    int a = Integer.parseInt(st.nextToken());
                    dq.addFirst(a);
                    break;
                }
                case "push_back":
                {
                    int a = Integer.parseInt(st.nextToken());
                    dq.addLast(a);
                    break;
                }
                case "pop_front":
                {
                    int value = dq.pollFirst();
                    System.out.println(value);
                    break;
                }
                case "pop_back":
                {
                    int value = dq.pollLast();
                    System.out.println(value);
                    break;
                }
                case "size":
                {
                    System.out.println(dq.size());
                    break;
                }
                case "empty":
                {
                    System.out.println(dq.isEmpty() ? "1": "0");
                    break;
                }
                case "front":
                {
                    System.out.println(dq.peekFirst());
                    break;
                }
                case "back":
                {
                    System.out.println(dq.peekLast());
                    break;
                }
            }
        }
    }
}
