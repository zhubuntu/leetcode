import java.util.*;
class Solution32 {
    private int findMaxLen(char[] chars,int begin, int end ,int direction, char end_char){
        int curr_match =0;
        int max_len =0 ;
        for(int i=begin; i!=end+direction; i+=direction){
            if(chars[i] == end_char){
                curr_match -= direction;
                continue;
            }
            curr_match += direction;   
            int match = curr_match-direction;
            for(int j=i+direction; j!=end+direction; j+=direction){
                char in = chars[j];
                if(in == end_char){
                    if(curr_match == match){
                        i=j;
                        break;
                    }
                    curr_match -= direction;
                    if(curr_match == match)
                        max_len = Math.max(max_len, Math.abs(j-i+direction));
                }
                else
                    curr_match += direction;
                if(j== end)
                    return max_len;
            }
        }
        return max_len;

    }
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int max_len = Math.max(findMaxLen(chars, 0, chars.length-1, 1, ')'),
                                findMaxLen(chars, chars.length-1, 0, -1, '('));
        return max_len;
    }
    public static void main(String[] args){
        Solution32 s = new Solution32();
        
        int result =s.longestValidParentheses("(()");
        System.out.println(result);
    }
}