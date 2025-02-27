import java.util.*;
import java.io.*;

public class B3078 {
    private static int MAX_NAME_LENGTH = 20;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 이름 길이 별로 성적순 queue 별도 관리
        Queue<Integer>[] nameByLengthQueue = new LinkedList[MAX_NAME_LENGTH + 1];
        for (int i = 2; i <= MAX_NAME_LENGTH; i++)
        {
            nameByLengthQueue[i] = new LinkedList<>();
        }

        long goodFriends = 0;
        for (int ranking = 0; ranking < n; ranking++)
        {
            String name = br.readLine();
            Queue<Integer> queue = nameByLengthQueue[name.length()];
            queue.add(ranking);
            while (true)
            {
                int firstRank = queue.peek();
                // 이름 길이 같은 애가 나밖에 없음 : 친구 없음
                if (firstRank == ranking)
                {
                    break;
                }
                // 나랑 이름 길이 같은 애들 중에 1등이 k 이하 차이남 : 우리 모두 친구
                else if (ranking - firstRank <= k)
                {
                    goodFriends += queue.size() - 1;
                    break;
                }
                // 너무 성적 좋은 애는 친구 못하니까 빼버림
                queue.poll();
            }
        }
        br.close();

        System.out.println(goodFriends);
    }
}
