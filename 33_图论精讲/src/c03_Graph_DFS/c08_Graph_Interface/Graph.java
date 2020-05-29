package c03_Graph_DFS.c08_Graph_Interface;
public interface Graph {

    int V();
    int E();
    boolean hasEdge(int v, int w);
    Iterable<Integer> adj(int v);
    int degree(int v);
}
