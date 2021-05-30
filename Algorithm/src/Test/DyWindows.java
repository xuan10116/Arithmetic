package Test;

import org.junit.Test;

/**
 * 滑动窗口
 */
public class DyWindows {
    @Test
    public void test01(){
        String s = "tbcacbdata";
        char[] chars = {'a','b','c','d'};
        System.out.println(te01.checkInclusion(chars, s));
    }
}

/*
给定m个不重复的字符 [a, b, c, d]，以及一个长度为n的字符串tbcacbdata
问能否在这个字符串中找到一个长度为m的连续子串，使得这个子串刚好由上面m个字符组成，顺序无所谓.
返回任意满足条件的一个子串的起始位置，未找到返回-1。比如上面这个例子，acbd，3。
本题的子串需要满足长度为m，字符不重复，可以使用长为m的滑动窗口遍历字符串，
窗口内每个字符都要出现一次，如果符合条件，就返回窗口起始位置。
 */
class te01{
    public static int checkInclusion(char[] ch,String s){
        int n=s.length();
        int m = ch.length;
        if(m>n) return -1;
        //用来限制滑动窗口的移动次数
        for(int i=0;i<n-m;i++){
            if(checkEqual(ch,s.substring(i,i+m))){
                return i;
            }
        }
        return -1;
    }

    //用来检查给定的 字符数组中 的 字符 是否 全都 在“同等长度”的字符串中 唯一出现
    public static boolean checkEqual(char[] ch,String s){
        //逐一检查数组中的字符是否在字符串中出现过
        for (char c : ch) {
            if (s.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }
}