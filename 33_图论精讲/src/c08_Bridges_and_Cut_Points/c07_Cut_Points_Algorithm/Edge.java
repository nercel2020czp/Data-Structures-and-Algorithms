package c08_Bridges_and_Cut_Points.c07_Cut_Points_Algorithm;
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
