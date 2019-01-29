class Solution34 {
    public int getChange(int[] nums, int same,int diff,int target){
        int mid =(same+diff)/2;
        if(same==diff){
            return same;
        }
        int change=Math.abs(same-diff)/(same-diff);
        System.out.println(change);
        while(same!=diff){
            //System.out.println(diff);
            
            if(nums[mid] ==target)
                same = mid;
            else
                diff = mid+change;
        }
        return same;
    }
    public int[] searchRange(int[] nums, int target) {
        int begin=0;
        int end=nums.length;
        int mid=0;
        int[] result=new int[2];
        while(begin<end){
            mid=(begin+end)/2;
            if(nums[mid]<target){
                begin=mid+1;
            }
            else if(nums[mid]>target){
                end=mid;
            }
            else{
                    result[0]=getChange(nums, mid, 0, target);
                    result[1]=getChange(nums, mid, nums.length-1, target);
                    break;
                }
            }
            return result;
        }
    public static void main(String[] args){
        Solution34 s = new Solution34();
        int[] nums={1,2,6,6,6,6};
        
        int[] result =s.searchRange(nums, 6);
        System.out.println(result);
    }
}