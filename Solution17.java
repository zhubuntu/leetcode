import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution17 {
    public List<String> letterCombinations(String digits) {
        
        Map<Character,String> map_re= new HashMap<Character,String>();
        map_re.put('2',"abc");
        map_re.put('3',"def");
        map_re.put('4', "ghi");
        map_re.put('5', "jkl");
        map_re.put('6', "mno");
        map_re.put('7', "pqrs");
        map_re.put('8', "tuv");
        map_re.put('9', "wxyz");
        List<String> result=new ArrayList<String>();
        result.add("");
        for(int i=0;i<digits.length();++i){
            String chars=map_re.get(digits.charAt(i));
            //result.add(chars);
            int rs=result.size();
            for(int j=0;j<rs;++j){
                String this_re=result.get(j);
                for(int k=1;k<chars.length();++k){
                    result.add(this_re+chars.charAt(k));
                }
                result.set(j, this_re+=chars.charAt(0));
            }
        }
        if(result.size()==1)
            return new ArrayList<String>();
        return result;

    }
    public static void main(String[] args){
        Solution17 s = new Solution17();
        List<String> result= s.letterCombinations("");
        //应该是可以用迭代器来做，速度会更快一些的
        System.out.print(result);
    }
}