package c07_Set_and_Map.c02_LinkedListSet;


public interface Set<E> {

    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}
