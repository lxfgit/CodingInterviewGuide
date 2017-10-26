package linkedlist;

import linkedlist.common.ListNode;

/**
 * Created by LXF on 2017/8/15.
 */
public class DeleteDuplicationNode {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode curNode = pHead.next;
        ListNode temp = new ListNode(0);
        temp.next = pHead;
        ListNode pre = temp;
        ListNode last = pHead;
        while (curNode != null) {
            if (curNode.val == last.val) {
                last.next = curNode;
                last = curNode;
                curNode = curNode.next;
            } else {
                curNode = curNode.next;
            }
        }
        return pHead;
    }
}
