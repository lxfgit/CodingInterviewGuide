package linkedlist;

import linkedlist.common.Node;
import org.junit.Test;

/**
 * 删除单链表的倒数第K个节点
 * Created by LXF on 2016/7/25.
 */
public class RemoveLastKthNode {
    public static Node Remove(Node head, int k) {
        Node cur = head;

        if (cur == null) {
            throw new RuntimeException("YOUR LIST IS EMPTY");
        }
        if (k < 1) {
            throw new RuntimeException("K IS ILLEGAL");
        }
        while (cur != null) {
            cur = cur.next;
            k--;
        }
        if (k == 0) {
            head = head.next;
        }
        if (k < 0) {
            cur = head;
            while (++k != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }


    @Test
    public void test() {
        Node h = new Node(2);
        h.add(5);
        h.add(6);
        h.add(8);
        RemoveLastKthNode removeLastKthNode = new RemoveLastKthNode();
        Node res = removeLastKthNode.Remove(h, 3);
        System.out.println(res.next.value);

    }
}
