import java.io.*;
import java.util.*;

public class B1260 {
    static int[][] graph;
    static int n;

    public static void dfs(int v)
    {
        Integer[] vertices = new Integer[n];
        for (int i = 0; i < n; i++)
        {
            vertices[i] = 0;
        }
        StringBuilder dfsSb = new StringBuilder();
        dfs_visit(vertices, v, dfsSb);
        System.out.println(dfsSb);
    }
    
    public static void dfs_visit(Integer[] vertices, int v, StringBuilder sb)
    {
        sb.append(v + 1 + " ");
        vertices[v] = 1;
        
        for (int i = 0; i < n; i++)
        {
            if (graph[i][v] == 1 && vertices[i]== 0)
            {
                dfs_visit(vertices, i, sb);
            }
        }
        vertices[v] = 2;
    }

    public static void bfs(int v)
    {
        Integer[] vertices = new Integer[n];
        for (int i = 0; i < n; i++)
        {
            vertices[i] = 0;
        }

        StringBuilder bfsSb = new StringBuilder();
        Queue<Integer> visitNodes = new LinkedList<Integer>();
        visitNodes.add(v);
        bfsSb.append((v+1) + " ");

        while (!visitNodes.isEmpty())
        {
            int target = visitNodes.poll();
            for (int i = 0; i < n; i++)
            {
                if (graph[i][target] == 1 && vertices[i] == 0)
                {
                    bfsSb.append((i+1) + " ");
                    vertices[i] = 1;
                    visitNodes.add(i);
                }
            }
            vertices[target] = 2;
        }
        
        System.out.println(bfsSb);
    }

    public static void main(String[] args) throws IOException
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
  
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken()) - 1;
        graph = new int[n][n];
        
        for (int i = 0; i < n; i++)
        {
            graph[i] = new int[n];
        }
        
        for (int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a - 1][b - 1] = 1;
            graph[b - 1][a - 1] = 1;
        }
        
        dfs(v);

        bfs(v);
    }
}
