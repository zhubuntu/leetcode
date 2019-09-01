import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution54 {
    
    public List<Integer> spiralOrder(int[][] matrix) {
    if(matrix.length==0 || matrix[0].length==0){
        return Collections.emptyList();
    }
    int xb=0, xe=matrix.length,yb=0,ye=matrix[0].length;
    int xc=0, yc=0;
    List<Integer> result = new ArrayList<>(matrix.length* matrix[0].length);
    while(result.size()<matrix.length* matrix[0].length){
        for(yc=yb;yc<ye;++yc) result.add(matrix[xc][yc]);
        ++xb;
        --yc;
        for(xc=xb;xc<xe;++xc)  result.add(matrix[xc][yc]);
        --ye;
        --xc;
        for(yc=ye-1;yc>=yb;--yc) result.add(matrix[xc][yc]);
        --xe;
        ++yc;
        for(xc=xe-1;xc>=xb;--xc) result.add(matrix[xc][yc]);
        ++yb;
        ++xc;
    } 
    return result;
}
public static void main(String[] args) {
    int[][] kk={{1,2,3,4},{5,6,7,8},{9,10,11,12}}
    ;
    new Solution54().spiralOrder(kk);
}
}