import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: Leetcode146_LRUcache
 * @Description:
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *  
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *
 * 示例：
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 *  
 *
 *
 * @Author: Jokey Zhou
 * @Date: 2020/5/25 11:17
 * @赛博世界并不是辽阔的荒野，数据也不全是冰冷的记录，它是亲人的笑靥，它是我们的记忆。
 */
public class Leetcode146_LRUcache {

    // 设置缓存容量
    private int capacity;
    // 使用LinkedHashMap来存储数据
    private Map<Integer, Integer> map = new LinkedHashMap<>();

    public Leetcode146_LRUcache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        // 如果这个key之前出现过
        if (map.containsKey(key)) {
            int value = map.get(key);
            // 将其移动到map的末尾
            map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // 如果key出现过，先移除
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() ==  capacity) {
            // 如果达到了缓存的容量上限，需要进行清除
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            // 移除map中的第一个元素
            iterator.next();
            iterator.remove();
        }
        map.put(key, value);
    }
}
