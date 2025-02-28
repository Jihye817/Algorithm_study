import java.util.*;
import java.io.*;

public class B1991 {
    private static B1991 Instance = new B1991();
    private class Node
    {
        public String nodeName;
        public Node leftChild;
        public Node rightChild;

        public Node(String name, Node left, Node right) {
            nodeName = name;
            leftChild = left;
            rightChild = right;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        HashMap<String, Node> treeNodes = new HashMap<>();
        Node rootNode = null;
        for (int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());
            String self = st.nextToken();
            String leftChild = st.nextToken();
            String rightChild = st.nextToken();

            Node leftNode = getOrAdd(leftChild, treeNodes);
            Node rightNode = getOrAdd(rightChild, treeNodes);
            Node selfNode = getOrAdd(self, treeNodes);

            selfNode.leftChild = leftNode;
            selfNode.rightChild = rightNode;

            if (self.equals("A"))
            {
                rootNode = selfNode;
            }
        }
        br.close();

        StringBuilder preOrderSb = printPreOrder(rootNode, new StringBuilder());
        System.out.println(preOrderSb.toString());
        StringBuilder inOrderSb = printInOrder(rootNode, new StringBuilder());
        System.out.println(inOrderSb.toString());
        StringBuilder postOrderSb = printPostOrder(rootNode, new StringBuilder());
        System.out.println(postOrderSb.toString());
    }

    private static StringBuilder printPreOrder(Node curNode, StringBuilder sb)
    {
        if (curNode == null)
        {
            return sb;
        }
        sb.append(curNode.nodeName);
        printPreOrder(curNode.leftChild, sb);
        printPreOrder(curNode.rightChild, sb);
        return sb;
    }


    private static StringBuilder printInOrder(Node curNode, StringBuilder sb)
    {
        if (curNode == null)
        {
            return sb;
        }
        printInOrder(curNode.leftChild, sb);
        sb.append(curNode.nodeName);
        printInOrder(curNode.rightChild, sb);
        return sb;
    }

    private static StringBuilder printPostOrder(Node curNode, StringBuilder sb)
    {
        if (curNode == null)
        {
            return sb;
        }
        printPostOrder(curNode.leftChild, sb);
        printPostOrder(curNode.rightChild, sb);
        sb.append(curNode.nodeName);
        return sb;
    }

    private static Node getOrAdd(String name, HashMap<String, Node> map)
    {
        if (name.equals("."))
        {
            return null;
        }
        Node result = map.get(name);
        if (result == null)
        {
            result = Instance.new Node(name, null, null);
            map.put(name, result);
        }
        return result;
    }
}
