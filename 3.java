import java.util.HashMap;
import java.util.Map;
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> smap = new HashMap<Character, Integer>();
        int begin =-1;
        int max_len=0;
        int this_len=-1;
        for(int i=0;i<s.length();++i){
            Character sings=s.charAt(i);
            if(smap.getOrDefault(sings, -2)>begin){
                max_len = begin== -1?i:max_len;
                this_len = i-1-begin;
                begin = smap.get(sings);
                max_len = max_len>this_len?max_len:this_len;
            }
            smap.put(sings,i);
        }
        this_len=s.length()-1-begin;
        max_len = max_len>this_len?max_len:this_len;
        return max_len;
    }
    public static void main(String[] args){
        Solution3 s = new Solution3();
        int l= s.lengthOfLongestSubstring("ddiabzdds");
        System.out.print(l);
    }
}