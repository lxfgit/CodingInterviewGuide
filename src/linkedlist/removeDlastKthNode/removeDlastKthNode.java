package linkedlist.removeDlastKthNode;

import linkedlist.common.DNode;
import org.junit.Test;

/**
 * Created by LXF on 2016/7/26.
 */
public class RemoveDlastKthNode {
    public DNode remove(DNode head, int k) {
        if (head == null) {
            throw new RuntimeException("The list is empty");
        }
        if (k < 1) {
            throw new RuntimeException("The k is illegal");
        }
        DNode cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }

        if (k == 0) {
            head = head.next;
            head.last = null;
        }

        if (k < 0) {
            cur = head;
            while (++k != 0) {
                cur = cur.next;
            }
            DNode curNext = cur.next.next;
            cur.next = curNext;
            if (curNext != null) {
                curNext.last = cur;
            }
        }
        return head;
    }

    @Test
    public void test() {
        DNode head = new DNode(3);
        head.add(12);
        head.add(9);
        head.add(2);
        head.add(6);

        RemoveDlastKthNode removeDlastKthNode = new RemoveDlastKthNode();
        DNode res = removeDlastKthNode.remove(head, 5);
        System.out.println(res.value);
    }
}
