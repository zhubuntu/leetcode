class Solution33 {
    public int findRevert(int[] nums){
        int begin=0;
        int end=nums.length-1;
        int mid = (begin+end)/2;
        while(begin < end){
            mid =(begin+end)/2;
            if(nums[mid]> nums[end])
                begin = mid+1;
            else
                end = mid;
        }
        return mid;
    }
    public int find(int[] nums,int begin,int end, int target){
        while(begin < end){
            int mid =(begin+end)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid]> target)
                end = mid;
            else
                begin = mid+1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int rev = 0;
        if(nums[0]>nums[nums.length-1]){
            rev=findRevert(nums);
        }
        int k1=find(nums,0,rev,target);
        if(k1>=0)
            return k1;
        k1=find(nums,rev,nums.length,target);
        if(k1>=0)
            return k1;
        return -1;
    }
    public static void main(String[] args){
        Solution33 s = new Solution33();
        int[] nums={1,2,3,4,5,6};
        
        int result =s.search(nums, 6);
        System.out.println(result);
    }
}