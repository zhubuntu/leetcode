
  
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
 
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l=new ListNode(0);
        ListNode ll =l;
        int jin=0;
        while(l1 != null || l2 != null){
            ll.next = new ListNode(jin);
            jin = 0;
            ll = ll.next;
            if(l1 != null){
                ll.val += l1.val;
                l1 = l1.next;
            }  
            if(l2 != null){
                ll.val += l2.val;
                l2=l2.next;
            }
            jin = ll.val/10;
            ll.val=ll.val%10;
        }
        if(jin>0)
            ll.next = new ListNode(jin);
        if(l.next == null)
            return l;
        return l.next;
    }
    public static void main(String[] args){
        ListNode l1=new ListNode(2);
        //l1.next = new ListNode(4);
        //l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        Solution2 s1=new Solution2();
        ListNode l3= s1.addTwoNumbers(l1, l2);
        while(l3 !=null){
            System.out.print(l3.val);
            l3=l3.next;
        }
    }
}