import java.util.*;
import java.io.*;

public class B7562 {
    static B7562 Default = new B7562();

    public static void main(String[] args) throws IOException
    {
        Coordinate[] connectedDeltas = new Coordinate[]
        {
            Default.new Coordinate(-2, 1),
            Default.new Coordinate(-2, -1),
            Default.new Coordinate(-1, 2),
            Default.new Coordinate(-1, -2),
            Default.new Coordinate(1, 2),
            Default.new Coordinate(1, -2),
            Default.new Coordinate(2, 1),
            Default.new Coordinate(2, -1),
        };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int goalX = Integer.parseInt(st.nextToken());
            int goalY = Integer.parseInt(st.nextToken());

            solve(l, Default.new Coordinate(startX, startY), Default.new Coordinate(goalX, goalY), connectedDeltas, sb);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    public static void solve(int l, Coordinate start, Coordinate goal, Coordinate[] connectedDeltas, StringBuilder sb)
    {
        if (start.equals(goal))
        {
            sb.append(0 + "\n");
            return;
        }

        int[][] count = new int[l][l];
        for (int i = 0; i < l; i++)
        {
            for (int j = 0; j < l; j++)
                count[i][j] = -1;
        }

        ArrayDeque<Coordinate> q = new ArrayDeque<>();
        q.add(start);
        count[start.X][start.Y] = 0;

        while (!q.isEmpty())
        {
            Coordinate cur = q.poll();
            for (Coordinate delta : connectedDeltas)
            {
                Coordinate next = cur.add(delta);
                if (next.isValid(l) == false) continue;
                if (count[next.X][next.Y] != -1) continue;

                q.add(next);
                count[next.X][next.Y] = count[cur.X][cur.Y] + 1;
                
                if (next.equals(goal))
                {
                    sb.append(count[next.X][next.Y] + "\n");
                    return;
                }
            }
        }
    }

    private class Coordinate
    {
        int X;
        int Y;

        public Coordinate(int x, int y) {
            X = x;
            Y = y;
        }

        public Boolean isValid(int l)
        {
            return X >= 0 && X < l && Y >= 0 && Y < l;
        }

        public Coordinate add(Coordinate other)
        {
            return new Coordinate(X + other.X, Y + other.Y);
        }

        public Boolean equals(Coordinate other)
        {
            return X == other.X && Y == other.Y;
        }
    }
}
