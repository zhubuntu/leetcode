class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        String common="";
        if(strs.length==0)
            return common;
        for(int i=0;i<strs[0].length();++i){
            Character s=strs[0].charAt(i);
            for(int j=1;j<strs.length;++j){
                if(strs[j].length()<=i || strs[j].charAt(i)!=s)
                    return common;
                
            }
            common += s;
        }
        return common;
    }
    public static void main(String[] args){
        Solution14 s = new Solution14();
        String[] strs={"12345","1236"};
        String result= s.longestCommonPrefix(strs);
        System.out.print(result);
    }
}