import java.util.Arrays;

class Solution31 {
    public void nextPermutation(int[] nums) {
        for(int i=nums.length-1;i>0;--i){
            if(nums[i]>nums[i-1]){
                int begin = i-1;
                int end = i;
                for(int j=i; j<nums.length;++j){
                    if(nums[j]>nums[i-1]) end = j;
                    else break;
                }
                int begin_value = nums[begin];
                nums[begin] = nums[end];
                nums[end] = begin_value;
                Arrays.sort(nums, begin+1, nums.length);
                return;
            }
        }
        Arrays.sort(nums, 0, nums.length);
    }
    public static void main(String[] args){
        Solution31 s = new Solution31();
        int[] nums={2,3,1};
        s.nextPermutation(nums);
        for(int i=0;i<nums.length;++i)
            System.out.println(nums[i]);

    }
}