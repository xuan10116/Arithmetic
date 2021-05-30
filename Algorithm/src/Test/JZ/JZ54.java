package Test.JZ;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class JZ54 {

    HashMap<Character,Integer> chars = new HashMap<>();
    LinkedList<Character> queue = new LinkedList<>();
//方法一：我的思想比较简单，就是先将所有的字符都存储起来，然后再做
    public void init(){
        for(char ch = 'a';ch <='z';ch++){
            chars.put(ch,0);
        }
    }
    public void Insert(char ch)
    {
        //元素首次出现
        if (chars.get(ch)==0){
            queue.add(ch);
            chars.put(ch,1);
        }else if (chars.get(ch) == 1){//元素再次出现
            queue.remove(Character.valueOf(ch));
            chars.put(ch,2);
        }else{//元素重复出现
            chars.put(ch,3);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char ans;
        try{
            ans = queue.getFirst();
        }catch(Exception e){
            return '#';
        }
        return ans;
    }

//    通用的输出函数
    public void caseout(String str){
        char[] stream = str.toCharArray();
        StringBuilder re = new StringBuilder();
        for (char c : stream) {
            Insert(c);
            re.append(FirstAppearingOnce());
        }
        System.out.println(re.toString());
    }


//方法二：一开始不存储所有字符，随着字符流的输入再存储
    int[] charSet = new int[128];
    Queue<Character> charactersqueue = new LinkedList<>();
    public void Insert02(char ch)
    {
        if (charSet[ch]++ == 0) queue.add(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce02()
    {
        Character CHAR = null;
        char c = 0;
        while((CHAR = queue.peek()) != null){
            c = CHAR.charValue();
            if (charSet[c] == 1) return c;
            else charactersqueue.remove();
        }
        return '#';
    }

//    方法测试
    @Test
    public void test01(){
        init();
        String str = "google";
        caseout(str);
    }
}
