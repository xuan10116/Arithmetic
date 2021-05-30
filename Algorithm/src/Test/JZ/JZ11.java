package Test.JZ;

/*
* 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
*
* 技巧思想： n & 1 会得到 n 的最低位上的数（0或1），随着n无符号向右移，我们每次对结果累加就是该数二进制表示中 1 的个数了。
* */
public class JZ11 {
    public int NumberOf1(int n) {
        int result = 0;
        while(n!=0){
//            n & 1 的结果就是当前最低为上的值，做累加就是含一的个数
            result += n&1;
//            将n无符号右移一位
            n>>>=1;
        }
        return result;
    }
}
