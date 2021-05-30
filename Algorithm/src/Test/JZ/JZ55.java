package Test.JZ;
/*
* 给一个链表，若其中包含环，请找出该链表的环的入口结点，
* 否则，输出null。
* */
public class JZ55 {
    /*
    * 快慢指针法来判断是否有环
    * 找到环后，新建指针，该指针从头节点出发，同时快慢指针的焦点处，慢指针也出发，最后两者的相遇点就是入口。
    * */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        ListNode fast = pHead;
        ListNode slow = pHead;
//        如果无环那么就会正常结束外层while循环，接下来返回null
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            //当快慢指针相遇了，表示一定有环。
            if(fast == slow){
                //新建一个慢指针，一步步开始从头结点走
                ListNode slow2 = pHead;
                //新的慢指针与旧的慢指针相遇的点就是入口
                while(slow2 != slow){
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow2;
            }
        }
        return null;
    }
}
