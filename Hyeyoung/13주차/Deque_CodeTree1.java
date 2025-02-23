import java.util.*;
import java.io.*;

public class Deque_CodeTree1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++)
        {
            dq.addLast(i);
        }

        while (dq.size() > 1)
        {
            dq.removeFirst();
            dq.addLast(dq.removeFirst());
        }

        System.out.println(dq.peekFirst());
    }
}
