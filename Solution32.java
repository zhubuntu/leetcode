import java.util.*;
class Solution32 {
    public int longestValidParentheses(String s) {
        Map<Integer,Integer> begin_map = new HashMap<Integer,Integer>();
        Map<Integer,Integer> end_map = new HashMap<Integer,Integer>();
        int max_len=0;
        for(int i=0;i<s.length();++i){
            int curr_match=0;
            if(s.charAt(i) =='(')
                curr_match +=1;
            else if(s.charAt(i) == ')')
                curr_match -= 1;
            begin_map.put(i, curr_match);
        }
        for(int i=0;i<s.length()-max_len;++i){
            if(s.charAt(')'))
                continue;
            Integer begin = begin_map.get(i);
            Integer end = 0;
            
        }
    }
    public static void main(String[] args){
        Solution32 s = new Solution32();
        
        int result =s.longestValidParentheses("(()");
        System.out.println(result);
    }
}