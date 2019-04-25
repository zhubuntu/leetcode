class Solution27 {
    public int removeElement(int[] nums, int val) {

        int end=0;
        for(int i=0;i<nums.length;++i){
            if(nums[i]==val)
                continue;
            nums[end]=nums[i];
            ++end;
        }
        return end;
    }
    public static void main(String[] args){
        Solution27 s = new Solution27();
        int[] nums={0,0,2,2,4};
        int results=s.removeElement(nums, 3);
        System.out.println(results);
    }
}