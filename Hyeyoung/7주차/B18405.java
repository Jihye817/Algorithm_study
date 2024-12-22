import java.io.*;
import java.util.*;

public class B18405 {
    static int n;
    static int k;
    static ArrayList<ArrayList<Coordinate>> viruses;
    static Integer[][] vertices;
    static Coordinate[] connected;
    static B18405 Default = new B18405();

    public class Coordinate
    {
        int X;
        int Y;
        public Coordinate(int x, int y)
        {
            X = x;
            Y = y;
        }

        public Coordinate add(Coordinate other)
        {
            return new Coordinate(X + other.X, Y + other.Y);
        }

        public Boolean isValid()
        {
            return 0 <= X && X < n && 0 <= Y && Y < n;
        }
    }

    public static void Tick()
    {
        for (int i = 1; i <= k; i++)
        {
            ArrayList<Coordinate> virusCoordinates = viruses.get(i);
            ArrayList<Coordinate> toAddNodes = new ArrayList<Coordinate>();
            ArrayList<Coordinate> toRemoveNodes = new ArrayList<Coordinate>();
            for (Coordinate coordinate : virusCoordinates)
            {
                int virusId = vertices[coordinate.X][coordinate.Y];

                // 상하좌우 노드 중 아직 전염되지 않은 곳이 있으면 전파
                for (Coordinate delta : connected)
                {
                    Coordinate nextNode = coordinate.add(delta);
                    if (nextNode.isValid() == false)
                        continue;
                    Integer nextVertex = vertices[nextNode.X][nextNode.Y];
                    if (nextVertex == 0)
                    {
                        vertices[nextNode.X][nextNode.Y] = virusId;
                        toAddNodes.add(nextNode);
                    }
                }

                // v에 대한 탐색은 끝났으므로 다음 Tick 전파 확인 대상에서 제외
                toRemoveNodes.add(coordinate);
            }

            for (Coordinate nextCoordinate : toAddNodes)
            {
                virusCoordinates.add(nextCoordinate);
            }
            
            for (Coordinate removeCoordinate : toRemoveNodes)
            {
                virusCoordinates.remove(removeCoordinate);
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
  
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        connected = new Coordinate[] {
            Default.new Coordinate(0, 1),
            Default.new Coordinate(0, -1),
            Default.new Coordinate(1, 0),
            Default.new Coordinate(-1, 0),
        };

        vertices = new Integer[n][];
        for (int i = 0; i < n; i++)
        {
            vertices[i] = new Integer[n];
        }

        viruses = new ArrayList<ArrayList<Coordinate>>();
        for (int i = 0; i <= k; i++)
        {
            ArrayList<Coordinate> array = new ArrayList<Coordinate>();
            viruses.add(array);
        }

        for (int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
            {
                int virusId = Integer.parseInt(st.nextToken());
                vertices[i][j] = virusId;
                if (virusId != 0)
                {
                    viruses.get(virusId).add(Default.new Coordinate(i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;

        for (int time = 0; time < s; time++)
        {
            Tick();
            if (vertices[x][y] != 0)
                break;
        }

        System.out.println(vertices[x][y]);
    }
}
