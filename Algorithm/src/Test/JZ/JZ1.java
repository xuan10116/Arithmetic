package Test.JZ;
/*
*
描述
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
[
  [1,2,8,9],
  [2,4,9,12],
  [4,7,10,13],
  [6,8,11,15]
]
给定 target = 7，返回 true。
给定 target = 3，返回 false。
* */
public class JZ1 {
    //思路：从二维数组的右上角开始向左下方搜索
    public boolean Find(int target, int [][] array) {
        if (array == null) return false;
        //获取行数
        int rows = array.length;
        //获取列数
        int columns = array[0].length;

        //指定从右上角的元素开始搜索
        //当前行号和列号
        int row = 0,column = columns-1;

        while((row<rows)&&(column>=0)){
            //如果当前元素大于目标元素，则缩减列号
            if (array[row][column]>target){
                column --;
            }else if (array[row][column]<target){
                //如果当前元素小于目标元素，则增加行号
                row ++;
            }else
                return true;

        }

        return false;
    }
}
