package c11_Minimum_Tree_Spanning.c09_Prim_Algorithm_Optimized;
public class Edge {

    private int v, w;

    public Edge(int v, int w){
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString(){
        return String.format("%d-%d", v, w);
    }
}