package Test.JZ;

/*
* 描述
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

保证base和exponent不同时为0。不得使用库函数，同时不需要考虑大数问题，也不用考虑小数点后面0的位数。
* */
//数值的整数次方
public class JZ12 {
    //方法一：暴力递归
    public double Power(double base, int exponent) {
        if (exponent == 0) return 1.0D;
        if (exponent == 1) return base;
        int z = Math.abs(exponent);
        double result = 1.0D;
        for(;z>0;z--){
            result *= base;
        }
        return exponent > 0 ? result : (1/result);
    }

    //方法二：非递归的快速幂
    /*
    * 快速幂计算过程就是将 x^n 化为
    * n为偶数：x^n = ( x^(n/2) )^2
    * n为奇数：x^n = (( x^(n/2) )^2) * x
    * */
    public double Power2(double base, int exponent) {
        if (exponent == 0) return 1.0D;
        if (exponent == 1) return base;
        double result = 1.0D;
        boolean flag = exponent>0;
        int p = flag ? exponent : -exponent;
        while(p>0){
            if ((p&1)==1) result *= base;
            base *= base;
            p >>= 1;
        }
        return flag ? result : 1/result;
    }
}
