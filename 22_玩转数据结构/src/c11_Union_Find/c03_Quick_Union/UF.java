package c11_Union_Find. c03_Quick_Union;


public interface UF {

    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
