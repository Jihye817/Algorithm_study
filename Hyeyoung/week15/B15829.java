import java.util.*;
import java.io.*;

public class B15829
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        br.close();

        int r = 31;
        int M = 1234567891;
        long result = 0;
        int ri = 1;
        
        for (int i = 0; i < L; i++)
        {
            result += (str.charAt(i) - 'a' + 1) * ri;
            ri *= r;
        }
        System.out.println(result % M);
    }
}
