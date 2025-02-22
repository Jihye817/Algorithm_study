import java.util.*;
import java.io.*;

public class StackParenthesis {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int n = str.length();

        if (n % 2 == 1)
        {
            System.out.println("No");
            return;
        }

        Stack<Boolean> stack = new Stack<Boolean>();
        for (int i = 0; i < n; i++)
        {
            char elm = str.charAt(i);
            if (elm == '(')
            {
                stack.push(true);
            }
            else if (elm == ')')
            {
                if (stack.isEmpty())
                {
                    System.out.println("No");
                    return;
                }
                stack.pop();
            }
        }

        System.out.println(stack.isEmpty() ? "Yes" : "No");
        return;
    }
}