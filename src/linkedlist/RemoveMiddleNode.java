package linkedlist;

import linkedlist.common.DNode;
import org.junit.Test;

/**
 * 删除链表的中间结点，
 * Created by LXF on 2016/7/26.
 */
public class RemoveMiddleNode {
    public DNode removeMiddle(DNode head) {
//        链表空或者只有一个结点时返回头结点
        if (head == null || head.next == null) {
            return head;
        }
//        链表只有两个结点时删除第一个
        if (head.next.next == null) {
            return head.next;
        }

        /*利用乘二加一的方式1,3起*/
        DNode pre = head;
        DNode cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    @Test
    public void test() {
        DNode head = new DNode(5);
        head.add(3);
        head.add(234);
        head.add(56);
//        head.add(53);

        RemoveMiddleNode removeMiddleNode = new RemoveMiddleNode();
        DNode res = removeMiddleNode.removeMiddle(head);
        System.out.println(res.next.value);

    }
}
