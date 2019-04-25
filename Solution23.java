
class Solution23 {
    protected ListNode combine2list(ListNode l1,ListNode l2){
        ListNode re,back_re;;
        if(l2!=null && l2.val<l1.val){
            re=l2;
            l2=l2.next;
        } 
        else{
            re=l1;
            l1=l1.next;
        }
        back_re=re;  
        while(l1!=null || l2!=null){
            if(l1 ==null){
                re.next=l2;
                return back_re;
            }
            else if(l2==null){
                re.next=l1;
                return back_re;
            }
            else if(l2.val<l1.val){
                re.next=l2;
                re=re.next;
                l2=l2.next;
            }
            else{
                re.next=l1;
                re=re.next;
                l1=l1.next;
            }    
        }
        return back_re;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length ==0)
            return null;
        if(lists.length ==1)
            return lists[0];
        if(lists.length == 2)
            return this.combine2list(lists[0], lists[1]);
        int mid = lists.length/2;
        ListNode[] l1 = new ListNode[mid];
        for(int i=0;i<mid;++i)
            l1[i] = lists[i];
        ListNode[] l2 = new ListNode[lists.length-mid];
        for(int i=mid; i<lists.length; ++i)
            l2[i-mid] = lists[i];
        return combine2list(mergeKLists(l1),mergeKLists(l2));
    }
    public static void main(String[] args){
        Solution23 s = new Solution23();
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(8);
        ListNode l2=new ListNode(3);
        ListNode l3= new ListNode(4);
        ListNode[] lists={l1,l2,l3};
        ListNode result = s.mergeKLists(lists);
        while(result !=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
}