package c08_Heap_and_Priority_Queue.c07_Priority_Queue_Problems_in_Leetcode;
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
