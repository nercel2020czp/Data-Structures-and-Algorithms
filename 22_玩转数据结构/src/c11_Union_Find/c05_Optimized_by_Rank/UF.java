package c11_Union_Find. c05_Optimized_by_Rank;


public interface UF {

    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
