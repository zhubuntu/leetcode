import Math;
class Solution29 {
    public int divide(int dividend, int divisor) {
        if(dividend ==Integer.MIN_VALUE && divisor ==-1)
            return Integer.MAX_VALUE;
        Boolean right=true;
        if(dividend<0 && divisor>0)
            right=false;
        if(dividend>0 && divisor<0)
            right=false;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if(dividend<divisor)
            return 0;
        int div=divisor;
        int result=1;
        int pre=0;
        int pre_div=0;
        while(div<dividend){
            System.out.println(div);
            pre=result;
            pre_div=div;
            result += pre;
            div+=div;
            if(div<0){
                break;
            }
        }
        int return_re;
        if(div==dividend)
            return_re= result;
        else
            return_re = divide(dividend-pre_div, divisor);
        if(right==false)
            return_re = 0 - return_re;
        return return_re;
    }
    public static void main(String[] args){
        Solution29 s = new Solution29();
        int results=s.divide(2444, 3);
        System.out.println(results);
    }
}