package stackAndqueue.getMinStack;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by LXF on 2016/7/25.
 */
public class myStack1 {
    private Stack<Integer> stackData = new Stack();
    private Stack<Integer> stackMin = new Stack();

    public myStack1() {
    }

    public void push(int newNum) {
        if(this.stackMin.isEmpty()) {
            this.stackMin.push(Integer.valueOf(newNum));
        } else if(newNum < this.getMinValue()) {
            this.stackMin.push(Integer.valueOf(newNum));
        }

        this.stackData.push(Integer.valueOf(newNum));
    }

    public int pop() {
        if(this.stackMin.isEmpty()) {
            throw new RuntimeException("YOUR STACK IS EMPTY");
        } else {
            int value = ((Integer)this.stackData.pop()).intValue();
            if(value == this.getMinValue()) {
                this.stackMin.pop();
            }

            return value;
        }
    }

    public int getMinValue() {
        if(this.stackMin.isEmpty()) {
            throw new RuntimeException("YOUR STACK IS EMPTY");
        } else {
            return ((Integer)this.stackMin.peek()).intValue();
        }
    }

    @Test
    public void test() {
        myStack1 myStack1 = new myStack1();
        myStack1.push(12);
        myStack1.push(2);
        myStack1.push(42);
        myStack1.push(52);
        myStack1.push(62);
        int v = myStack1.getMinValue();
        System.out.println(v);
    }

}
