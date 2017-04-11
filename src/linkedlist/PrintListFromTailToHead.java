package linkedlist;

/**
 * Created by LXF on 2017/3/28.
 */

import linkedlist.common.ListNode;

import java.util.ArrayList;
import java.util.Iterator;


public class PrintListFromTailToHead {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode pre, next;
        pre = next = null;
        while (listNode != null) {
            next = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = next;
        }
        while (pre != null) {
            arrayList.add(pre.val);
            pre = pre.next;
        }
        return arrayList;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        Iterator iterator = printListFromTailToHead(n1).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
