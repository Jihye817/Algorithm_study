import java.util.*;
import java.io.*;

public class B18352 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;

        List<Integer>[] edges = new List[n];
        
        for (int i = 0; i < n; i++)
        {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            edges[a].add(b);
        }
        
        Integer[] distances = new Integer[n];
        Arrays.fill(distances, -1);

        List<Integer> answer = new ArrayList<>();
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(x);
        distances[x] = 0;
        
        while (!q.isEmpty())
        {
            int curNode = q.poll();
            if (distances[curNode] == k) answer.add(curNode);
            for (int nextNode : edges[curNode])
            {
                if (distances[nextNode] != -1) continue;
                distances[nextNode] = distances[curNode] + 1;
                q.add(nextNode);
            }
        }
        
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (int cur : answer) {
            sb.append(cur + 1).append('\n');
        }

        System.out.print(answer.isEmpty() ? -1 : sb);
    }
}
