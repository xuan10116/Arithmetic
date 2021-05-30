package Test.JZ;

import org.junit.Test;

import java.util.Stack;

/*
* 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
* 假设压入栈的所有数字均不相等。
* 例如序列1,2,3,4,5是某栈的压入顺序，
* 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
* 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
* */
public class JZ21 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> valueStack = new Stack<>();
        int pushptr = 0;
        int popptr = 0;
        while(pushptr < pushA.length){
            if(pushA[pushptr]==popA[popptr]){
                pushptr += 1;
                popptr += 1;
                while(!valueStack.isEmpty() && popA[popptr]==valueStack.peek()){
                    valueStack.pop();
                    popptr += 1;
                }
            }else{
                valueStack.push(pushA[pushptr]);
                pushptr += 1;
            }
        }
        return valueStack.isEmpty();
    }

    @Test
    public void test1(){
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,3,5,1,2};

        System.out.println(IsPopOrder(pushA, popA));
    }
}
