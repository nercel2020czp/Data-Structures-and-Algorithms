package c08_Heap_and_Priority_Queue.c06_Priority_Queue;
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
