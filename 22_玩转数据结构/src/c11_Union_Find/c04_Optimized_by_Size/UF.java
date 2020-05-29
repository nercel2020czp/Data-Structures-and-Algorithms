package c11_Union_Find. c04_Optimized_by_Size;


public interface UF {

    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
