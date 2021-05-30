package Test.JZ;

import org.junit.Test;

import java.util.Arrays;

/*
* 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
* 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
* 并保证奇数和奇数，偶数和偶数之间的相对位置不变
* */
public class JZ13 {
    public int[] reOrderArray (int[] array) {
        if (array.length == 0 || array == null) return null;
        int[] result = new int[array.length];
        int ptr = 0;
        for (int i=0;i<array.length;i++){
            if ((array[i] & 1)==1){
                result[ptr] = array[i];
                ptr++;
            }
        }
        for (int i=0;i<array.length;i++){
            if ((array[i] & 1)==0){
                result[ptr] = array[i];
                ptr++;
            }
        }
        return result;
    }

    //my idea
    public int[] reOrderArray_2 (int[] array) {
        //思路从左边开始找奇数和偶数，（如果找到奇数就开始找偶数）
        int ptr1 = 0;
        int ptr2 = 0;
        int oldLocal = 0;
        int newLocal = 0;
        while(ptr1<array.length || ptr2<array.length){
            //先找偶数
            if ((newLocal = find2Index(ptr1,array)) != -1){
                ptr1 = newLocal;
                //当找到偶数之后就开始找奇数插入到他前面
                if((oldLocal = findno2Index(ptr1,array))!=-1){
                    insertpre(array,newLocal,oldLocal);
                }else{
                    return array;
                }
            }else{
                //再没有找到偶数
                return array;
            }
            ptr1 = newLocal;
            ptr2 = newLocal;
        }
        return array;
    }

    public int findno2Index(int start,int[] array){
        for (int i=start+1;i<array.length;i++){
            if ((array[i]&1)==1){
                return i;
            }
        }
        return -1;
    }
    public int find2Index(int start,int[] array){
        for (int i=start;i<array.length;i++){
            if ((array[i]&1)==0){
                return i;
            }
        }
        return -1;
    }
    public void insertpre(int[] array,int newLocal,int oldLocal){
        //先将原本位置上的奇数保存起来
        int temp = array[oldLocal];
        for (int i=oldLocal;i>newLocal;i--){
            array[i] = array[i-1];
        }
        array[newLocal] = temp;
    }

    @Test
    public void test01(){
        int[] array = {1,2,3,4,5,6,7};
        array = reOrderArray_2(array);
        for (int i : array) {
            System.out.println(i+" ");
        }
    }
}
