package linkedlist.common;

/**
 * Created by LXF on 2016/7/25.
 */
public class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }
    public void add(int k) {
        Node t = this;
        while (t.next != null) {
            t = t.next;
        }
        Node node = new Node(k);
        t.next = node;
        node.next = null;
    }
}
