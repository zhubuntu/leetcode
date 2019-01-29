class Solution26 {
    public int removeDuplicates(int[] nums) {
        int end=1;
        int pre=nums[0];
        for(int i=1;i<nums.length;++i){
            if(nums[i]==pre)
                continue;
            pre=nums[i];
            nums[end]=nums[i];
            ++end;
        }
        return end;
    }
    public static void main(String[] args){
        Solution26 s = new Solution26();
        int[] nums={0,0,2,2,4};
        int results=s.removeDuplicates(nums);
        System.out.println(results);
    }
}