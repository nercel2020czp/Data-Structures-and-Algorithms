package c07_Graph_Basics.Chapter_07_Completed_Code;

// 图的接口
public interface Graph {

    public int V();
    public int E();
    public void addEdge( int v , int w );
    boolean hasEdge( int v , int w );
    void show();
    public Iterable<Integer> adj(int v);
}