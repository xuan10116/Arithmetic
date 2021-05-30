package Test.JZ;
/*
*对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
*例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
* */
public class JZ43 {
    //借助StringBuilder构造指定旋转后的序列
    public String LeftRotateString(String str,int n) {
        if(str.length()==0 || n==0) return str;
        StringBuilder sb = new StringBuilder();
        sb.append(str,n,str.length());
        sb.append(str,0,n);
        return sb.toString();
    }
}
