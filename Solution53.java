class Solution53 {
    public int maxSubArray(int[] nums) {
        int sums[] = new int[nums.length+1];
        int mins[]=new int[nums.length];
        int result =nums[0];
        for(int i=0;i<nums.length;++i){
            sums[i+1]= sums[i]+nums[i];
            mins[i]=Math.min(mins[i],sums[i]);
        }
        int max=sums[nums.length];
        for(int j=nums.length-1;j>0;--j){
            max = Math.max(max, sums[j+1]);
            result = Math.max(result, max-mins[j]);
        }
        return result;
       
    }
    public static void main(String[] agrs){
            int[] nums= {-4,-2,-3,-4,-5};
            int result = new Solution53().maxSubArray(nums);
            System.out.println(result);
    }
}