

protected class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode back=head;
        ListNode lastn=null;
        int this_k=0;
        while(head.next){
            this_k=this_k+1;
            if(this_k==n)
                lastn = head;
            if(this_k >n){
                lastn=lastn.next;
            }
            head=head.next;

        }
        lastn.next=lastn.next.next;
        return head;
    }
    public static void main(String[] args){
        Solution19 s = new Solution19();
        ListNode input=new ListNode(0);
        ListNode result= s.removeNthFromEnd(input,0);
        //应该是可以用迭代器来做，速度会更快一些的
        System.out.print(result);
    }
}