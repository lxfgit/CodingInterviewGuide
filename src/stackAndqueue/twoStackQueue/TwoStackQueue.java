package stackAndqueue.twoStackQueue;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by LXF on 2016/7/25.
 */
public class TwoStackQueue {
    private Stack<Integer> stackPush = new Stack();
    private Stack<Integer> stackPop = new Stack();

    public TwoStackQueue() {
    }

    public void add(int newNum) {
        this.stackPush.push(newNum);
    }

    public int poll() {
        if (this.stackPush.isEmpty() && this.stackPop.isEmpty()) {
            throw new RuntimeException("THE QUEUE IS EMPTY");
        } else {
            if (this.stackPop.empty()) {
                while (!this.stackPush.empty()) {
                    this.stackPop.push(this.stackPush.pop());
                }
            }

            return ((Integer) this.stackPop.pop()).intValue();
        }
    }

    public int peek() {
        if (this.stackPush.isEmpty() && this.stackPop.isEmpty()) {
            throw new RuntimeException("THE QUEUE IS EMPTY");
        } else {
            if (this.stackPop.isEmpty()) {
                while (!this.stackPush.isEmpty()) {
                    this.stackPop.push(this.stackPush.pop());
                }
            }

            return ((Integer) this.stackPop.peek()).intValue();
        }
    }

    @Test
    public void test() {
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.add(1);
        twoStackQueue.add(6);
        twoStackQueue.add(8);
        System.out.println("验证peek()方法：" + twoStackQueue.peek());
        twoStackQueue.poll();
        System.out.println("验证poll()方法：" + twoStackQueue.poll());
        System.out.println(twoStackQueue.peek());
    }
}
