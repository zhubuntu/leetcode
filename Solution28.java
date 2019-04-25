class Solution28 {
    public int strStr(String haystack, String needle) {
        int end=haystack.length()-needle.length()+1;
        if(needle.equals(""))
            return 0;
        for(int i=0;i<end;++i){
            if(haystack.charAt(i) == needle.charAt(0)){
                int j=1;
                for(;j<needle.length();++j){
                    if(haystack.charAt(i+j) !=needle.charAt(j))
                        break;
                }
                if(j==needle.length())
                    return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Solution28 s = new Solution28();
        int results=s.strStr("mississippi","issip");
        System.out.println(results);
    }
}