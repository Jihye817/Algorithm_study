import java.util.*;
import java.io.*;

public class B11003 {
    private static B11003 Default = new B11003();
    private class Node
    {
        int number;
        int idx;

        public Node(int n, int i) {
            number = n;
            idx = i;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        Deque<Node> dq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
        {
            int elm = Integer.parseInt(st.nextToken());
            Node newNode = Default.new Node(elm, i);

            if (!dq.isEmpty() && dq.peekFirst().idx == i-l)
            {
                dq.pollFirst();
            }

            while (!dq.isEmpty())
            {
                if (dq.peekLast().number < elm)
                {
                    break;
                }
                dq.pollLast();
            }
            dq.addLast(newNode);
            sb.append(dq.peekFirst().number + " ");
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }
}
