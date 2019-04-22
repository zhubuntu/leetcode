
class Solution10 {
    public boolean isMatch(String s, String p) {
        int i=0,j=0;
        for(;i<p.length();){
            for(;j<s.length();){
                if(i>=p.length())
                    break;
                switch(p.charAt(i)){
                    case '.':
                        if(p.length()>i+1 && p.charAt(i+1)=='*'){
                            i=i+2;
                            for(int k=j;k<s.length();++k){
                                if(isMatch(s.substring(k), p.substring(i)))
                                    return true;
                            }
                            return false;
                        }
                        else{
                            ++i;
                            ++j;
                        }
                        break;
                    case '*':
                        return false;
                    default:
                    if(p.length()>i+1 && p.charAt(i+1)=='*'){
                        i=i+2;
                        if(isMatch(s.substring(j), p.substring(i)))
                            return true;
                        for(int k=j;k<s.length();++k){
                            if(s.charAt(k) == p.charAt(i-2)&&isMatch(s.substring(k+1), p.substring(i)))
                                return true;
                        }
                        return false;
                    }
                    else{
                        if(p.charAt(i)!=s.charAt(i))
                            return false;
                        ++i;
                        ++j;
                    }
                        
                }
            }
        }
        if(i <p.length()-1 || j<s.length()-1)
            return false;
        return true;
    }
    public static void main(String[] args){
        Solution10 s1= new Solution10();
    }
}