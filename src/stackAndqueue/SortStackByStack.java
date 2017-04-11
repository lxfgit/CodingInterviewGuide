package stackAndqueue;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by LXF on 2016/7/25.
 */
public class SortStackByStack {
    public SortStackByStack() {
    }

    public static void SortSactkByStackC(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<Integer>();

        while(!stack.isEmpty()) {
            int cur = stack.pop();

            while(!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }

            help.push(cur);
        }

        while(!help.isEmpty()) {
            stack.push(help.pop());
        }

    }

    @Test
    public void test() {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(6);
        stack.push(7);
        stack.push(53);
        SortStackByStack sortSackByStack = new SortStackByStack();
        SortSactkByStackC(stack);

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}
