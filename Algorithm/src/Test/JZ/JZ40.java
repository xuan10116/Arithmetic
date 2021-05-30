package Test.JZ;

/*
* 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
*
* 思路，我们同样可以遍历数组使用map存储k为值，val为出现的次数，在遍历map找到符合要求的输出即可，方法太过低端。
* 技巧：我们需要知道，a^b^a = a^a^b = b^a^a =b，两个相同的数字异或结果全为 0，全0和数字异或为原数字。
* */
public class JZ40 {
    //这里我们使用异或来做这道题，首先遍历数组，将所有元素异或，那么得到的结果就是 两个不同数字异或的结果
    //我们重点就是将这两个二数字从以获得结果中分开来。
    public int[] FindNumsAppearOnce (int[] array) {
        //用来存储最后的结果
        int[] result = {0,0};
        //用来存储数组中所有元素的异或结果
        int x = array[0];
        //首先我们先将数组中所有的数据都异或
        for (int i=1;i<array.length;i++){
            x ^= array[i];
            //最后的得到的逻辑上（实际上也是）就是 x = result[0] ^ result[1];
        }
        int m=1;
        //通过m来确定result[0]和result[1]中不同的一个二进制位（该处找的是从低位到高位第一个不相同的数）
        while((m&x)==0){
            m = m<<1;
        }
        //通过m将原数组分开成两个子数组
        for(int i : array){
            if ((m&i) == 0){
                result[0] ^= i;
            }else{
                result[1] ^=i;
            }
        }
        if (result[0]>result[1]){
            int temp = result[0];
            result[0] = result[1];
            result[1] = temp;
        }
        return result;
    }
}
