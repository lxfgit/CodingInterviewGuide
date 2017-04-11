package linkedlist;

import linkedlist.common.DNode;
import linkedlist.common.Node;
import linkedlist.common.TNode;
import org.junit.Test;

/**
 * Created by LXF on 2016/7/27.
 */
public class ReserveList {
    /*不带头结点的反转*/
    public Node reverse(Node head) {
        Node pre,next;
        pre = next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /*带头结点的头插法反转*/
    public TNode reserve1(TNode head) {
        TNode cur = head.next;
        head.next = null;
        TNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = next;
        }
        return head;
    }

    /*反转双链表*/
    public DNode reserveD(DNode head) {
        DNode pre,next;
        pre = next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }


    @Test
    public void test() {

        Node head = new Node(2);
        head.add(3);

        ReserveList reserveList = new ReserveList();
        Node res = reserveList.reverse(head);
        System.out.println(res.next.value);
    }

    @Test
    public void testT() {
        TNode head = new TNode();
        head.add(3);
        head.add(4);
        head.add(5);

        ReserveList reserveList = new ReserveList();
        TNode res = reserveList.reserve1(head);
        while (res != null) {
            System.out.println(res.value);
            res = res.next;
        }
    }

    @Test
    public void testD() {
        DNode head = new DNode(3);
        head.add(4);
        head.add(42);
        head.add(56);

        ReserveList reserveList = new ReserveList();
        DNode res = reserveList.reserveD(head);

        while (res != null) {
            System.out.println(res.value);
            res = res.next;
        }

    }
}
