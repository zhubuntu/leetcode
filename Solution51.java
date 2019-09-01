import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

class Solution51 {
/*
标准的回溯方法解题，但是一般回溯方法会耗费大量的时间，所以经常需要加入修剪，例如本次中的useY，就是一个修剪

其实本题还可以继续修剪，就是斜线上的修剪，记录x+y和x-y的值，值相同的肯定也是不能摆的
*/
    public List<char[]> newNQueue(int n, List<char[]> origin){
        List<char[]> kk=new ArrayList<>();
            for(int i=0;i<n;++i){
                char[] nc=Arrays.copyOf(origin.get(i), n);
                kk.add(nc);
            }
        return kk;
    }
    public List<List<String>> solveNQueens(int n) {
        List<char[]> kk=new ArrayList<>();
        for(int i=0;i<n;++i){
            char[] c=new char[n];
            Arrays.fill(c, '.');
            kk.add(c);
        }
        boolean[] usedY = new boolean[n];
        Arrays.fill(usedY, false);
        List<List<char[]>> result = solveNQueens(kk, usedY, n, 0);
        List<List<String>> realResult = new ArrayList<>();
        
        for(int i=0;i<result.size();++i){
            realResult.add(new ArrayList<String>());
            for(int j=0;j<result.get(i).size();++j){
                realResult.get(i).add(String.valueOf(result.get(i).get(j)));
            }
        }
        return realResult;
    }
    public List<List<char[]>> solveNQueens(List<char[]> kk,boolean[] usedY, int n, int x){
        List<List<char[]>> result = new ArrayList<>();
        if(x==n){
            result.add(newNQueue(n, kk));
            return result;
        }
        for(int i=0;i<n;++i){
            if(usedY[i])
                continue;
            usedY[i] =true;
            kk.get(x)[i]= 'Q';
            if(validatePos(kk, x,i,x+1)){
                List<List<char[]>> tmpResult = solveNQueens(kk, usedY, n, x+1);
                result.addAll(tmpResult);
            }
            kk.get(x)[i]= '.';
            usedY[i]=false;
        }
        return result;
    }
    public boolean validatePos(List<char[]> curr,int x, int  y, int maxx){
        int size = curr.size();
        for(int i=x+1, j=y+1;i<maxx && j<size;++i,++j){
            if(curr.get(i)[j]=='Q')
                return false;
        }
        for(int i=x-1, j=y+1;i>=0 && j<size;--i,++j){
            if(curr.get(i)[j]=='Q')
                return false;
        }
        for(int i=x+1, j=y-1;i<maxx && j>=0;++i,--j){
            if(curr.get(i)[j]=='Q')
                return false;
        }
        for(int i=x-1, j=y-1;i>=0 && j>=0;--i,--j){
            if(curr.get(i)[j]=='Q')
                return false;
        }
        
        return true;
    }
   public static void main(String[] args) {
        List<List<String>> result = new Solution51().solveNQueens(4);
        System.out.println(result);
    }
}