package linkedlist.common;

/**
 * Created by LXF on 2016/7/26.
 */
public class DNode {
    public int value;
    public DNode next;
    public DNode last;

    public DNode(int data) {
        this.value = data;
    }

    /*为添加一个节点的方法*/
    public void add(int k) {
       DNode t = this;
        while (t.next != null) {
            t = t.next;
        }
        DNode node = new DNode(k);
        t.next = node;
        node.next = null;
        node.last = t;
    }
}
