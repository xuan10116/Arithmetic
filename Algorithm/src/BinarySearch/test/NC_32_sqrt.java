package BinarySearch.test;

public class NC_32_sqrt {
    public static int sqrt(int x){
        if (x<=0) return x;

        long left=0;
        long right=x;
        long middle = (left+right)>>1;
        while(left<right){
            if (middle*middle<x &&(middle+1)*(middle+1)>x) return (int)middle;
            else if (middle*middle>x) right = middle;
            else left = middle;
        }

        return (int)left;
    }
}
