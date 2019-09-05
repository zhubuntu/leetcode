import java.util.Arrays;

class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length+1][2];
        int curr=0;
        boolean find=false;
        if(intervals.length==0 || intervals[0][0]>newInterval[1]){
            find = true;
            result[curr++] = newInterval;
        }   
        for(int i=0;i<intervals.length;++i){
            boolean add = true;
            if(!(intervals[i][1]<newInterval[0]) && !(intervals[i][0]>newInterval[1])){
                newInterval[0]= Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                add = false;
            }

           if(!find && intervals[i][0]>newInterval[1]){
               find=true;
               result[curr] = newInterval;
               ++curr;
            }
            if(add)
            result[curr++] = intervals[i];
            
        }
        if(!find)
            result[curr++] = newInterval;
        return Arrays.copyOf(result, curr);
    }
    public static void main(String[] args) {
        int[][] intervals={{1,3},{6,9}};
        int[] newInterval={2,6};
        int[][] result= new Solution57().insert(intervals, newInterval);
        System.out.println(result);
    }
}