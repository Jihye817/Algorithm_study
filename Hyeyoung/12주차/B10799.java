import java.util.*;
import java.io.*;

public class B10799
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();
        
        int n = str.length();
        Stack<Boolean> stack = new Stack<Boolean>();
        int result = 0;
        for (int i = 0; i < n; i++)
        {
            char elm = str.charAt(i);
            char nextElm = i == n-1 ? ' ' : str.charAt(i+1);
            if (elm == '(' && nextElm == ')')
            {
                //레이저
                result += stack.size();
                i++;
            }
            // 막대 하나 추가
            else if (elm == '(')
            {
                stack.push(true);
            }
            else if (elm == ')')
            {
                result++;
                stack.pop();
            }
        }

        System.out.println(result);
        return;
    }
}