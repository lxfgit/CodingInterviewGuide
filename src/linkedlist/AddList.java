package linkedlist;

import linkedlist.common.Node;

import java.util.Stack;

/**
 * Created by LXF on 2017/7/7.
 */
public class AddList {
    public Node AddList1(Node node1, Node node2) {
        Stack<Integer> nodeStack1 = new Stack<Integer>();
        Stack<Integer> nodeStack2 = new Stack<Integer>();

        while (node1 != null) {
            nodeStack1.push(node1.value);
            node1 = node1.next;
        }
        while (node2 != null) {
            nodeStack2.push(node2.value);
            node2 = node2.next;
        }
        int ca = 0;
        int n1=  0;
        int n2=  0;
        int n= 0;
        Node node = null;
        Node pre = null;
        while (!nodeStack1.isEmpty() || !nodeStack2.isEmpty()) {
            n1 = nodeStack1.isEmpty() ? 0 : nodeStack1.pop();
            n2 = nodeStack2.isEmpty() ? 0 : nodeStack2.pop();
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n % 10);
            node.next = node;
            ca = n/10;
        }
        if (ca == 1) {
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node;
    }

}
