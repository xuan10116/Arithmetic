package Test.JZ;

import java.util.ArrayList;
import java.util.HashMap;

/*
输入一个链表，输出该链表中倒数第k个结点。
如果该链表长度小于k，请返回空。
* */
public class JZ14 {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        if (pHead == null) return null;
        ListNode temp = pHead;
        HashMap<Integer,ListNode> resultmap = new HashMap<>();
        int counter = 0;
        while(temp!=null){
            counter += 1;
            resultmap.put(Integer.valueOf(counter),temp);
            temp = temp.next;
        }
        return resultmap.get(counter - k + 1);
    }

    public ListNode FindKthToTail_2 (ListNode pHead, int k) {
        // write code here
        if (pHead == null) return null;
        ListNode temp = pHead;
        int counter = 0;
        ArrayList<ListNode> array = new ArrayList<>();
        while(temp != null){
            counter += 1;
            array.add(temp);
            temp = temp.next;
        }
        if (k>counter) return null;
        return array.get(counter-k+1);
    }
}
