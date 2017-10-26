package linkedlist.common;

/**
 * 链表的结构
 * Created by LXF on 2016/7/25.
 */
public class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }

    /*为添加一个节点的方法*/
    public void add(int k) {
        Node t = this;
        while (t.next != null) {
            t = t.next;
        }
        Node node = new Node(k);
        t.next = node;
        node.next = null;
    }

    public static void print(Node head) {
        Node node = head;
        if (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
}
