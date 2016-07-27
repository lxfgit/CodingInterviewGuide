package linkedlist.removeByRatio;

import linkedlist.common.Node;
import org.junit.Test;

/**
 * 根据链表长度n，删除链表a/b处的结点，向上取整。
 * Created by LXF on 2016/7/27.
 */
public class RemoveByRatio {
    public Node Remove(Node head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }
        int n = 0;
        Node cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        n = (int) Math.ceil((double) (a * n) / (double) b);
        if (n == 1) {
            head = head.next;
        }
        if (n > 1) {
            cur = head;
            while (--n != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    @Test
    public void test() {
        Node head = new Node(2);
        head.add(3);
        head.add(5);
        head.add(8);
        head.add(6);
        RemoveByRatio removeByrRatio = new RemoveByRatio();
        Node res = removeByrRatio.Remove(head, 3, 4);
        System.out.println(res.next.next.next.value);
    }
}
