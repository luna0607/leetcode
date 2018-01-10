/**
 * Created by Ariana on 2018/1/10.
 */

import java.util.Stack;

/**
 * 你需要使用两个栈来实现队列的一些操作。
 * 队列应支持push(element)，pop() 和 top()，其中pop是弹出队列中的第一个(最前面的)元素。
 * pop和top方法都应该返回第一个元素的值。
 */
public class chapter2Queue {
    public static void main(String[] args) {
        chapter2Queue chapter2Queue=new chapter2Queue();
        chapter2Queue.push(1);
        chapter2Queue.push(2);
        chapter2Queue.push(3);
        chapter2Queue.push(4);
          chapter2Queue.pop();
          chapter2Queue.pop();
          chapter2Queue.pop();

    }
    Stack<Integer> stack1 =new Stack<>();
    Stack<Integer> stack2=new Stack<>();

    public void push(int element) {
        stack1.push(element);
    }

    public int pop() {
        stack2.clear();
        int size=stack1.size();
        for(int i=0;i<size;i++){
            stack2.push(stack1.pop());
        }
        int pop=stack2.pop();
        for (int i=0;i<size-1;i++){
            stack1.push(stack2.pop());
        }
        return pop;
    }

    public int top() {
        // write your code here
        return  (Integer) stack1.toArray()[0];
    }
}
