///
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
///
class Solution12 {
    String getThisPart(int k,String f10, String f5,String f1){
        String re="";
        if(k == 9)
            return f1+=f10;
        else if(k >=5 ){
            re+=f5;
            k=k-5;
        }
        if(k==4)
            re+=f1+=f5;
        else{
            for(int i=0;i<k;++i)
                re+=f1;
        }
        return re;
    }
    public String intToRoman(int num) {
        
        String re = "";
        int k=0;
        k = num/1000;
        num=num%1000;
        for(int i=0;i<k;++i)
            re +="M";
        k = num/100;
        num=num%100;
        re+=this.getThisPart(k, "M", "D", "C");
        k = num/10;
        num=num%10;
        re+=this.getThisPart(k, "C", "L", "X");
        k=num;
        re+=this.getThisPart(k, "X", "V", "I");
        return re;        
    }
    public static void main(String[] args){
        Solution12 s = new Solution12();
        String result= s.intToRoman(58);
        System.out.print(result);
    }
}