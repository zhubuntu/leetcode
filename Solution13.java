import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

///
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
///
class Solution13 {

    public int romanToInt(String s) {
        Map<Character,Integer> smap = new HashMap<Character, Integer>();
        Set<Character> minerSet = new HashSet<Character>();
        smap.put('I', 1);
        smap.put('V', 5);
        smap.put('X', 10);
        smap.put('L', 50);
        smap.put('C', 100);
        smap.put('D', 500);
        smap.put('M', 1000);
        minerSet.add('I');
        minerSet.add('X');
        minerSet.add('C');
        int re =0;
        for (int i=0; i<s.length();){
            Character k = s.charAt(i);
            if(i < s.length()-1 && minerSet.contains(k)){
                Character next = s.charAt(i+1);
                if(k.equals('I') && next.equals('V')){
                    re += 4;
                    i+=2;
                    continue;
                }
                if(k.equals('I') && next.equals('X')){
                    re += 9;
                    i+=2;
                    continue;
                }
                if(k.equals('X') && next.equals('L')){
                    re += 40;
                    i+=2;
                    continue;
                }
                if(k.equals('X') && next.equals('C')){
                    re += 90;
                    i+=2;
                    continue;
                }
                if(k.equals('C') && next.equals('D')){
                    re += 400;
                    i+=2;
                    continue;
                }
                if(k.equals('C') && next.equals('M')){
                    re += 900;
                    i+=2;
                    continue;
                }  
            }
            re += smap.get(k);
            ++i;
        }
        return re;
    }
    public static void main(String[] args){
        Solution13 s = new Solution13();
        int result= s.romanToInt("IX");
        System.out.print(result);
    }
}