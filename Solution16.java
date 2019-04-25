import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int error=100000000;
        int target_re = 0;
        for(Integer k1=0; k1<nums.length; ++k1){
            int k1_target = target - nums[k1];
            Integer k2=k1+1, k3=nums.length-1;
            while(k2<k3){
                int curr = nums[k2] + nums[k3];
                int curr_error = Math.abs(k1_target - curr);
                if(curr_error < error){
                    error = curr_error;
                    target_re = curr + nums[k1];
                }
                if(curr < k1_target){
                    ++k2;
                }
                else{
                    --k3;
                }
            }
        }
        return target_re;
    }
    public static void main(String[] args){
        Solution16 s = new Solution16();
        int[] strs={1,1,-1,-1,3};
        int result= s.threeSumClosest(strs,-1);
        System.out.print(result);
    }
}