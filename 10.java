
class Solution {
    public boolean isMatch(String s, String p) {
        for(int i=0;i<p.length();){
            for(int j=0;j<s.length();){
                switch(p.charAt(i)){
                    case '.':
                        if(i<p.length()-1 && p.charAt(i)=='*'){

                        }
                        else{
                            ++i;
                            ++j;
                        }
                        break;
                    case '*':
                    for(int k=i;k<10;++i){

                    }
                    break;
                    default:
                    ++i;
                    ++j;
                    if(p.charAt(i)!=s.charAt(i))
                        return false;
                }
            }
        }
    }
    public static void main(String[] args){
        Solution10 s = new Solution10();
        boolean result= s.isMatch("sdfsdf",".*");
        System.out.print(result);
    }
}