import java.util.Arrays;
import java.util.HashSet;

class Solution60 {
    public String getPermutation(int n, int k) {
        curr=0;
        int[] s = new int[n];
        boolean[] used = new boolean[n];
        Arrays.fill(used, false);
        int[] re=getNextSubPerm(s, 0, n,k, used);
        char[] sc = new char[n];
        for(int i=0;i<n;++i){
            sc[i]= (char)(re[i]+'0');
        }
        return new String(sc);
    }
    int curr=0;
    public int getLeftNum(int n){
        int result =1;
        for(int i=1;i<=n;++i)
            result*=i;
        return result;
    }
    public int[] getNextSubPerm(int[] now, int begin,int n, int k, boolean[] used){
        int left =n-begin;
        int num = getLeftNum(left);
        if(curr+num<k){
            curr+=num;
            return null;
        }
        if(begin == n){
            ++curr;
            if(curr==k)
                return now;
            return null;
        }
        for(int i=0;i<n;++i){
            if(used[i]) continue;
                now[begin] = i+1;
                used[i] = true;
                int[] re=getNextSubPerm(now, begin+1,n, k, used);
                if (re!=null)   return re;
                used[i] = false;
        }  
        return null;
    }
    public static void main(String[] args) {
        String result = new Solution60().getPermutation(3, 3);
        System.out.println(result);
    }
}