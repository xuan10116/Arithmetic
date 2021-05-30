package Test;

import org.junit.Test;

public class Hanoitower {

    @Test
    public void test(){
        hanoiTower(5,'A','B','C');
    }

    //num：有多少个盘子参与挪动，a是原地，b是中间结点，c是目的地
    public static void hanoiTower(int num, char a,char b,char c){
        //如果只有一个盘子
        if ( num==1) System.out.println("第1个盘从"+a+"->"+c);
        else{
            //如果盘子的数目大于二，我们总将一堆盘子看作两个盘子，1，最下面的一个盘子，2，上面的所有盘子
            //1，先将最上面的所有盘  A->B  ( 借助 C )
            hanoiTower(num-1,a,c,b);
            //2，将最下边的一个盘    A->C
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            //3，把B上的所有盘子从   B->C  ( 借助 A )
            hanoiTower(num-1,b,a,c);
        }
    }
}
