package linkedlist.printCommonPart;

import linkedlist.common.Node;
import org.junit.Test;

/**
 * 打印单项列表的公共部分
 * Created by LXF on 2016/7/25.
 */
public class PrintCommonPart {
    public void printCommon(Node head1, Node head2) {
        System.out.println("Common Part:");
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.println(head1.value);
                head2 = head2.next;
                head1 = head1.next;
            }
        }
    }

    @Test
    public void test() {

        PrintCommonPart printCommonPart = new PrintCommonPart();

        Node h1 = new Node(4);
        h1.add(5);
        h1.add(56);
        h1.add(84);

        Node h2 = new Node(5);
        h1.add(84);

        printCommonPart.printCommon(h1, h2);
    }
}
