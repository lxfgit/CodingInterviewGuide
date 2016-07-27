package linkedlist.common;

/**
 * Created by LXF on 2016/7/27.
 */
public class TNode {
    public int value;
    public TNode next;

    public TNode() {
        this.next = null;
    }

    /*为添加一个节点的方法*/
    public void add(int k) {
        TNode t = this;
        while (t.next != null) {
            t = t.next;
        }
        TNode node = new TNode();
        node.value = k;
        t.next = node;
        node.next = null;
    }
}
