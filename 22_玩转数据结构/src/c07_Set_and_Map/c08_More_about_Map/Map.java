package c07_Set_and_Map.c08_More_about_Map;
public interface Map<K, V> {

    void add(K key, V value);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    V remove(K key);
    int getSize();
    boolean isEmpty();
}
