class Solution9 {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        String strx=String.valueOf(x);
        int len =strx.length();
        for(int i=0;i<len/2;++i){
            if(strx.charAt(i)!=strx.charAt(len-i-1))
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        Solution9 s = new Solution9();
        boolean result= s.isPalindrome(321823);
        System.out.print(result);
    }
}