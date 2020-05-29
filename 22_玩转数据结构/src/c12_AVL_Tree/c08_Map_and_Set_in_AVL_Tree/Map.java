package c12_AVL_Tree.c08_Map_and_Set_in_AVL_Tree;
public interface Map<K, V> {

    void add(K key, V value);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    V remove(K key);
    int getSize();
    boolean isEmpty();
}
