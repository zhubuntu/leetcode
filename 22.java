import java.util.ArrayList;

class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<String>();
        String k_re="";
        for(int i=0;j<n;++n){
            
        }
         
    }

    public static void main(String[] args){
        Solution22 s = new Solution22();
        int n=2;
        ListNode1 result= s.generateParenthesis(2);
        while(result!=null){
            System.out.print(result.val);
            result=result.next;
        }
    }
}