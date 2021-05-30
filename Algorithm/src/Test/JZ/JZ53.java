package Test.JZ;

import org.junit.Test;

import java.util.regex.Pattern;

/*
* 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
* 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
*       但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
* */
public class JZ53 {

    @Test
    public void test03(){
       String str = "-.123";
       boolean result = isNumeric03(str);
       System.out.println(result);
    }
    //最针对的解，自定义逻辑判断字符串是否可以表示数字
    int index;//当前判断到的位置，因为该方法调用用的多个方法也需要该参数，所以写在方法外
    public boolean isNumeric03 (String str) {
        if ((str == null || str.length() == 0)) return false;
        //将字符串转化为字符数组
        char[] cs = str.toCharArray();
        //判断小数前的位置
        index = 0;
        boolean flag = scanInteger(cs);
        //判断小数后的位置
        if(index < cs.length && cs[index]=='.'){
            index++;//跳过小数点，开始判断小数点之后的数字
            //为什么是 || 不是&&，因为"-.123"这种小数点前可能没有数字
            flag = scanUnInteger(cs)||flag;
        }
        //判断E,e
        if(index < cs.length && (cs[index]=='E'||cs[index]=='e')){
            index++;
            flag = flag&&scanInteger(cs);
        }
        return flag && index==cs.length;
    }
    public boolean scanInteger(char[] cs){
        if (index < cs.length && (cs[index]=='-' || cs[index]=='+')) index++;
        return scanUnInteger(cs);
    }
    public boolean scanUnInteger(char[] cs){
        int temp = index;
        while(index < cs.length && cs[index]>='0' && cs[index] <='9') index++;
        return index >temp;
    }

    //通过Double的解析方法
    public boolean isNumeric01 (String str) {
        //该方法调用的内部方法有150行之多
        try {
            double result = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    //正则表达式，题解中有，不过排行中没有使用正则表达式写的（估计是太复杂效率不高）
    public boolean isNumeric02 (String str) {
        // write code here
        if(str==null || str.length()==0){
            return false;
        }
        //不带eE允许前置空，eg：-.1415926,不允许前置0，eg：+03.1415
        //应该允许eg：-.123(相当于-0.123)   -123.（相当于-123.0）   但不允许（-.或+.或-+）
        String regex1 = "([-+]{0,1}[1-9]{1}\\d*(\\.\\d*)?)|([-+]{0,1}(0((\\.\\d*)?)|((\\.\\d+){1})))|(([-+]{0,1})(\\.\\d+){1})";
        //带eE前面不能出现小数点前为0或空，eg：-0.45e+3，-.45e+3都是不对的
        String regex2 = "^[-+]{0,1}[1-9]{1}\\d*(\\.\\d+)?([eE]{1}[-+]{0,1}[1-9]{1}\\d*)?$";
        return Pattern.matches(regex1,str) || Pattern.matches(regex2,str);
    }

}
