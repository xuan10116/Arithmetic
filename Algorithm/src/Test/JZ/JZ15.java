package Test.JZ;
/*
* 反转链表
* */
public class JZ15 {
    //方法一：尾插法，首先找到链表尾部，再从头结点循环往尾节点插入
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        ListNode tail = temp;
        temp = head;
        while(temp!=tail){
            head = head.next;
            temp.next = tail.next;
            tail.next = temp;
            temp = head;
        }
        return tail;
    }

    //方法二，头插法，一次遍历就完成逆序,高效。
    public ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode H = new ListNode(0);
        ListNode temp = head;
        while(head != null){
            temp = head;
            head = head.next;
            temp.next = H.next;
            H.next = temp;
        }
        return H.next;
    }
}
