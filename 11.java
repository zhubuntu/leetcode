import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

class Solution11 {
    public int maxArea(int[] height) {
        int max_area=0;
        int max_left=0;
        int max_right=0;
        for(int i=0;i<height.length;++i){
            if(height[i]<=max_left)
                continue;
            max_left = height[i];
            max_right =0;
            for(int j=height.length -1 ;j>i;--j){
                if(height[j]<=max_right)
                    continue;
                max_right = height[j];
                int area = (j-i)*Integer.min(height[i], height[j]);
                if(area>max_area)
                    max_area =area;
            }
        }
        return max_area;
    }
    public static void main(String[] args){
        Solution11 s = new Solution11();
        int[] height ={1,8,6,2,5,4,8,3,7};
        int result= s.maxArea(height);
        System.out.print(result);
    }
}