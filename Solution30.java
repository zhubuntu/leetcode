import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution30 {
    public Boolean validateString(String s, Map<String,Integer> ss, int len){
        Map<String,Integer> ss_new = new HashMap<String,Integer>(ss);
        for(int i=0;i<s.length();i+=len){
            String sub = s.substring(i, i+len);
            if(!ss_new.containsKey(sub))
                return false;
            ss_new.put(sub, ss_new.getOrDefault(sub, 0)-1);
            if(ss_new.get(sub) < 0)
                return false;
        }
        return true;
    }
    public Map<Character,Integer> getHash(){
        Map<Character,Integer> ss=new HashMap<Character,Integer>();
        int h=1;
        for(Character k='a';k<='z';++k){
            h=(k-'a')*7 +h;
            ss.put(k, h);
        }
        return ss;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result=new ArrayList<Integer>();
        if(words.length ==0)
            return result;
        Integer len=words[0].length()*words.length;
        if(s.length()<len)
            return result;
        Integer target_value = 0;
        Map<String,Integer> ss=new HashMap<String,Integer>();
        Map<Character,Integer> hash_code = getHash();
        for(int i=0;i<words.length;++i){
            ss.put(words[i], ss.getOrDefault(words[i], 0)+1);
            for(int j=0;j<words[i].length();++j){
                target_value+=hash_code.get(words[i].charAt(j));
            }
        }
        Integer s_value=0;
        for(int i=0;i<len;++i){
            s_value+=hash_code.get(s.charAt(i));
        }
        if(s_value.equals(target_value) && validateString(s.substring(0,len),ss,words[0].length()))
            result.add(0);
        len = len-1;
        for(int i=1;i<s.length()-len;++i){
            s_value-=hash_code.get(s.charAt(i-1));
            s_value+=hash_code.get(s.charAt(i+len));
            if(s_value.equals(target_value) && validateString(s.substring(i,i+len+1),ss,words[0].length()))
                result.add(i);
        }
        return result;
    }
    public static void main(String[] args){
        Solution30 s = new Solution30();
        String[] words={"bar","foo","the"};
        List<Integer> results=s.findSubstring("thefoobarman", words);
        System.out.println(results);
    }
}