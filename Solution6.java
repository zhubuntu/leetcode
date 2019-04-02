class Solution6 {
    public String convert(String s, int numRows) {
        String result="";
        int num = 2*numRows -2;
        String[] rr=new String[numRows];
        for(int i=0;i<rr.length;++i){
            rr[i]="";
        } 
        for(int i=0;i<s.length();++i){
            int left = i%num;
            if(left<numRows)
                rr[left] += s.charAt(i);
            else
                rr[num-left]+=s.charAt(i);
        }
        for(int i=0;i<rr.length;++i){
            result+=rr[i];
        } 
        return result;
    }
    public static void main(String[] args){
        Solution6 s = new Solution6();
        String result= s.convert("LEETCODEISHIRING",4);
        System.out.print(result);
    }
}