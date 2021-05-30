package Test;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Stack;

public class BigNumberPlus {

    @Test
    public void test01(){
        String s = "1";
        String t = "99";
        String sum = plus01(s,t);
        System.out.println(sum);
    }
    @Test
    public void test02(){
        String s = "11";
        String t = "99";
        String sum = plus02(s,t);
        System.out.println(sum);
    }
    @Test
    public void test03(){
        String s = "11";
        String t = "99";
        String sum = plus03(s,t);
        System.out.println(sum);
    }

    //1,创建新的字符串，字符从尾部插入，最后反转新的字符串
    public String plus01(String s,String t){
        StringBuilder stringbuilder = new StringBuilder();
        int i=s.length()-1,j=t.length()-1,carry=0;
        while(i >= 0 || j >= 0 || carry != 0){
            int x = i < 0 ? 0 : s.charAt(i--) - '0';
            int y = j < 0 ? 0 : t.charAt(j--) - '0';
            int sum = x + y + carry;
            stringbuilder.append(sum % 10);
            carry = sum / 10;
        }
        return stringbuilder.reverse().toString();
    }

    //2,创建新的字符串，字符从头部插入，最后无需反转
    public String plus02(String s,String t){
        StringBuilder stringbuilder = new StringBuilder();
        int i = s.length()-1,j=t.length()-1,carry=0;
        while(i >= 0 || j >=  0 || carry >= 0 ){
            int x = i < 0 ? 0 : s.charAt(i--) - '0';
            int y = j < 0 ? 0 : t.charAt(j--) - '0';
            int sum = x + y + carry;
            stringbuilder.insert(0,sum % 10);
            carry = sum/10;
        }
        return  stringbuilder.toString();
    }

    //3,使用栈存储同位数上的数字的和，进位用carry记录，留给下一位,最后将stack进行pop()返回值append()在StringBuilder中
    public String plus03(String s,String t){
        Stack<Integer> resres = new Stack<>();
        int i = s.length()-1,j = t.length() - 1,carry = 0;
        while(i >= 0|| j >= 0 || carry != 0){
            int x = i < 0 ? 0 : s.charAt(i--)-'0';
            int y = j < 0 ? 0 : t.charAt(j--)-'0';
            int sum = x + y + carry;
            resres.push(sum % 10);
            carry = sum >= 10 ? 1 : 0;
        }
        StringBuilder res = new StringBuilder();
        while(!resres.empty()){
            res.append(resres.pop());
        }
        return res.toString();
    }
    //4,直接使用Java的大数类
    public String plus04(String s,String t){
        BigInteger bigInteger1 = new BigInteger(s);
        BigInteger bigInteger2 = new BigInteger(t);

        return bigInteger1.add(bigInteger2).toString();
    }
}
