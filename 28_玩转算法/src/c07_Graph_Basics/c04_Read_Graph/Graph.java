package c07_Graph_Basics.c04_Read_Graph;

// 图的接口
public interface Graph {

    public int V();
    public int E();
    public void addEdge( int v , int w );
    boolean hasEdge( int v , int w );
    void show();
    public Iterable<Integer> adj(int v);
}
