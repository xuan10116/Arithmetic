package DProgram;

public class Zero1backpack {
    public	static void main(String[] args) {
        int n = 5;
        int c = 10;
        //为使得构造的线索二维数组意义正确，用不相关的数字来使w，v数组各扩展一位
        int []w = {0,2,2,6,5,4};
        int []v = {0,6,3,5,4,6};
        int [][]m = new int[n+1][c+1];
        knapsack(v, w, c, m);
        System.out.println(m[1][c]);
        int []x = new int[6];
        traceback(m,w,c,x);
        for(int i : x)
            System.out.print(i);
    }
    public static void knapsack(int []v,int []w,int c,int [][]m){
        int n=v.length-1;
        int jMax = Math.min(w[n]-1,c);
        for(int j=0;j<=jMax;j++) m[n][j] = 0;
        for(int j=w[n];j<=c;j++) m[n][j] = v[n];
        for(int i=n-1;i>1;i--){
            jMax = Math.min(w[i]-1,c);
            for(int j=0;j<=jMax;j++) m[i][j] = m[i+1][j];
            for(int j=w[i];j<=c;j++) m[i][j] = Math.max(m[i+1][j],m[i+1][j-w[i]]+v[i]);
            m[1][c] = m[2][c];
            if(c>=w[1])
                m[1][c] = Math.max(m[1][c],m[2][c-w[1]]+v[1]);
        }
    }

    public static void traceback(int [][]m,int []w,int c,int []x){
        int n = w.length-1;
        for(int i=1;i<n;i++)
            if(m[i][c]==m[i+1][c])x[i]=0;
            else {
                x[i] = 1;
                c -= w[i];
            }
        x[n] = (m[n][c]>0)?1:0;
    }
}

