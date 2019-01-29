import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution30 {
    public Boolean validateString(String s, Set<String> ss, int len){
        System.out.println(s);
        for(int i=0;i<s.length();i+=len){
            if(!ss.contains(s.substring(i, i+len)))
                return false;
        }
        return true;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result=new ArrayList<Integer>();
        Integer len=words[0].length()*words.length;
        if(s.length()<len)
            return result;
        Integer target_value = 0;
        Set<String> ss=new HashSet<String>();
        
        for(int i=0;i<words.length;++i){
            ss.add(words[i]);
            for(int j=0;j<words[i].length();++j){
                target_value+=words[i].charAt(j);
            }
        }
        System.out.println(target_value);
        Integer s_value=0;
        for(int i=0;i<len;++i){
            s_value+=s.charAt(i);
        }
        System.out.println(s_value);
        if(s_value.equals(target_value) && validateString(s.substring(0,len),ss,words[0].length()))
            result.add(0);
        len = len-1;
        for(int i=1;i<s.length()-len;++i){
            s_value-=s.charAt(i-1);
            s_value+=s.charAt(i+len);
            if(s_value.equals(target_value) && validateString(s.substring(i,i+len+1),ss,words[0].length()))
                result.add(i);
        }
        return result;
    }
    public static void main(String[] args){
        Solution30 s = new Solution30();
        String[] words={"foo","bar"};
        List<Integer> results=s.findSubstring("barfoothefoobarman", words);
        System.out.println(results);
    }
}