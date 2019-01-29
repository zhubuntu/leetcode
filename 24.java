class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode l1=head;
        if(head.next!=null){
            l1=head.next;
            head.next=l1.next;
            l1.next=head;
        }

        ListNode pre=l1.next;
        ListNode next;
        head = head.next;
        while(head !=null){
            if(head.next !=null){
               ListNode hn=head.next;
               pre.next=hn;
               head.next=hn.next;
               pre=head;
               hn.next=head; 
            }
            head=head.next;
        }
        return l1;
    }
    public static void main(String[] args){
        Solution24 s = new Solution24();
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(8);
        l1.next.next=new ListNode(6);
        ListNode result = s.swapPairs(l1);
        while(result !=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
}