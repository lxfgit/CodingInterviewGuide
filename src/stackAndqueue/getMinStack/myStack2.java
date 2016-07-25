package stackAndqueue.getMinStack;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by LXF on 2016/7/25.
 */
public class myStack2 {
    private Stack<Integer> stackData = new Stack();
    private Stack<Integer> stackMin = new Stack();

    public myStack2() {
    }

    public void push(int newNum) {
        if(this.stackMin.isEmpty()) {
            this.stackMin.push(Integer.valueOf(newNum));
        } else if(newNum < this.getMinValue()) {
            this.stackMin.push(Integer.valueOf(newNum));
        } else {
            int newMin = ((Integer)this.stackMin.peek()).intValue();
            this.stackMin.push(Integer.valueOf(newMin));
        }

        this.stackData.push(Integer.valueOf(newNum));
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
        myStack2 myStack2 = new myStack2();
        myStack2.push(23);
        myStack2.push(1);
        myStack2.push(3);
        System.out.println(myStack2.getMinValue());
    }
}
