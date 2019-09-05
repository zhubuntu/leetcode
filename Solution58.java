class Solution58 {
    public int lengthOfLastWord(String s) {
        int len=0;
        int end=s.length()-1;
        while(end>=0 && s.charAt(end)==' '){
            --end;
        }
        for(int i=end;i>=0;--i){
            if(s.charAt(i)==' '){
                break;
            }
            ++len;
        }
        return len;
    }
    public static void main(String[] args) {
        int result = new Solution58().lengthOfLastWord("Hello Word");
    }
}