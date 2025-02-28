import java.util.*;
import java.io.*;

public class B1068 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] nodeParents = new int[n];
        int[] childNodeCounts = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
        {
            nodeParents[i] = Integer.parseInt(st.nextToken());
            childNodeCounts[i] = 0;
        }

        int eliminated = Integer.parseInt(br.readLine());
        br.close();
        
        for (int i = 0; i < n; i++)
        {
            if (i == eliminated)
            {
                childNodeCounts[i] = -1;
                continue;
            }
            int parentNode = nodeParents[i];
            boolean toBeEliminated = false;
            while (parentNode != -1)
            {
                if (parentNode == eliminated || childNodeCounts[parentNode] == -1)
                {
                    toBeEliminated = true;
                    childNodeCounts[parentNode] = -1;
                    break;
                }
                childNodeCounts[parentNode]++;
                parentNode = nodeParents[parentNode];
            }
            if (toBeEliminated)
            {
                childNodeCounts[i] = -1;
            }
        }
        
        int leafNodeCount = 0;
        for (int i = 0; i < n; i++)
        {
            if (childNodeCounts[i] == 0)
            {
                leafNodeCount++;
            }
        }

        System.out.println(leafNodeCount);
    }
}
