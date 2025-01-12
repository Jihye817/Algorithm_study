import java.util.*;
import java.io.*;

public class B1325 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] edges = new List[n + 1];
        for (int i = 1; i <= n; i++)
        {
            edges[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[b].add(a);
        }
        br.close();

        int[] childCount = new int[n+1];
        int maxChildCount = -1;
        List<Integer> maxChildNodes = new ArrayList<>();
        for (int i = 1; i <= n; i++)
        {
            childCount[i] = bfs(i, n, edges);
            if (maxChildCount < childCount[i])
            {
                maxChildNodes.clear();
                maxChildNodes.add(i);
                maxChildCount = childCount[i];
            }
            else if (maxChildCount == childCount[i])
            {
                maxChildNodes.add(i);
            }
        }

        Collections.sort(maxChildNodes);

        StringBuilder sb = new StringBuilder();
        for (int cur : maxChildNodes) {
            sb.append(cur).append('\n');
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }

    private static int bfs(int startNode, int nodeCount, List<Integer>[] edges)
    {
        boolean[] visited = new boolean[nodeCount + 1];
        int visitedCount = 1;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(startNode);
        visited[startNode] = true;

        while (!q.isEmpty())
        {
            int current = q.poll();
            for (int nextNode: edges[current])
            {
                if (!visited[nextNode])
                {
                    q.add(nextNode);
                    visited[nextNode] = true;
                    visitedCount++;
                }
            }
        }
        return visitedCount;
    }
}
