import java.util.Arrays;
import java.util.Comparator;
class Solution56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0)
             return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int curr=0;
        for(int i=1;i<intervals.length;++i){
            if(intervals[curr][1]>=intervals[i][0]){
                intervals[curr][1]=Math.max(intervals[curr][1],intervals[i][1]);
            } 
            else{
                ++curr;
                intervals[curr]=intervals[i];
            }
        }
        return Arrays.copyOf(intervals, curr+1);
    }

    public static void main(String[] args) {
        int[][] intervals={{2,3},{5,5},{2,2},{3,4},{3,4}
        };
        int[][] result= new Solution56().merge(intervals);
    }
}