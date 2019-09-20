import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: fangchengjin_sx
 * @date: 2019/9/2 15:31
 * @description:
 */
public class LRU<K, V> {

    private final int MAX_CACHE_SIZE;

    private final float LOAD_FACTOR = 0.75f;

    LinkedHashMap<K, V> map;

    public LRU(final int cacheSize) {
        MAX_CACHE_SIZE = cacheSize;
        // 防止自动扩容
        int capacity = (int) Math.ceil(MAX_CACHE_SIZE / LOAD_FACTOR) + 1;

        map = new LinkedHashMap<K, V>(capacity, LOAD_FACTOR, true) {
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > MAX_CACHE_SIZE;
            }
        };
    }

    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }

    public void remove(K key) {
        map.remove(key);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            stringBuilder.append(String.format("%s: %s  ", entry.getKey(), entry.getValue()));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LRU<Integer, Integer> lru = new LRU(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru);
        System.out.println(lru.get(2));
        lru.put(3, 3);
        System.out.println(lru);
        System.out.println(lru.get(1));

    }
}
