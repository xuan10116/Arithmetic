package Test.JZ;

import java.util.Stack;
/*
* 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
* */
public class JZ5 {
    //两个栈实现一个队列，我们在存储的时候（push）只管向其中一个栈存入数据，
    // 假设为stack1，pop时再借助另一个栈
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            if (stack1.isEmpty()){
                return 0;
            }else{
                while(!stack1.isEmpty()){
                    stack2.add(stack1.pop());
                }
                return stack2.pop();
            }
        }
    }
}
