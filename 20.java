import java.util.Queue;
import java.util.Stack;
class Solution20 {
    public boolean isValid(String s) {
        String k="";
        Stack<Character> ks=new Stack<Character>();
        for(int i=0;i<s.length();++i){
            switch(s.charAt(i)){
                case '(':
                    ks.add(')');
                    break;
                case ')':
                    if(ks.size()<1 || ks.pop()!=')')
                        return false;
                    break;
                case '[':
                ks.add('[');
                break;
                case ']':
                if(ks.size()<1 || ks.pop()!=']')
                        return false;
                    break;
                case '{':
                ks.add('}');
                break;
                case '}':
                if(ks.size()<1 || ks.pop()!='}')
                        return false;
                    break;

            }
        }
        if(ks.size()>0)
            return false;
        return true;
    }
    public static void main(String[] args){
        Solution20 s = new Solution20();
        boolean result= s.isValid("())");
        //应该是可以用迭代器来做，速度会更快一些的
        System.out.print(result);
    }
}