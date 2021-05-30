package MockTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
 * set(key, value)：将记录(key, value)插入该结构
 * get(key)：返回key对应的value值
 * [要求]
 * set和get方法的时间复杂度为O(1)
 * 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
 * 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 * 若opt=1，接下来两个整数x, y，表示set(x, y)
 * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
 * 对于每个操作2，输出一个答案
 */

// 方法：
// HashMap+自定义双向链表（链表节点为Node）
// 模拟LRU缓存机制
public class LRU_Map {
    //使用HashMap来存放数据
    private Map<Integer,Node> map = new HashMap<>();
    //模拟LRU缓存的Node链表，head为头节点，tail为尾节点，都不算在正式的缓存列表之中。
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);
    //缓存指定的大小
    private int k;

    //算法接口，通过该接口可以使用我们的缓存机制
    public int[] LRU (int[][] operators,int k){
        this.k = k;
        head.next = tail;
        tail.prev = head;
        //其实就是使用了stream流，来获取x[0]==2的个数，
        int len = (int) Arrays.stream(operators).filter(x -> x[0] == 2).count();
        int[] res = new int[len];
        for (int i = 0,j=0; i < operators.length; i++) {
            if (operators[i][0] == 1){
                set(operators[i][1],operators[i][2]);
            }else{
                res[j++] = get(operators[i][1]);
            }
        }
        return res;
    }

    //set操作，如果在map中出现过会直接更新，否则开始判断当前size，会导致新增（为插入前）或者替换
    private void set(int key,int val){
        if(map.containsKey(key)){
            map.get(k).val = val;
        }else{
            //表示当前缓存容量已满，需要移除缓存尾部的数据。
            if (k == map.size()){
                int rk = tail.prev.key;
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
                map.remove(rk);
            }
            //将新节点插入到hashmap中
            Node node = new Node(key,val);
            map.put(key,node);
            moveToHead(node);
        }
    }
    //get操作，试图获取key所对应的val
    private int get(int key){
        //判断当前map中是否存在key
        if (map.containsKey(key)){
            //获取到存储的key所对应的val
            Node node = map.get(key);
            //接下来将该节点从链表中取出
            //就是让该节点的前驱节点的next指向和该节点的后继节点,该节点的后继节点的prev指向该节点的前驱节点
            node.prev.next = node.next;
            node.next.prev = node.prev;
            //然后插入到缓存头部
            moveToHead(node);
            return node.val;
        }
        return -1;
    }
    //将被操作的节点放到缓存头部（head.next = 被操作的节点）
    private void moveToHead(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

//自定义双向链表的节点Node
class Node{
     int key;
     int val;
     Node prev,next;
    public Node(int key,int val){
        this.key = key;
        this.val = val;
    }
}