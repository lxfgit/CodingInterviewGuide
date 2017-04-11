package stackAndqueue;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by LXF on 2016/7/25.
 */
public class ReverseStackByRecursive {
    public ReverseStackByRecursive() {
    }

    private static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = ((Integer)stack.pop()).intValue();
        if(stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(Integer.valueOf(result));
            return last;
        }
    }

    private static void reverse(Stack<Integer> stack) {
        if(!stack.isEmpty()) {
            int i = getAndRemoveLastElement(stack);
            reverse(stack);
            stack.push(Integer.valueOf(i));
        }
    }

    @Test
    public void test() {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(4);
        stack.push(7);
        reverse(stack);

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}
