package Test;

import java.util.ArrayList;
import java.util.List;

/*
* 约瑟夫环问题
*
编号为 1 到 n 的 n 个人围成一圈。从编号为 1 的人开始报数，报到 m 的人离开。
下一个人继续从 1 开始报数。
n−1 轮结束以后，只剩下一个人，问最后留下的这个人编号是多少？
* */
public class ysfCircle {
    public int ysf (int n, int m) {
        //首先我们将人员编号都存储到链表中
        List<Integer> position = new ArrayList<>();
        //人员是从 1 开始编号的
        for (int i=1;i<=n;i++) position.add(i);
        //待删除的编号index，
        int index = 0;
        //当ArrayList中只剩下最后一个人的时候，就可以退出了
        while(position.size()>1){
            index = (index+m-1)%(position.size());
            position.remove(index);
        }
        //返回还留在链表中的编号
        return position.get(0);
    }
}
