import java.util.ArrayList;
import java.util.List;

class Solution22 {
    protected void gen_str(String begin,int n, int s_match, List<String> result,int max_match){
        //System.out.println(begin);
        if(s_match<0 || s_match>max_match)
            return;
        if(n==0){
            if(s_match==0)
                result.add(begin);
            return;   
        }
        n-=1;
        gen_str(begin+'(', n, s_match+1, result, max_match);
        gen_str(begin+')', n, s_match-1, result, max_match);

    }
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<String>();
        String begin="";
        int s_match=0;
        int max_match=n;
        n=n*2;
        gen_str(begin+='(', n-1, 1, result, max_match);
        return result;
    }

    public static void main(String[] args){
        Solution22 s = new Solution22();
        List<String> result= s.generateParenthesis(3);
        for(int i=0;i<result.size();++i){
            System.out.println(result.get(i));
        }
    }
}