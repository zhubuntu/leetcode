class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] re = new int[2];
        int len = nums.length;
        for(int i=0; i<len;++i){
            int left = target - nums[i];
            for(int j=i+1;j<len;++j){
                if(nums[j] == left){
                    re[0]=i;
                    re[1]=j;
                    return re;
                }
            }
        }
        return re;
    }
    public static void main(String[] args){
        Solution1 s1= new Solution1();
        int[] k={2,2,3,4,5,6};
        int[] re=s1.twoSum(k,5);
        System.out.println(re[0]);
        System.out.println(re[1]);
    }
};