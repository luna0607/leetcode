package google;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;

/**
 * Created by Ariana on 2018/3/5.
 */
public class MinStack {
    ArrayList<Integer> stack=new ArrayList<>();
    public MinStack() {
        // do intialization if necessary
    }
    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack.add(number);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int popNum=stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return popNum;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        int min=Integer.MAX_VALUE;
        for(int i:stack){
            if(i<min){
                min=i;
            }
        }
        return min;
    }
}
