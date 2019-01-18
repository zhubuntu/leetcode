public class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1(int x) { val = x; }
}

class Solution21 {
    public ListNode1 mergeTwoLists(ListNode1 l1, ListNode1 l2) {
        ListNode1 l=new ListNode1(0);
        ListNode1 first=l;
        while(l1 !=null || l2 !=null){
            if(l1 ==null){
                l.next=l2;
                l1=null;
            }
            else if(l2 ==null){
                l.next=l1;
                l2=null;
            }
            else{
                if(l1.val <l2.val){
                    l.next=l1;
                    l=l.next;
                    l1=l1.next;
                }
                else{
                    l.next=l2;
                    l=l.next;
                    l2=l2.next;

                }
            }
        }
        return first.next;
    }
    public static void main(String[] args){
        Solution21 s = new Solution21();
        ListNode1 l1=new ListNode1(1);
        ListNode1 l2=new ListNode1(2);
        System.out.println(l1.val);
        ListNode1 result= s.mergeTwoLists(l1,l2);
        while(result!=null){
            System.out.print(result.val);
            result=result.next;
        }
        
    }
}