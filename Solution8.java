class Solution8 {
    public int myAtoi(String str) {
        str= str.trim();
        Boolean isAC=true;
        if(str.length()>1 && str.charAt(0) == '-'){
            isAC=false;
        }
        if(str.length()>1 && str.charAt(0)=='+' ||  str.charAt(0)=='-'){
            str=str.substring(1);
        }
        if(str.length()<1 || str.charAt(0)<'0' || str.charAt(0)>'9'){
            return 0;
        }
        int total_num =0;
        int pre_num=0;
        int INT_MIN=Integer.MIN_VALUE;
        int INT_MAX=Integer.MAX_VALUE;
        for(int i=0;i<str.length();++i){
            if(str.charAt(i)<'0' || str.charAt(i)>'9'){
                 return total_num;
            }
           pre_num=total_num;
            total_num = total_num*10 + str.charAt(i)-'0';
            if(total_num<pre_num){
                
                if(isAC)
                    return INT_MAX;
                else
                    return INT_MIN;
            }
        }
        if(!isAC)
            return 0-total_num;
        return total_num;
    }
    public static void main(String[] args){
        Solution8 s = new Solution8();
        int result= s.myAtoi("4193 with words");
        System.out.print(result);
    }
}