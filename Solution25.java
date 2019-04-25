class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode l1=null;
        while(head !=null){
            ListNode l_tmp=head;
            for(int i=0;i<k;++i){
                if(l_tmp == null)
                    return l1==null? head:l1;
                l_tmp = l_tmp.next;
            }
            reverseList(head, l_tmp);
            head=head.next;
            l1= l1==null? head:l1;
        }
        return l1;
    }
    public void reverseList(ListNode head, ListNode end){
        ListNode back_head=head;
        ListNode pre=null;
        while(pre!=end){
            ListNode hn=head.next;
            head.next=pre;
            pre=hn;
            head=hn.next;
        }
    }
    public static void main(String[] args){
        Solution25 s = new Solution25();
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(8);
        l1.next.next=new ListNode(6);
        ListNode result = s.reverseKGroup(l1, 3);
        while(result !=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
}