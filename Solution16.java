import java.util.HashSet;
import java.util.Set;
class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Set<Integer> set_num = new HashSet<Integer>();
        int num_len=0;
        for(int i=0;i<nums.length;++i){
            if(set_num.contains(nums[i]))
                continue;
            nums[num_len]=nums[i];
            ++num_len;
            set_num.add(nums[i]);
        }
        int min_change = Integer.MAX_VALUE;
        int target_re=0;
        for(int i=0;i<num_len-2;++i){
            int left1=target-nums[i];
            for(int j=i+1;j<num_len-1;++j){
                int left2=left1-nums[j];
                for(int k=j+1;k<num_len;++k){
                    int diff=Math.abs(nums[k]-left2);
                    if(diff<min_change){
                        min_change=diff;
                        target_re=nums[i]+nums[j]+nums[k];
                    }
                        
                }
            }
        }
        return target_re;
    }
    public static void main(String[] args){
        Solution16 s = new Solution16();
        int[] strs={12345,1236,-1,-12345,-2};
        int result= s.threeSumClosest(strs,5);
        System.out.print(result);
    }
}