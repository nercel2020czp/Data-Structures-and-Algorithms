package c11_Union_Find. c02_Quick_Find;



public interface UF {

    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
