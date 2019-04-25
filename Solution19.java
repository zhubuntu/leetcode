
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode lastn=null;
        ListNode back = head;
        int this_k=0;
        while(head.next != null){
            this_k=this_k+1;
            if(this_k==n)
                lastn = back;
            if(this_k >n){
                lastn=lastn.next;
            }
            head=head.next;
        }
        if(lastn == null){
            back = back.next;
        }
        else{
            lastn.next=lastn.next.next;
        }
        return back;
    }
    public static void main(String[] args){
        Solution19 s = new Solution19();
        ListNode input=new ListNode(0);
        input.next = new ListNode(1);
        input.next.next = new ListNode(2);
        input.next.next.next = new ListNode(4);
        input.next.next.next.next = new ListNode(5);
        ListNode result= s.removeNthFromEnd(input,2);
        //应该是可以用迭代器来做，速度会更快一些的
        System.out.print(result.next.next.next.val);
    }
}