class Solution32 {
    public int longestValidParentheses(String s) {
        Map<Integer,Integer> begin_map = new HashMap<Integer,Integer>();
        Map<Integer,Integer> end_map = new HashMap<Integer,Integer>();
        int max_len=0;
        int begin=0;
        int curr_match=0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i) =='(')
                curr_match +=1;
            else
                curr_match -=1;
            if(curr_match<0){
                for(int j=begin;j<=i;++j){
                    if(s.charAt(j) =='(')
                        curr_match -=1;
                    else
                        curr_match +=1;
                    if(curr_match == 0)
                        begin=j+1;
                        break;
                }
            }
            else if(curr_match ==0){
                if(i-begin>max_len)
                    max_len=i-begin+1;
            }
        }
        return max_len;   
    }
    public static void main(String[] args){
        Solution32 s = new Solution32();
        
        int result =s.longestValidParentheses("(()");
        System.out.println(result);
    }
}