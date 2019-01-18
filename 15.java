import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, Integer> set_num = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;++i){
            set_num.put(nums[i], set_num.getOrDefault(nums[i], 0)+1);
        }
        for(Integer key1:set_num.keySet()){
            if(set_num.get(key1)==0)
                continue;
            int left1=0-key1;
            set_num.put(key1, set_num.get(key1)-1);
            for(Integer key2:set_num.keySet()){
                if(set_num.get(key2)==0)
                continue;
                int left2=left1-key2;
                set_num.put(key2, set_num.get(key2)-1);
                if(set_num.getOrDefault(left2, 0)!=0){
                    List<Integer> thisIn=new ArrayList<Integer>();
                    thisIn.add(key1);
                    thisIn.add(key2);
                    thisIn.add(left2);
                    result.add(thisIn);
                    set_num.put(key2, set_num.get(key2)-1);
                    set_num.put(left2, set_num.get(left2)-1);
                }
                set_num.put(key2, set_num.get(key2)+1);
            }
            set_num.put(key1, set_num.get(key1)+1);      
        }
        return result;
    }
    public static void main(String[] args){
        Solution15 s = new Solution15();
        int[] strs={12345,1236,-1,-12345,0};
        List<List<Integer>> result= s.threeSum(strs);
        System.out.print(result);
    }
}