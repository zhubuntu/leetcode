class Solution31 {
    public void revertNum(int[] nums, int begin){
        int mid_len=(begin+nums.length)/2;
        for(int i=begin;i<mid_len;++i){
            int end = nums.length-(i-begin)-1;
            int mid=nums[end];
            nums[end]=nums[i];
            nums[i]=mid;
        }
    }
    public void nextPermutation(int[] nums) {
        for(int i=nums.length-1;i>0;--i){
            if(nums[i]>nums[i-1]){
                int mid=nums[nums.length-1];
                for(int j=nums.length-2;j>=i-1;--j){
                    nums[j+1]=nums[j];
                }
                nums[i-1]=mid;
                return;
            }
        }
        revertNum(nums, 0);
    }
    public static void main(String[] args){
        Solution31 s = new Solution31();
        int[] nums={1,4,2,5,3};
        s.nextPermutation(nums);
        for(int i=0;i<nums.length;++i)
        System.out.println(nums[i]);
    }
}