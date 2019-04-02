class Solution5 {
    protected Boolean valPalindrome(String s){
        int len=s.length();
        for(int i=0;i<len/2;++i){
            if(s.charAt(i)!=s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int max_len=0;
        String max_str="";
        for(int i=0; i< s.length(); ++i){
            for(int j= s.length()-1;j>i + max_len-1;--j){
                if(s.charAt(i)==s.charAt(j) && valPalindrome(s.substring(i, j+1))){
                    max_len = j - i + 1;
                    max_str = s.substring(i, j+1);
                }
            }
        }
        return max_str;
    }
    public static void main(String[] args){
        Solution5 s = new Solution5();
        String result= s.longestPalindrome("ddjjjkddssdddsdfdsf");
        System.out.print(result);
    }
}